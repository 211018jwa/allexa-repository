import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonViewerComponent } from './pokemon-viewer.component';

describe('PokemonViewerComponent', () => {
  let component: PokemonViewerComponent;
  let fixture: ComponentFixture<PokemonViewerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PokemonViewerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PokemonViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
