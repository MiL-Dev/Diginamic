//Version Prototype = class
/**
 * Fonction constructeur de Cat
 * @param {string} name 
 * @return {CatPrototype} retourne une instance de Cat
 */

function CatPrototype(name) {
  this.name = name;

// Ajout de la propriété meow au prototype de la fonction consructeur Cat
// meow devient accessible à toutes les instances issues de la fonction constructeur Cat

CatPrototype.prototype.meow = function () {
  console.log(`${this.name} dit : Miawoooooo `);
}
CatPrototype.prototype.eat = function () {
  console.log(`${this.name} mange `);
}
CatPrototype.prototype.gooner = true;
}


// Instanciation d'un chat
const fPrototype = new CatPrototype("FelixPrototype");
const pPrototype = new CatPrototype("PralinePrototype");

// Appel de la méthode meow
fPrototype.meow();
pPrototype.meow();
fPrototype.eat();
pPrototype.eat();
console.log(`fPrototype`, fPrototype);

// Pour savoir si les deux méthodes meow sont stockées au même endroit
if (pPrototype.meow === fPrototype.meow) {
  console.log(`Les deux méthodes sont stockées au même endroit`);
} else console.log(`Les deux méthodes ne sont pas stockées au même endroit`);

//if (f.gooner) console.log(`F est un gooner`);