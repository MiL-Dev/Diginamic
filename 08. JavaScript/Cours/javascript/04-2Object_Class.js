class CatClass {
    constructor(name) {
      this.name = name;
    }
    meow() {
      console.log(`${this.name} dit : Miawoooooo Class `);
    }
    eat() {
      console.log(`${this.name} mange Class `);
    }
  }
  
  // Instanciation d'un chat
  const fClass = new CatClass("Felix Class");
  const pClass = new CatClass("Praline Class");
  
  // Appel de la méthode meow
  fClass.meow();
  pClass.meow();
  fClass.eat();
  pClass.eat();
  console.log(`fClass`, fClass);
  
  // Pour savoir si les deux méthodes meow sont stockées au même endroit
  if (pClass.meow === fClass.meow) {
    console.log(`Les deux méthodes sont stockées au même endroit`);
  } else console.log(`Les deux méthodes ne sont pas stockées au même endroit`);