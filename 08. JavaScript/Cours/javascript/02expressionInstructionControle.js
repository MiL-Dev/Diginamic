// instruction 
//console.log(`Test`);
let i = 1;// instruction 
{ i == 12 } // expression car peut se réduire à la valeur true ou false

{ (i == 12) && (console.log(`test aprés évaluation d'une expression`)) }

if (i == 12) {
  console.log(`i est bien égal à 12`);
} else if (i == 14) {
  console.log(`i est bien égal à 14`);
}
else {
  console.log(`i n'est pas égal ni à 12 ni à 14`);
}
// opérateur ternaire
const msg = (i == 12) ? `i est bien égal à 12` : "i n'est pas égal à 12 ";
console.log(`msg`, msg);

for (let z = 0; z < 10; z++) {
  console.log(z);
}
console.log(`z`, z);