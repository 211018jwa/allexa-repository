import { Component, OnInit } from '@angular/core';
import { EventEmitter } from 'stream';

@Component({
  selector: 'app-addition',
  templateUrl: './addition.component.html',
  styleUrls: ['./addition.component.css']
})
export class AdditionComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  number1: number = 0;
  number2: number = 0;

  result: number = 0;
  history: string[] = [] ;

  newHistory = new EventEmitter<string>();

  addNumbers() {
    this.result = this.number1 + this.number2;
    
    this.newHistory.emit(`${this.number1} + ${this.number2} is ${this.result}`);
    
  }

}
