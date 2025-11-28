grammar Lang;

prog
  : (preprocessorDirective | declaration)* 
  ;

preprocessorDirective
  : INCLUDE LIB
  ;

declaration
  : structdecl
  | uniondecl
  | function
  | globalVariable
  ;

globalVariable
  : DEFINE VAR ('[' NUM ']')? ((AT)? expression)? EOL
  ;


function
  : typeSpec VAR '(' params? ')' fnBlock
  | typeSpec MAIN '(' ')' fnBlock
  ;

fnBlock
  : '{' fnBodyList? '}'
  ;

fnBodyList
  : fnBodyItem+
  ;

fnBodyItem
  : line
  | RETURN expression? EOL
  ;

params
  : typeSpec VAR (SEP typeSpec VAR)* 
  ;

line
  : stmt EOL?
  | ifstmt
  | dowhilestmt
  | whilestmt
  | forstmt
  | switchstmt
  | fnBlock
  | EOL
  ;

stmt
  : atrib
  | arraydecl
  | pointerdecl
  | pointerassign
  | pointerdereference
  | structdeclaration
  | structaccess
  | uniondeclaration
  | unionaccess
  | input
  | output
  | funcinvoc
  ;

atrib
  : typeSpec VAR (AT expression)?
  | typeSpec VAR AT funcinvoc
  | VAR AT expression
  | VAR '++'
  | VAR '--'
  | VAR '+=' expression
  | VAR '-=' expression
  ;

arraydecl
  : typeSpec VAR '[' NUM ']' (AT '{' arrayelems '}')? 
  ;

arrayelems
  : expression (SEP expression)*
  ;

pointerdecl
  : typeSpec '*' VAR
  ;

pointerassign
  : VAR AT '&' VAR
  ;

pointerdereference
  : '*' VAR AT expression
  ;

structdeclaration
  : STRUCT VAR VAR 
  ;

structaccess
  : VAR '.' VAR (AT expression)?
  ;

uniondeclaration
  : UNION VAR VAR 
  ;

unionaccess
  : VAR '.' VAR (AT expression)?
  ;

input
  : SCAN '(' FORMATSTRING (SEP '&' VAR)+ ')'
  | GETS '(' VAR ')'
  ;

output
  : PRINT '(' FORMATSTRING (SEP expression)* ')'
  | PUTS '(' VAR ')'
  ;

ifstmt
  : IF '(' cond ')' fnBlock (ELSE fnBlock)?
  ;

dowhilestmt
  : DO fnBlock WHILE '(' cond ')' EOL
  ;

whilestmt
  : WHILE '(' cond ')' fnBlock
  ;

forstmt
    : FOR '(' atrib ';' cond ';' atrib ')' fnBlock  
    ;


switchstmt
  : SWITCH '(' VAR ')' '{' caseClause* defaultClause? '}'
  ;

caseClause
  : CASE NUM ':' line+ BREAK EOL
  ;

defaultClause
  : DEFAULT ':' line+ BREAK EOL
  ;

cond
  : cond RELOP cond
  | expression
  | cond AND cond
  | cond OR cond
  | NOT cond
  ;

expression
  : term (termTail)*
  | VAR '++'
  | VAR '--'
  ;

termTail
  : (PLUS | MINUS)* term
  ;

term
  : factor (factorTail)*
  ;

factorTail
  : (MULT | DIV | MOD)* factor
  ;

factor
  : '(' expression ')'
  | VAR
  | structaccess
  | unionaccess
  | NUM
  | DECIM
  | funcinvoc
  ;

structdecl
  : STRUCT VAR '{' structfieldList? '}' EOL
  ;

structfieldList
  : structfields+
  ;

structfields
  : typeSpec VAR EOL
  ;

uniondecl
  : UNION VAR '{' unionfieldList? '}' EOL
  ;

unionfieldList
  : unionfields+
  ;

unionfields
  : typeSpec VAR EOL
  ;

typeSpec
  : INT
  | FLOAT
  | CHAR
  | DOUBLE
  | VOID
  ;

funcinvoc
  : VAR '(' argumentos? ')'
  ;

argumentos
  : expression (SEP expression)*
  ;

INCLUDE: '#include';
DEFINE: '#define';
EOL: ';';
LIB: '<' ~[>]+ '>';
COMMENTLINE: '//' ~[\r\n]* -> skip;
COMMENTBLOCK: '/*' .*? '*/' -> skip;

INT: 'int';
FLOAT: 'float';
CHAR: 'char';
DOUBLE: 'double';
VOID: 'void';
MAIN: 'main';

RETURN: 'return';
SCAN: 'scanf';
PRINT: 'printf';
GETS: 'gets';
PUTS: 'puts';
STRUCT: 'struct';
UNION: 'union';
IF: 'if';
ELSE: 'else';
SWITCH: 'switch';
CASE: 'case';
BREAK: 'break';
DEFAULT: 'default';
WHILE: 'while';
FOR: 'for';
DO: 'do';

VAR: [a-zA-Z_][a-zA-Z0-9_]*;
NUM: [0-9]+;
DECIM: [0-9]+ '.' [0-9]+;

PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
AND: '&&';
OR: '||';
NOT: '!';
RELOP: '==' | '!=' | '<' | '<=' | '>' | '>=';
AT: '=';
SEP: ',';
DOT: '.';

FORMATSTRING: '"' .*? '"';

WS: [ \t\r\n]+ -> skip;