import { TestBed } from '@angular/core/testing';

import { LinepService } from './linep.service';

describe('LinepService', () => {
  let service: LinepService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LinepService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
