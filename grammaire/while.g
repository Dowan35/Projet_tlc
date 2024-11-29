grammar expr_num;

start
    returns [double value]
    : e=expression
    {
        System.out.println("Resultat : " + $e.value);
        $value = $e.value;
    }
    EOF
    ;
	
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

// Expression complète avec addition et soustraction
expression returns [double value]
    : left=term {
        $value = $left.value;
    }
    (
        '+' right=term { 
            $value += $right.value;
        }
        | '-' right=term {
            $value -= $right.value;
        }
    )*
    ;

// Terme (multiplication et division)
term returns [double value]
    : left=factor {
        $value = $left.value;
    }
    (
        '*' right=factor {
            $value *= $right.value;
        }
        | '/' right=factor {
            $value /= $right.value;
        }
    )*
    ;

// Facteur (négatif, nombre ou sous-expression)
factor returns [double value]
    : '-' primary { 
          $value = -$primary.value; 
        }
    | primary { 
          $value = $primary.value; 
        }
    ;

// Valeur primaire (nombre ou parenthèses)
primary returns [double value]
    : INT {
          $value = Integer.parseInt($INT.text); 
        }
    | FLOAT { 
          $value = Double.parseDouble($FLOAT.text); 
        }
    | '(' e=expression ')' {
          $value = $e.value; 
        }
    ;