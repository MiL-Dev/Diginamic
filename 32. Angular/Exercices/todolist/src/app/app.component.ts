import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'digi-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'todolist';
  example(){
    var nom = "Bounaceur";
    let prenom = "Mohamed";
    const age = 32;
    return nom+" "+prenom+" "+age+"ans"
  }
  functionArrow = ()=> this.title = "Fonction flecher 1";
  functionArrowA = (a:string)=> this.title = "Fonction flecher A :"+ a;
  functionArrowB = (a:number, b:number)=> this.title = "Fonction flecher B resultat de entier :"+ (b + a);
  functionArrowC = (a:number, b:number)=> this.title = `Fonction flecher B resultat de entier : somme de ${a} et ${b} = ${a+b}`;


  //Propriete de l'instance du composant
  message:string = 'Hello from the component!';

  //fonction reguliere
/* 
  regularFunction(){
    setTimeout(function(){
      console.log('Inside regular function, this.message: ', this.message); //ici message n'est pas declarer et vue que c'est une fonction reguliere il ne monte pas au cran de la classe
      //this se refere a l'objet global ou est undefined en mode strict
    }, 1000);
  }
 */
  //fonction flechee
  arrowFunction(){
    setTimeout(()=> {
      console.log('Inside arrow function, this.message:' , this.message);
      // this se refere a l'instance du composant
    }, 1000);
  }
    //Methode pour demontrer les deux fonctions
    demonstrateThis(){
      // this.regularFunction();
      this.arrowFunction();
      return 'Check the console for "this" context example after a second';
    }
  demonstrateObjectDestructuring(){
    const framework = {name: 'Angular', version:12};
    const {name, version} = framework;
    return `Framework : ${name},Version: ${version}`;
  }
  demonstrateArrayDestructuring(){
    const fruits = ['Apple','Banana','Cheery'];
    //Destructuration du tableau
    const [first, second, third] = fruits;

    return `Fruits : ${first},${second},${third} `;
  }
}

class Person {
  #name;
  constructor(name:string) {
    this.#name = name;
  }
  get name(){
    return this.#name;
  }
  set name(new_name) {
    this.#name = new_name;
  }
  
  #privateMethod(){
    console.log('Methode prive !');
  }
  publicMethod(){
   console.log("j'appel la metheode prive depuis la public ");
   this.#privateMethod();
  }
}

const b = new Person("Bob");
console.log(b.name);
b.name = "toto";
console.log(b.name)
b.publicMethod();

const myMap = new Map();

myMap.set('Mohamed', '0635420000')
myMap.set('Personne1', '0632420000')
myMap.set('Personne2', '0656720000')
console.log("Voici le numero de Mohamed : "+ myMap.get('Mohamed'));
for(const [key,value] of myMap){
  if(key =='Mohamed'){
    console.log(key + ' tel: ' +value)
  }
}

if(myMap.delete("Personne1")){
  console.log("Personne1 a bien etait supprimer")
}


myMap.forEach((value, key) => {
  console.log(`${key} : ${value}`);
})