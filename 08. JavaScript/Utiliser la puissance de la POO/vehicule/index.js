import { Moteur } from "./moteur.js";
import { EtatMoteurArreter } from "./moteur.js";
import { EtatMoteurDemarrer } from "./moteur.js";
import { EtatMoteurEnPanne } from "./moteur.js";

class Vehicule {
    moteur;

    constructor()
    {
        this.moteur = new Moteur();
    }

    Demarrer()
    {
        this.moteur.Demarrer();
    }

    Arreter()
    {
        this.moteur.Arreter();
    }

    EnPanne()
    {
        this.moteur.EnPanne();
    }

    Reparer()
    {
        this.moteur.Reparer();
    }
}

const vehicule = new Vehicule();
vehicule.Arreter();
vehicule.Reparer();
vehicule.Demarrer();
vehicule.Demarrer();
vehicule.EnPanne();
vehicule.Reparer();
vehicule.Demarrer();