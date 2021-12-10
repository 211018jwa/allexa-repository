import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-two-way-db-demo',
  templateUrl: './two-way-db-demo.component.html',
  styleUrls: ['./two-way-db-demo.component.css']
})
export class TwoWayDbDemoComponent implements OnInit {

  inputValue: string = '';

  constructor() { }

  ngOnInit(): void {
  }

}
