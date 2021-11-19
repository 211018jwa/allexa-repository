let pokemonIDInputElement = document.querySelector('#pokemon-id-input');
let getPokemonButtomElement = document.querySelector('get-pokemon');

function onGetPokemonButtonClick() {
    let fetchPromise = fetch(`https://pokeapi.co/api/v2/pokmon/${pokemonIDInputElement.value}`);
    
    fetchPromise.then((res) => {
        if(res.status === 404){
            return new Promise((resolve, reject) => {
                reject(`Pokemon with id of ${pokemonIDInputElement.value} was not found`);
            });
        }
        else {
            return res.json();
        }
    }).then((data) => {
        displayPokemonInfo(data);
        console.log(data);
    }).catch((err) => {
        console.log(err);
    });
}

async function onGetPokemonButtonClick_asyncAwait() {
    let fetchPromise = fetch(`https://pokeapi.co/api/v2/pokmon/${pokemonIDInputElement.value}`);
    
    try {
        let res = await fetchPromise;

        if(res.status === 404){
            return new Promise((resolve, reject) => {
                reject(`Pokemon with id of ${pokemonIDInputElement.value} was not found`);
            });
        }

        let data = await res;
        displayPokemonImage(data);
    } catch(err) {
        console.log(err);
    }
}

getPokemonButtomElement.addEventListener('click', onGetPokemonButtonClick_asyncAwait);

function displayPokemonImg(pokemon) {
    let containerElement = document.querySelector('#container');
    let imgElement = document.createElement('img');

    let imgUrl = pokemon.sprites.front_default;
    imgElement.setAttribute('src', imgUrl);

    containerElement.appendChild;
}