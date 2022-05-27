import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LinepdetailsComponent } from './linepdetails.component';

describe('LinepdetailsComponent', () => {
  let component: LinepdetailsComponent;
  let fixture: ComponentFixture<LinepdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LinepdetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LinepdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
