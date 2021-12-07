import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'one-way-databinding-app';

  generatedPassword = '';

  desiredPasswordLength: number = 0;

  onButtonClick() {
    console.log("cliked!");
    let allowedCharacters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()';
    let password = '';

    for(let i = 0; i < this.desiredPasswordLength; i++) {
      password += allowedCharacters
        .charAt(Math.floor(Math.random() *allowedCharacters.length));
    }

    this.generatedPassword = password;
  }

  OnDesiredPasswordLengthInputChange(event: Event) {
    let inputElement = event.target;
    this.desiredPasswordLength = Number((<HTMLInputElement>inputElement).value);
  }

  imageLink: string = ' ';

  onImageChange(event: Event) {
    this.imageLink = (<HTMLInputElement>event.target).value;
  }
}
