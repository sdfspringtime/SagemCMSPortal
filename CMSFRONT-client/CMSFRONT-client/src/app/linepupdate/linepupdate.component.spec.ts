import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LinepupdateComponent } from './linepupdate.component';

describe('LinepupdateComponent', () => {
  let component: LinepupdateComponent;
  let fixture: ComponentFixture<LinepupdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LinepupdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LinepupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
