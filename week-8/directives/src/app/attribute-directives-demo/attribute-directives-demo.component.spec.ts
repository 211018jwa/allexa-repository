import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttributeDirectivesDemoComponent } from './attribute-directives-demo.component';

describe('AttributeDirectivesDemoComponent', () => {
  let component: AttributeDirectivesDemoComponent;
  let fixture: ComponentFixture<AttributeDirectivesDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AttributeDirectivesDemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AttributeDirectivesDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
