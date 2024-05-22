export class Moteur {
    #etatMoteur;

    constructor()
    {
        this.#etatMoteur = new EtatMoteurArreter();
    }

    Demarrer()
    {
        this.#etatMoteur = this.#etatMoteur.Demarrer();
    }

    Arreter()
    {
        this.#etatMoteur = this.#etatMoteur.Arreter();
    }

    EnPanne()
    {
        console.log('Je suis en panne');
        this.#etatMoteur = new EtatMoteurEnPanne();
    }

    Reparer()
    {
        if ( this.#etatMoteur instanceof EtatMoteurEnPanne)
        {
            console.log('Moteur réparé!');
            this.#etatMoteur = new EtatMoteurArreter();
        } else {
            console.log('Je ne suis pas en panne');
        }
        
    }
}

export class EtatMoteurArreter {

    constructor() 
    {

    }

    Demarrer()
    {
        console.log('Je démarre');
        return new EtatMoteurDemarrer();
    }

    Arreter()
    {
        console.log('Déjà arrêter');
        return this;
    }

} 

export class EtatMoteurDemarrer {

     constructor()
     {

     }

     Demarrer()
    {
        console.log('Déjà démarrer');
        return this;

    }

    Arreter()
    {
        console.log('Je m\'arrête');
        return new EtatMoteurArreter();
        
    }
}

export class EtatMoteurEnPanne {

    constructor()
    {

    }

    Demarrer()
    {
        console.log('Je suis en panne. Je ne paux pas démarrer');
        return this;
    }

    Arreter()
    {
        console.log('Je suis en panne. Je ne peux pas m\'arréter');
        return this;
    }

    Reparer()
    {
        console.log('Je suis réparé');
        return new EtatMoteurArreter();
    }
}