import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pokemon-viewer',
  templateUrl: './pokemon-viewer.component.html',
  styleUrls: ['./pokemon-viewer.component.css']
})
export class PokemonViewerComponent implements OnInit {

  imageLink: string = '';
  pokemonID: number = 0;

  pokeService!: PokeService;

  constructor(pokeService: PokeService) {
    this.pokeService
  }

  ngOnInit(): void {
  }

  viewPokemon() {

  }

}
