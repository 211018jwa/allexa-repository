import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdditionHistoryComponent } from './addition-history.component';

describe('AdditionHistoryComponent', () => {
  let component: AdditionHistoryComponent;
  let fixture: ComponentFixture<AdditionHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdditionHistoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdditionHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
