grammar While;
options { output=AST; }
tokens {
	PROGRAM;
	FUNCTION;
	INPUTS;
	OUTPUTS;
	COMMANDS;
	EXPRS;
	VARS;
	NOP;
	LET;
	IF;
	WHILE;
	FOR;
	FOREACH;
	TL;
	LIST;
	CONS;
	HD;
	SYMB;
	NIL;
}
// Structure principale
program : function+ -> ^(PROGRAM function+);

function : 'function' Symbol ':' definition -> ^(FUNCTION Symbol definition);

definition : 'read' input '%' commands '%' 'write' output-> input commands output;

// Gestion des entrées
input  : inputSub-> inputSub;
inputSub : Variable? (',' Variable)*-> ^(INPUTS Variable*);

// Gestion des sorties
output :Variable (',' Variable)* -> ^(OUTPUTS Variable+);

// Listes des commandes
commands : command (';' command)*  -> ^(COMMANDS command+);

// Expressions multiples
exprs : expression (',' expression)*-> ^(EXPRS expression+);
// Variables multiples
vars : Variable (',' Variable)* -> ^(VARS Variable+);

command	:	'nop' -> NOP
    	| 	vars ':=' exprs -> ^(LET vars exprs)
	|	'if' expression 'then' commands ('else' commands)? 'fi' -> ^(IF expression commands commands?)
	|	'while' expression 'do' commands 'od' -> ^(WHILE expression commands)
	|	'for' expression 'do' commands 'od' -> ^(FOR expression commands)
	|	'foreach' Variable 'in' expression 'do' commands 'od' -> ^(FOREACH Variable expression commands);

// Expressions de base
exprBase
    : '(' 'cons' lexpr ')'-> ^(CONS lexpr?) | '(' 'list' lexpr ')'-> ^(LIST lexpr?)
    | '(' 'hd' exprBase ')'-> ^(HD exprBase) | '(' 'tl' exprBase ')'-> ^(TL exprBase)
    | '(' Symbol lexpr ')'-> ^(SYMB Symbol lexpr?)
    | 'nil' -> NIL | Variable-> Variable | Symbol -> Symbol
    ;                     

// Expression principale
expression : exprBase ('=?' exprBase)?-> exprBase+;  // Comparaison d'expressions

// Liste d'expressions
lexpr : exprBase*  -> exprBase*;

// Variables et symboles
Variable : 'A'..'Z' ('A'..'Z' | 'a'..'z' | '0'..'9')* ('!' | '?')? ;  // Variables commençant par une majuscule
Symbol : 'a'..'z' ('A'..'Z' | 'a'..'z' | '0'..'9')* ('!' | '?')? ;    // Symboles commençant par une minuscule

WS  :   ( ' ' | '\t' | '\r' | '\n') {$channel=HIDDEN;};