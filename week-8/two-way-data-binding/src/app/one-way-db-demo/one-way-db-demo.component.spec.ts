import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OneWayDbDemoComponent } from './one-way-db-demo.component';

describe('OneWayDbDemoComponent', () => {
  let component: OneWayDbDemoComponent;
  let fixture: ComponentFixture<OneWayDbDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OneWayDbDemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OneWayDbDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
