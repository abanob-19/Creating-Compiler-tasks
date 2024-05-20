/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

grammar Task9;

@members {
	/**
	 * Compares two integer numbers
	 *
	 * @param x the first number to compare
	 * @param y the second number to compare
	 * @return 1 if x is equal to y, and 0 otherwise
	 */
	public static int equals(int x, int y) {
	    return x == y ? 1 : 0;
	}
}




// Write additional lexer and parser rules here
s returns [int check]: f EOF {$check=$f.check * $f.m; };
f returns [int check , int m]: d [1,1] t [2 , $d.l] {$check= $d.check * $t.check ; $m=$t.m;};
d [int r , int c] returns [int l , int check]: '0' d[$r, $c+1] {$l=$d.l; $check=(1-equals($c,$r) )*$d.check ; } |
'1' d[$r, $c+1] {$l=$d.l; $check=(equals($c,$r) )*$d.check ;  }
| '0' {$l=$c ; $check = 1 - equals($c , $r); } | '1' {$l=$c ; $check = equals($c , $r); };
t [int r , int l] returns [int check, int m] : '#' n [$r , 1 , $l] {$check = $n.check ; $m=$n.m;} | {$check=1 ; $m=1;};
n [int r , int c , int l] returns [int check ,int m] : d [$r , 1] t[$r+1,$l] {$check = $d.check * $t.check ; $m=equals($d.l , $l)*$t.m;};


//s returns [int check]
//: f[0,0] EOF { $check= equals(($f.checkCount * $f.checkA),1) + equals(($f.checkCount * $f.checkA),2); };
//
//f [int inhDiff , int inhCheckA ] returns [int checkCount , int checkA , int diff]
//: c1=c f[inhDiff,inhCheckA] c2=c { $checkCount=$f.checkCount; $diff=$f.diff+$c1.a-$c2.a ; $checkA=(equals($f.diff+$c1.a-$c2.a,1) + equals($inhCheckA,1) +equals($inhCheckA,2))*(1-equals($f.diff+$c1.a-$c2.a,-1)) * (1-equals($f.diff+$c1.a-$c2.a,0));}
//| c{ $checkCount=0; $checkA=0; $diff=0 ;}
//| { $checkCount=1; $checkA=$inhCheckA; $diff=$inhDiff; };
//
//c returns [int a]
//: 'a' { $a=1; }
//| 'b' { $a=0;};