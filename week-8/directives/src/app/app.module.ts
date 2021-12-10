import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AttributeDirectivesDemoComponent } from './attribute-directives-demo/attribute-directives-demo.component';
import { StructuralDirectivesDemoComponent } from './structural-directives-demo/structural-directives-demo.component';

@NgModule({
  declarations: [
    AppComponent,
    AttributeDirectivesDemoComponent,
    StructuralDirectivesDemoComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
