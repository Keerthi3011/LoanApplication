import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayLoanComponent } from './display-loan.component';

describe('DisplayLoanComponent', () => {
  let component: DisplayLoanComponent;
  let fixture: ComponentFixture<DisplayLoanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayLoanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
