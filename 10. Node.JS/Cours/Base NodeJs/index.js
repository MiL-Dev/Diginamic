const express = require("express");
const app = express();
const hello = require("./hello"); // import d'un module cree
const data = require("./data.json"); // import du fichier json


//declaration le dossier static a express
app.use(express.static('public'))

//Creation d'une route et renvoi un json
app.get("/mohamed", (request, response) => {
  response.json({
    name: "mohamed",
    age: 32,
  });
});

//afficher la liste des toutes taches
app.get("/api/todos", (request, response) => {
  response.json({ todos: data.todos});
});

//Afficher une tache par l'id
app.get("/api/todos/:id", (request, response) => {
  const id = request.params.id; //recuperer le contenu sur l'url la variable :id
  response.json({ todos: data.todos.find((todo) => todo.id == id) });
});

app.get("/api/users", (request, response) => {
  response.json({ users: data.users});
});

app.get("/api/users/:id", (request, response) => {
  const id = request.params.id; //recuperer le contenu sur l'url la variable :id
  response.json({ users: data.users.find((users) => users.id == id) });
});

//Abdelac
app.get("/api/stores", (request, response) => {
  response.json({ stores: data.stores });
});

// http://localhost:3000/api/stores/2  -->  { id: 2, name: 'merco', ... }
// http://localhost:3000/api/stores/67  -->  { id: 67, name: 'bmw', ... }
app.get("/api/stores/:id", (request, response) => {
  response.json({
    store: data.stores.find(store => store.id == request.params.id)
  })
})

app.listen(3000); //lancer un serveur sur le port 3000


// 1/ Requête initiale: /       --> Response index.html (2 coms) (favicon !!!)
// 2/ Requête styles.css        --> Response styles.css
// 3/ Requête app.js            --> Response app.js
// 4/ Requête fetch('/stores')  --> Response json stores


// 1 Requête --> Response --> génère le html/css/js fetch('https://extern.html/data.json')
