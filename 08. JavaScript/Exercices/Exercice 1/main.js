const button = document.createElement("button");
const section = document.createElement("section");
document.body.appendChild(button);
document.body.appendChild(section);
button.textContent = 'Ajouter un paragraphe';

button.addEventListener("click", function() {
  const p = document.createElement("p");
  p.textContent = `Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus quis dicta cupiditate ex natus iste corrupti ut, iure pariatur sit!`;
  section.appendChild(p);
  });