import { Etat } from "./etat.js";
import { EtatAfaire } from "./etat.js";
import { EtatEnCours } from "./etat.js";
import { EtatFini } from "./etat.js";

class Tache {
    description;
    #descetat;
    #etat;

    constructor(description) 
    {
        this.description = description;
        this.#etat = new EtatAfaire();
        this.descetat = this.#etat.etat;
    }

    changerEtat()
    {
        this.#etat = this.#etat.changerEtat();
        this.descetat = this.#etat.etat;
    }
}

const tache = new Tache('début');
console.log(tache.descetat);
tache.changerEtat();
console.log(tache.descetat);
tache.changerEtat();
console.log(tache.descetat);
tache.changerEtat();
console.log(tache.descetat);
tache.changerEtat();
console.log(tache.descetat);