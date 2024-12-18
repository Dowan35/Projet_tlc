grammar While;

// Structure principale
program : function+ EOF ;

function : 'function' Symbol ':' definition;

definition : 'read' input '%' commands '%' 'write' output;

// Gestion des entrées
input  : inputSub;
inputSub : Variable? (',' Variable)*;

// Gestion des sorties
output 	:	Variable (',' Variable)*;

// Listes des commandes
commands : command (';' commands)? ;

command
    : 'if' expression 'then' commands ('else' commands)? 'fi'     // Conditionnelle
    | 'while' expression 'do' commands 'od'                        // Boucle while
    | 'for' expression 'do' commands 'od'                           // Boucle for
    | 'nop'                                                          // Pas d'opération
    | vars ':=' expression                                           // Affectation
    ;

// Variables multiples
vars : Variable (',' Variable)*;

// Expressions multiples
exprs : expression (',' expression)*;

// Expression principale
expression : exprBase ('=?' exprBase)? ;  // Comparaison d'expressions

// Expressions de base
exprBase
    : '(' 'cons' lExpr ')'
    | '(' 'list' lExpr ')'
    | '(' 'hd' exprBase ')'
    | '(' 'tl' exprBase ')'
    | '(' Symbol lExpr ')'
    | 'nil'
    | Variable
    | Symbol
    ;                     

// Liste d'expressions
lExpr : exprBase+ ;

// Variables et symboles
Variable : 'A'..'Z' ('A'..'Z' | 'a'..'z' | '0'..'9')* ('!' | '?')? ;  // Variables commençant par une majuscule
Symbol : 'a'..'z' ('A'..'Z' | 'a'..'z' | '0'..'9')* ('!' | '?')? ;    // Symboles commençant par une minuscule

WS  :   ( ' '| '\t'| '\r') {$channel=HIDDEN;};
    