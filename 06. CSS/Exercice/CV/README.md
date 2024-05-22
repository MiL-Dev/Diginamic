#Bienvenue sur mon CV !

#Bootstrap version 5.2

* Installer bootstrap dans le repertoire css (Vous n'avez pas besoin de l'installer sauf si vous souhaiter modifier la versioin de bootstrap)
lien : https://getbootstrap.com/docs/5.2/getting-started/download/git s
Pour compiler avec sass veuillez telecharger la version "Source files"

#SASS

//commande qui permet de regarder et modifier le fichier css par rapport au index.scss. 
//A utiliser si vous souhaiter changer les couleurs dans _variables.scss et les mettre dans l'index.css

* sass --watch .\sass\index.scss .\css\index.css

#INFORMATION

* Les couleurs modifier pour l'exercice sont dans le dossier sass _variables.scss
* J'ai volontairement choisie des couleurs flashi pour que vous puissiez bien les voirs.
* Pour les modifiers faite la commande sass ci dessus.
* Elle s'applique sur le Background - le bouton de telechargement cv #btnWarning et un texte #textDanger

#ARCHITECTURE
* Les dossiers son nommer en fonction de leur langage css => dossier css, les images dans le dossier images comporte les logos et tout ce qu'il sert au site cv.
* Burger J'ai usiliser le burger(bar de navigation mobile) de bootstrap en y ajouter le scrypt adequat et les classes.
* Formulaire, il permet d'envoyer les donnees que je traite avec javascripte en renvoyant un message de remerciement. Dans le fichier main.js.
* gitignore pour ignorer le dossier bootstrap.
