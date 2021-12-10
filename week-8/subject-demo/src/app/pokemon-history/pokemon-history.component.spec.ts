import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonHistoryComponent } from './pokemon-history.component';

describe('PokemonHistoryComponent', () => {
  let component: PokemonHistoryComponent;
  let fixture: ComponentFixture<PokemonHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PokemonHistoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PokemonHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
