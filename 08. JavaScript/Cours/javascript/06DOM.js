let h1 = document.getElementById("myh1");
console.log(`h1`, h1);
//h1.remove();
// Création d'un élément du DOM
const span = document.createElement("span");
span.innerText = "contenu du span";

h1.align = "center";
h1.innerText = "Nouvelle valeur du H1";

// positionne le span comme dernier fils de body
document.body.appendChild(span);

/**
   * Crée un élément du dom, lui ajoute du texte, le place comme dernier
   * enfant de parent et ajoute un attribut en utilisant le paramètre attributes
   * @param {String} markup_name 
   * @param {String} text 
   * @param {domElement} parent 
   * @param {Object} attributes
   * @returns domElement
   */
function createMarkup(markupname, text, parent, attributes = {}) {
  const markup = document.createElement(markupname);
  markup.textContent = text;
  parent.appendChild(markup);
  for (key in attributes) {
    markup.setAttribute(key, attributes[key]);
  }
  return markup;
}
const header = createMarkup("header", "", document.body);
const nav = createMarkup("nav", "", header, { id: "test", lang: "fr" });
for (let i = 0; i < 4; i++) {
  createMarkup("button", `Item ${i + 1}`, nav);
}
document.querySelector("nav > button:nth-child(3)").style.color = "red";