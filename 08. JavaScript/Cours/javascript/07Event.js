const h1 = document.createElement("h1");
h1.innerText = "Titre de niveau 1"
document.body.appendChild(h1);


h1.addEventListener("click", function () {
  console.log(`Click sur h1 en utilisant addEventListener 1`);
})
h1.addEventListener("click", function () {
  console.log(`Click sur h1 en utilisant addEventListener 2`);
})
// ATTENTION, ICI IL FAUT DONNER UNE Référence à UNE FONCTION ET NON PAS L'APPEL D'UNE FONCTION
h1.addEventListener("click", faireLeCafe);

function faireLeCafe() {
  console.log(`El cafe esta listo mi vida !!`);
}
// Création d'un lien
const a = document.createElement("a");
a.innerText = "lien vers Diginamic";
a.href = "https://diginamic.fr";
document.body.appendChild(a);

const span = document.createElement("span");
span.innerText = " texte du span";
a.appendChild(span);

a.addEventListener("click", function (event) {
  // Bloque le comportement par défaut associé à l'événement click sur le lien 
  event.preventDefault();
  console.log(`event.target`, event.target);
  //console.log(`event`, event);
})

// ATTENTION, ICI IL FAUT DONNER UNE Référence à UNE FONCTION ET NON PAS L'APPEL D'UNE FONCTION
h1.addEventListener("click", faireLeCafe);

function faireLeCafe(event) {
  console.log(`El cafe esta listo mi vida !!`);
}