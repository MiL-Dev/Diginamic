const form = document.createElement("form");
const input = document.createElement("input");
const btnSubmit = document.createElement("button");


btnSubmit.textContent = 'Ajouter une tache';

document.body.appendChild(form);
form.appendChild(input);
form.appendChild(btnSubmit);
input.required = true;
btnSubmit.type = "button"; //Permet de retirer l'event de form , j'ai essayer avec event.preventDefault(); mais sa ce lance en continue

let acc = 0;
btnSubmit.addEventListener("click", () => {
    const button= {};
    if(acc===0){
        createMarkup('section',"",document.body,{id: `sectionId${acc}`});
        const section = document.querySelector("section");
        createMarkup('p',input.value,section);
        createMarkup('button',"Valider",section);
        createMarkup('button',"Supprimer",section,{class: `btnDelete`});
        section.children[1].setAttribute('onClick', 'valid(this)');
        section.children[2].setAttribute('onClick', 'deleteSection(this)');
        
    }else {
        createMarkup('section',"",document.body,{id: `sectionId${acc}`});
        const section = document.getElementById(`sectionId${acc}`);
        createMarkup('p',input.value,section);
        createMarkup('button',"Valider",section);
        createMarkup('button',"Supprimer",section,{class: `btnDelete`});
        section.children[1].setAttribute('onClick', 'valid(this)');
        section.children[2].setAttribute('onClick', 'deleteSection(this)');
        
    }  
    acc++;
});

function valid (e){
    e.parentElement.children[0].classList.add("pValide");
    e.setAttribute('onClick', 'unValid(this)');
    e.textContent = 'Devalide';
}
function unValid(e){
    e.parentElement.children[0].classList.remove("pValide");
    e.setAttribute('onClick', 'valid(this)');
    e.textContent = 'Valide';
}
function deleteSection(e){
    e.parentElement.remove();
}


function createMarkup(markupname, text, parent, attributes = {}) {
    const markup = document.createElement(markupname);
    markup.textContent = text;
    parent.appendChild(markup);
    for (key in attributes) {
      markup.setAttribute(key, attributes[key]);
    }
    return markup;
  }
