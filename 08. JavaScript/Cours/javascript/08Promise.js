

async function loadToken() {
    return new Promise((resolve, reject) => {
      setTimeout(function () {
        if (Math.random() > 0.2) {
          resolve("SDddsiopdfqsdfoeeld;tedDD");// Envoi au then Ligne 53 et 58 "SDddsiopdfqsdfoeeld;tedDD" qui sera récupéré dans le paramètre
        } else {
          reject("Erreur dans loadToken");
        }
      }, 2000)
    })
  }
  async function loadUser(token) {
    return new Promise((resolve, reject) => {
      setTimeout(function () {
        if (Math.random() > 0.2) {
          resolve({ name: "toto", id: 1 });// Envoi au then  l'objet qui représente l'utilisateur
        } else {
          reject("Erreur dans loadUser");
        }
      }, 2000)
    })
  }
  
  console.log(`après l'appel de loadToken`);
  /* loadToken()
    // si la promesse est tenue, on va dans le then
    .then(token => {
      console.log(`msg`, token);
      return loadUser(token); // On chaine les promesses 
    })
    .then(user => {
      console.log(`user`, user);
      // Cas favorable deux fois : lors de l'appel de loadToken puis de loadUser
    })
    // Si la promesse n'est pas tenue, on passe dans le catch
    .catch(error => {
      console.error(error);
    }) */
  
  // Nouvelle syntaxe 
  try {
    const token = await loadToken();
    const user = await loadUser(token);
    console.log(`token : `, token);
    console.log(`user : `, user);
  } catch (error) {
    console.error(`Erreur attrapée : `, error);
  }
  //fetch recuperer du json sur un serveur
  fetch("https://restcountries.com/v3.1/name/deutschland")
    .then((response) => { //ici
      console.log(`response status`, response.status);
      if (response.status == 200) {
        return response.json();
      } else throw new Error("le réponse du serveur n'est pas du json");
    })
    .then(data => { //ici
      console.log(`data : `, data);
    })
    .catch(error => {
      console.error("Erreur attrapée : " + error);
    }) 