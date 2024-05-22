const users = [
    {name: "Dylan", age: 78},
    {name: "Marley", age: 92},
    {name: "Cohen", age: 83},
    {name: "Jackson", age: 76},
  ];
users.sort((a, b) => a.age - b.age);

//On peu ecrire comme sa aussi
/* users.sort((a, b) => {
   return a.age - b.age
}); */
//Ou comme sa c'est la meme chose que ligne 7
/* users.sort(function (a, b){
    return a.age - b.age
 }); */
console.log(users);
/* console.log(`Liste d'utilisateur trier par age croissant `);
UsersSort.forEach((user)=> console.log(`Nom : ${user.name} -  Age : ${user.age} `)); */


let fruits = ["Banane", "Cerise"];
//const fruits = new Array("Banane", "Cerise");// fruits est une instance de Array
console.log(`fruits`, fruits);
fruits.push("Pomme");// impur

console.log(`fruits`, fruits);
console.log(`fruits[1]`, fruits[1]);
console.log(`length`, fruits.length);

fruits.forEach((fruit, index) => {
  console.log(fruit, index);
})
console.log(`fruits`, fruits);
// spread operator
const myFruits = [...fruits, "Abricots", "Banane"];
console.log(`myFruits`, myFruits);

/* En une seule instruction, ajouter 3 fruits au tableau "fruits" et classer les fruits par taille de chaîne de caractères. 

N'utilisez pas push mais plutôt le spread operator et ensuite sort et afficher le résultat dans la console.*/
fruits = [...fruits, "kiwi", "Pomme verte", "fraise"].sort((a, b) => {
  return a.length - b.length;
}).filter((fruit) => {
  return fruit.includes("i")
}).map((fruit) => `<strong>${fruit}</strong>`);
console.log(`fruits`, fruits);