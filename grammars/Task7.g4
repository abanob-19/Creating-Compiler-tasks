/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

grammar Task7;

/**
 * This rule is to check your grammar using "ANTLR Preview"
 */
test:  (ONE | ZERO | ERROR )+  EOF; //Replace the non-fragment lexer rules here

// Write all the necessary lexer rules and fragment lexer rules here
ONE: THREE0 | THREEAND1;
ZERO: THREEAND0 ;
ERROR: LESSTHAN3;
fragment THREE0: '000' ;
fragment THREEAND0: BIT '0' BIT | BIT BIT '0' ;
fragment THREEAND1: BIT '1' '1' ;
fragment LESSTHAN3: BIT BIT | BIT ;
fragment BIT: '0' | '1';