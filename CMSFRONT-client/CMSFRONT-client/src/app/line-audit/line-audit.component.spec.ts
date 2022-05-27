import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LineAuditComponent } from './line-audit.component';

describe('LineAuditComponent', () => {
  let component: LineAuditComponent;
  let fixture: ComponentFixture<LineAuditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LineAuditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LineAuditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
