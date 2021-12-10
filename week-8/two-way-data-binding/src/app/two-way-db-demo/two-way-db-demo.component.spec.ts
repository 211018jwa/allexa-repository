import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoWayDbDemoComponent } from './two-way-db-demo.component';

describe('TwoWayDbDemoComponent', () => {
  let component: TwoWayDbDemoComponent;
  let fixture: ComponentFixture<TwoWayDbDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwoWayDbDemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwoWayDbDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
