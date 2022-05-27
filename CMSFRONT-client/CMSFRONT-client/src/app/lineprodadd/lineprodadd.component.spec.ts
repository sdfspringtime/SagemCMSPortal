import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LineprodaddComponent } from './lineprodadd.component';

describe('LineprodaddComponent', () => {
  let component: LineprodaddComponent;
  let fixture: ComponentFixture<LineprodaddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LineprodaddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LineprodaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
