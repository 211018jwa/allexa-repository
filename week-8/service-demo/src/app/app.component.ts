import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'service-demo';

  currentlyViewedPokemon: string = '';

  pokemonID: number = 0;
  pokemonService!: PokeService;

  getPokemonImageLink() {

  }
}
