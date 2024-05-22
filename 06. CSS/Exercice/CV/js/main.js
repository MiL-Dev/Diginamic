let formContact = document.getElementById('formContact');
let formMail = document.getElementById('formMail');
let formMessage = document.getElementById('formMessage');
/**
 * Event qui permet de recuperer le formulaire de contact et d'envoyer un message.
 */
formContact.addEventListener('submit', (e) => {
    e.preventDefault();
    alert(`Votre Mail : ${formMail.value} , votre Message : ${formMessage.value}.\nMerci de m'avoir contacter, je vous repondrai jamais car ceci est un test xD`)
})
