const storesDiv = document.querySelector('.stores')

document.querySelector('button').addEventListener('click', () => {

  fetch('/api/stores')
    .then(res => res.json())
    .then(data => {
      storesDiv.innerHTML = `
        ${data.stores.map(s => (
          `<p>${s.name} <button>Détails</button></p>`
        )).join('')}
      `
    })
})
