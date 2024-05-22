// Déclaration de la fonction constructeur Circle

function Circle(radius, name) {
  this.radius = radius;
  this.name = name;

}
Circle.prototype.pi = 3.14;
Circle.prototype.area = function () {
  return this.pi * this.radius ** 2;
}

const smallCircle = new Circle(2, "petit cercle");
// Calcul de l'aire 
console.log(`aire de smallCircle ${smallCircle.area()}`);

const bigCircle = new Circle(4, "grand cercle");
console.log(`aire de bigCircle ${bigCircle.area()}`);
console.log(`smallCircle`, smallCircle);