import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MachdetailsComponent } from './machdetails.component';

describe('MachdetailsComponent', () => {
  let component: MachdetailsComponent;
  let fixture: ComponentFixture<MachdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MachdetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MachdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
