import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-one-way-db-demo',
  templateUrl: './one-way-db-demo.component.html',
  styleUrls: ['./one-way-db-demo.component.css']
})
export class OneWayDbDemoComponent implements OnInit {

  inputValue: string = '';
  
  constructor() { }

  ngOnInit(): void {
  }

  onInputChange(event: Event) {
    let element = <HTMLInputElement> event.target;

    this.inputValue = element.value;
  }

}
