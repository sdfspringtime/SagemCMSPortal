import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MachineUpdateComponentComponent } from './machine-update-component.component';

describe('MachineUpdateComponentComponent', () => {
  let component: MachineUpdateComponentComponent;
  let fixture: ComponentFixture<MachineUpdateComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MachineUpdateComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MachineUpdateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
