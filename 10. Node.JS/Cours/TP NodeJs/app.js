const express = require('express');
const app = express(); //application
const router = require("./routing");

// API REST --> cars
// Liste des voitures                   --> GET /cars
// Détails d'une voiture                --> GET /cars/:id
// Créer une voiture                    --> POST /cars
// Supprimer une voiture                --> DELETE /cars/:id
// Supprimer toutes les voiture         --> DELETE /cars
// Modifier une voiture                 --> PUT /cars/:id
// Modifier une partie d'une voiture    --> PATCH /cars/:id

// CONFIG APP
app.use(router); // Utilise le router
  
// LAUNCH SERVER
app.listen(3000)

