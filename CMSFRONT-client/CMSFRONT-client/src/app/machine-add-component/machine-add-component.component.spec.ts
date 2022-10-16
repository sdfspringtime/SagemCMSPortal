import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MachineAddComponentComponent } from './machine-add-component.component';

describe('MachineAddComponentComponent', () => {
  let component: MachineAddComponentComponent;
  let fixture: ComponentFixture<MachineAddComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MachineAddComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MachineAddComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
