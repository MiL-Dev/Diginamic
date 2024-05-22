class User {
    #name;
    #role;
    constructor(name, role) {
      this.#name = name;
      this.#role = role;
    }
    get name() {
      console.log(`dans le getter name`);
      return this.#name;
    }
    set name(new_name) {
      console.log(`dans le setter name`);
      this.#name = new_name;
    }
    get role() {
      return this.#role;
    }
    set role(new_role) {
      this.#name = new_role;
    }
  }
  const b = new User("Bob", "smallBroker");
  console.log(b.name);
  b.name = "Toto";
  console.log(b.name);
  /**
   * Class Product
   * name : propriété privée accessible de l'extérieur de la classe que par un getter ou un setter
   * price : propriété privée accessible de l'extérieur de la classe que par un getter ou un setter
   */
  class Product {
    // propriété de classe
    static brand = 'diginamic';
    #name;
    #price;
    constructor(name, price) {
      this.#name = name;
      this.#price = price;
    }
    get name() {
      console.log(`dans le getter name`);
      return this.#name + " - " + Product.brand;
    }
    set name(new_name) {
      this.#name = new_name;
    }
    get price() {
      if (b.role === "smallBroker") {
        return this.#price * 0.9;
      }
      return this.#price;
    }
    set price(new_price) {
      this.#price = new_price;
    }
  }
  const p = new Product("bike", 1000);
  
  console.log(`prix de p : `, p.price);
  console.log(`nom de p : `, p.name);
  console.log(`brand : `, Product.brand);