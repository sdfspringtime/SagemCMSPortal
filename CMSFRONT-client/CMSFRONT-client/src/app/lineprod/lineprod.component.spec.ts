import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LineprodComponent } from './lineprod.component';

describe('LineprodComponent', () => {
  let component: LineprodComponent;
  let fixture: ComponentFixture<LineprodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LineprodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LineprodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
