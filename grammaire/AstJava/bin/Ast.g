grammar Ast;

options { output=AST; }
tokens {
	PROGRAM;
	FUNCTION;
	INPUT;
	INPUTSUB;
	CALL;
	HD;
	NIL;
	VAR;
	TLLIST;
	CONS;
	VARS;
	EXPRS;
	EXPRESSIONS;
	WHILE;
	OUTPUTS;
	COMMANDS;
	LIST;
	TL;
	SYM;
	LEXPR;
	OUTPUT;
	DEFINITION;
	EXPRESSION;
	ASSIGN;
	NOP;
	FOR;
	IF;
	ELSE;
	
}

// Structure principale
program : function+ EOF -> ^(PROGRAM function+);

function : 'function' Symbol ':' definition -> ^(FUNCTION Symbol definition);

definition : 'read' input '%' commands '%' 'write' output 
           -> ^(DEFINITION input commands output);

// Gestion des entrées
input  : inputSub? -> ^(INPUT inputSub?);
inputSub : Variable (',' Variable)* -> ^(INPUTSUB Variable*);

// Gestion des sorties
output : Variable (',' Variable)* -> ^(OUTPUT Variable*);

// Listes des commandes
commands : command (';' commands)? -> ^(COMMANDS command+);

command
    : 'if' expression 'then' commands ('else' commands)? 'fi'
      -> ^(IF expression commands ^(ELSE commands)?)
    | 'while' expression 'do' commands 'od'
      -> ^(WHILE expression commands)
    | 'for' expression 'do' commands 'od'
      -> ^(FOR expression commands)
    | 'nop'
      -> ^(NOP)
    | vars ':=' expression
      -> ^(ASSIGN vars expression)
    ;

// Variables multiples
vars : Variable (',' Variable)* -> ^(VARS Variable+);

// Expressions multiples
exprs : expression (',' expression)* -> ^(EXPRS expression+);

// Expression principale
expression : exprBase ('=?' exprBase)? 
           -> ^(EXPRESSION exprBase ('=?' exprBase)?);

// Expressions de base
exprBase
    : '(' 'cons' lExpr ')' -> ^(CONS lExpr)
    | '(' 'list' lExpr ')' -> ^(LIST lExpr)
    | '(' 'hd' exprBase ')' -> ^(HD exprBase)
    | '(' 'tl' exprBase ')' -> ^(TL exprBase)
    | '(' Symbol lExpr ')' -> ^(CALL Symbol lExpr)
    | 'nil' -> ^(NIL)
    | Variable -> ^(VAR Variable)
    | Symbol -> ^(SYM Symbol)
    ;

// Liste d'expressions
lExpr : exprBase+ -> ^(LEXPR exprBase+);

// Variables et symboles
Variable : 'A'..'Z' ('A'..'Z' | 'a'..'z' | '0'..'9')* ('!' | '?')? ;  
Symbol : 'a'..'z' ('A'..'Z' | 'a'..'z' | '0'..'9')* ('!' | '?')? ;   

//WS  :   (' ' | '\t' | '\r' | '\n') -> skip;
WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;
