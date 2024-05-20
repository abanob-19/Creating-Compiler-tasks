/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

grammar Task10;

s returns [int val]: f [-1 , 0 , 0] EOF {$val = $f.val;} | EOF {$val=0;};
f [int prev , int set, int count ] returns [int val] : a[$prev , $set , $count] ',' f [$a.text , $a.set1,$a.count1] {$val=$f.val;}
| a[$prev , $set , $count]  {$val=$a.count1; };
a [int prev , int set , int count] returns [int set1 , int count1 , int text] : Number { $text=Integer.parseInt($Number.text);int generated= Integer.parseInt($Number.text);  if ($prev==generated && set==0) { $count1=$count+1 ; $set1=1; } else {$count1=$count ; $set1=$set;};  if ($prev!=generated) {$set1=0;}  };
Number : [0-9]+;



// Write additional lexer and parser rules here