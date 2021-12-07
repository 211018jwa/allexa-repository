import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PokeComponent } from './poke/poke.component';
import { PasswordGeneratorComponent } from './password-generator/password-generator.component';
import { ImageviewerComponent } from './imageviewer/imageviewer.component';
import { ImageViewerComponent } from './image-viewer/image-viewer.component';

@NgModule({
  declarations: [
    AppComponent,
    PokeComponent,
    PasswordGeneratorComponent,
    ImageviewerComponent,
    ImageViewerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
