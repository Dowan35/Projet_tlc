grammar while;

//Structure principale
Program :	 Function+ ;

Function :	 'function' Symbol ':' Definition;

Definition:	'read' Input '%' Commands '%' 'write' Output;


//Gestion des entrées
Input	:	 InputSub | ;
InputSub:	 Variable (',' InputSub)?;


//Gestion des sorties
Output : Variable (',' Output)? ;


//Listes des commandes
Commands:	Command (';' Commands)? ;

Command	:	
	'nop'//Pas d'opération
	|Vars ':=' Expression
	|'if' Expression 'then' Commands ('else' Commands)? 'fi'//Conditionnelle
    	| 'while' Expression 'do' Commands 'od'//Boucle while
    	| 'for' Expression 'do' Commands 'od'//Boucle for
    	| 'foreach' Variable 'in' Expression 'do' Commands 'od'//Boucle foreach
	;

//Variable multiple
Vars	:	 Variable (',' Vars)? ;


// Expressions multiples
Exprs : Expression (',' Exprs)? ;


// Expression principale
Expression
    : ExprBase                                    // Expression de base
    | ExprBase '=?' ExprBase ;                    // Comparaison d'expressions
    

// Expressions de base
ExprBase
    : 'nil'                                       // Constante "nil"
    | Variable                                    // Variable
    | Symbol                                      // Symbole
    | '(' 'cons' lExpr ')'                        // Construction d'une liste avec "cons"
    | '(' 'list' lExpr ')'                        // Construction d'une liste avec "list"
    | '(' 'hd' ExprBase ')'                       // Extraction de la tête d'une liste
    | '(' 'tl' ExprBase ')'                       // Extraction de la queue d'une liste
    | '(' Symbol lExpr ')' ;                      // Appel de symbole avec arguments
    
    
// Liste d'expressions
lExpr : ExprBase lExpr | ;


// Variables et symboles
Variable : MAJ (MAJ | MIN | DEC)* ('!' | '?')? ; // Variables commençant par une majuscule
Symbol : MIN (MAJ | MIN | DEC)* ('!' | '?')? ;   // Symboles commençant par une minuscule


// Terminaux
MAJ : 'A'..'Z' ;             // Lettres majuscules
MIN : 'a'..'z' ;             // Lettres minuscules
DEC : '0'..'9' ;             // Chiffres
WS  :   ( ' '| '\t'| '\r') {$channel=HIDDEN;};


