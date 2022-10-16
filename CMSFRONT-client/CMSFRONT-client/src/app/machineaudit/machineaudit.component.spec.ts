import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MachineauditComponent } from './machineaudit.component';

describe('MachineauditComponent', () => {
  let component: MachineauditComponent;
  let fixture: ComponentFixture<MachineauditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MachineauditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MachineauditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
