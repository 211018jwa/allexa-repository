import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { OneWayDbDemoComponent } from './one-way-db-demo/one-way-db-demo.component';
import { TwoWayDbDemoComponent } from './two-way-db-demo/two-way-db-demo.component';

@NgModule({
  declarations: [
    AppComponent,
    OneWayDbDemoComponent,
    TwoWayDbDemoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
