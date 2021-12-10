import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-structural-directives-demo',
  templateUrl: './structural-directives-demo.component.html',
  styleUrls: ['./structural-directives-demo.component.css']
})
export class StructuralDirectivesDemoComponent implements OnInit {

  paragraphElementDisplayed: boolean = true;

  pokemonData: {id:number, name:string, weight:number}[] = 
  [{ id: 1, name:'Pikachu', weight:100},
  { id: 2, name:'Pikachu', weight:100},
  { id: 3, name:'Pikachu', weight:100}]


  constructor() { }

  ngOnInit(): void {
  }

}
