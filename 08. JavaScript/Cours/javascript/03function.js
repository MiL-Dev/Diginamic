// fonction anonyme immédiate (IIFES) qui permet d'éviter la création de variables globales
const digiObject = (function () {
  /**
   * Fonction de test
   * @returns String
   */
  function test() {
    return "fonction un peu dégeu";
  }

  let t = test(); // passage par référence car test est de type évolué (function)
  console.log(`t`, t);
  console.log(`t`, typeof t);
  /**
   * Renvoie l'argument multiplié par 5
   * @param {number} num 
   * @returns {number}
   */
  /* function multiplyByFive(num) {
    return num * 5;
  } */
  multiplyByFive = num => num * 5;
  // multiplyByFive(5);
  console.log(multiplyByFive(5));// 5 est un argument

  let i = 1;
  function a() {
    let j = 2;
    console.log(`j`, j);
    b();
    console.log(`b`, b);
    function b() {
      let l = 4;
      console.log(l);
      {
        let k = 3;
        console.log(k);
        console.log(l);
        console.log(i);
      }

    }
  }
  a();
  console.log(`i`, i);
  console.log(`a`, a);

  // closure
  function makeBankAccount() {
    // this one is private
    let balance = 0;

    // a "getter", made public via the returned object below
    function getBalance() {
      return balance;
    }

    // a "setter", made public via the returned object below
    function setBalance(amount) {
      // ... validate before updating the balance
      balance = amount;
    }

    return {
      // ...
      getBalance,
      setBalance
    };
  }

  const account = makeBankAccount();
  account.setBalance(100);
  // comment afficher la variable balance ?
  console.log("balance = ", account.getBalance());
  return {
    multiplyByFive
  }
})();

const result = digiObject.multiplyByFive(10);
console.log(`result`, result);
/**
 * Fonction qui affiche dans la console le résultat du random
 * @param {number} result 
 * @returns void
 */
function success(result) {
  console.log(`Bravo ! ton score est : ${result}`);
}
function fail(result) {
  console.log(`Désolé, vous avez perdu ! ton petit score: ${result}`);
}
/**
 * En fonction du result, appel des fonctions de callback resolved ou reject
 * Higher Order function ou fonction de haut niveau car elle attend en paramètre des fonctions
 * 
 * @param {function} resolved 
 * @param {function} reject 
 * @returns void 
 */
function game(resolved, rejected) {// on dit que resolved et rejected sont des callbacks
  setTimeout(() => {
    const result = Math.random();
    if (result > 0.5) {
      resolved(result);
    } else rejected(result)
  }, 2000)
}
game(success, fail);// ici les arguments sont de type function
console.log(`Après l'appel de game`);