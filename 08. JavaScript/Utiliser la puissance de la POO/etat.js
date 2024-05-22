export class Etat{
    etat;
    
    constructor(etat) {
        this.etat = etat;
    }
}

export class EtatAfaire extends Etat{
    
    constructor()
    {
        super('A faire');
    }

    changerEtat()
    {
        console.log('La tâche débute');
        return new EtatEnCours();
    }
}

export class EtatEnCours extends Etat 
{
    constructor()
    {
        super('en cours');
    }

    changerEtat()
    {
        console.log('La tâche est finie');
        return new EtatTest();    
    }
}

export class EtatFini extends Etat {

    constructor()
    {
        super('Finie');
    }

    changerEtat()
    {
        console.log(' la tâche est finie. Elle ne peut plus changer d\'état');
        return this;
    }
}

export class EtatTest extends Etat {

    constructor()
    {
        super('Tests');
    }

    changerEtat()
    {
        console.log('La tâche est en cours de test');
        return new EtatFini;

    }
}