@echo off
setlocal enabledelayedexpansion

:: --- 1. CONFIGURAÇÃO (VERIFIQUE SE O ARQUIVO EXISTE NESTE CAMINHO) ---
set ANTLR_JAR=C:\Users\leand\Downloads\Interpreter_Mini_C-main\Lang\antlr-4.13.2-complete.jar

:: Se nao achar no caminho acima, tenta na pasta Downloads padrao (backup)
if not exist "!ANTLR_JAR!" (
    set ANTLR_JAR=C:\Users\leand\Downloads\antlr-4.13.2-complete.jar
)

if not exist "!ANTLR_JAR!" (
    echo [ERRO CRITICO] Nao encontrei o antlr-4.13.2-complete.jar!
    echo Por favor, verifique o caminho na linha 4 do arquivo run.bat
    pause
    exit /b
)

echo.
echo ==========================================================
echo [PASSO 1] LIMPEZA (Apagando versoes antigas...)
echo ==========================================================
:: Apaga tudo para garantir que nao sobre nada velho
if exist *.class del /q *.class
if exist Lang\*.class del /q Lang\*.class
if exist Grammar\*.class del /q Grammar\*.class
if exist grammar\*.class del /q grammar\*.class

:: Apaga os arquivos Java gerados pelo ANTLR para forcar recriacao
if exist Grammar\LangParser.java del Grammar\LangParser.java
if exist Grammar\LangLexer.java del Grammar\LangLexer.java
if exist grammar\LangParser.java del grammar\LangParser.java
if exist grammar\LangLexer.java del grammar\LangLexer.java

echo.
echo ==========================================================
echo [PASSO 2] GERANDO NOVO PARSER (Fundamental!)
echo ==========================================================
:: Cria a pasta grammar se nao existir (padrao minsculo para bater com o package)
if not exist grammar mkdir grammar

:: Gera o parser novo baseado no seu Lang.g4 atualizado
:: O -o grammar joga os arquivos .java dentro da pasta grammar
java -jar "!ANTLR_JAR!" -package grammar -no-listener -visitor -o grammar Lang.g4

if errorlevel 1 (
    echo [ERRO] O ANTLR falhou. Verifique se o arquivo Lang.g4 esta na mesma pasta deste script.
    pause
    exit /b
)

echo.
echo ==========================================================
echo [PASSO 3] COMPILANDO TUDO (Java)
echo ==========================================================
:: Compila o Main, o Parser novo (em grammar) e sua Logica (em Lang)
javac -cp ".;!ANTLR_JAR!" grammar/*.java Lang/*.java Main.java

if errorlevel 1 (
    echo [ERRO] Falha na compilacao do Java. Verifique os erros acima.
    pause
    exit /b
)

echo.
echo ==========================================================
echo [PASSO 4] EXECUTANDO O INTERPRETADOR
echo ==========================================================
java -cp ".;!ANTLR_JAR!" Main input.lang

echo.
pause