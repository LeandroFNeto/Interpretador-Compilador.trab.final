@echo off
setlocal enabledelayedexpansion

set ANTLR_JAR=C:\Users\user\Downloads\antlr-4.13.2-complete.jar

echo ==========================================================
echo [INFO] Compiling Java files...
echo ==========================================================

javac -cp .;%ANTLR_JAR% Grammar\*.java Lang\*.java Main.java

if errorlevel 1 (
    echo [ERROR] Compilation failed.
    pause
    goto end
)

echo.
echo ==========================================================
echo [INFO] Running interpreter...
echo ==========================================================

java -cp .;%ANTLR_JAR% Main

echo.
echo ==========================================================
echo [INFO] Execution finished.
echo ==========================================================

pause

:end
exit
