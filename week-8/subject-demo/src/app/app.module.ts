import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PokemonViewerComponent } from './pokemon-viewer/pokemon-viewer.component';
import { PokemonHistoryComponent } from './pokemon-history/pokemon-history.component';
import { FormsModule } from '@angular/forms';
import { PokeComponent } from './poke/poke.component';

@NgModule({
  declarations: [
    AppComponent,
    PokemonViewerComponent,
    PokemonHistoryComponent,
    PokeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
