class Bike {
    #brand; //#Permet a JS d'interpretter le fait de vouloir automatiser le setter et getter quand on souhaite modifier c'est variable.
    #model;
    weight; //Pas obligatoire de declarer cette variable.
    constructor(brand, model, weight){
        this.#brand = brand;
        this.#model = model;
        this.weight = weight;
    }
    get brand() {
        console.log(`je passe par le getter de brand`); // parce que y'a le # Devant ma variable
        return this.#brand;
      }
    set brand(new_brand) {
        console.log(`je passe par le setter de brand`); 
        this.#brand = new_brand;
    }
    get model() {
        return this.#model;
      }
    set model(new_model) {
        this.#model = new_model;
    }
    pedal (){
        console.log('Je pédale !');
    }
}
class Tandem extends Bike {
    static seat_number = 2;
    pedal(){
        console.log(`Nous sommes ${Tandem.seat_number} à pédaler !`);
    }
}
const bike = new Bike('Marque','Model','Poids');
const tand = new Tandem('Marque 2','Model 2','Poids 2');
console.log(`Marque : ${bike.brand} , Model : ${bike.model}, Poids : ${bike.weight}`);
bike.pedal();
console.log(`Marque : ${tand.brand} , Model : ${tand.model}, Poids : ${tand.weight}`);
tand.pedal();