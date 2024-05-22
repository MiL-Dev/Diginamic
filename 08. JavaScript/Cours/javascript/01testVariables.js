var i = 12;
console.log(`i : ${i}`);
console.log(`typeof(i)`, typeof (i));
i = "Hello World";
console.log(`typeof(i)`, typeof (i));
i = true;
console.log(`typeof(i)`, typeof (i));
let j = 42;

let x = "";
console.log(`x : `, x);

console.log(!!x);

{
  i = 55;
  console.log(`i dans le bloc de code`, i);
}
console.log(`i dans le scope global`, i);

let toto = {
  name: "toto"
}
// passage par référence car toto est un type évolué
const jojo = toto;
console.log(`toto`, toto, "jojo", jojo);
jojo.age = 42;
console.log(`toto`, toto, "jojo", jojo);

let a = 12; // type primitif
let b = a;// passage par valeur
console.log(`a`, a, "b", b);
b = 55;
console.log(`a`, a, "b", b);