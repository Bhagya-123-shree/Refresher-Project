import { TestBed } from '@angular/core/testing';

import { AddscheduledflyService } from './addscheduledfly.service';

describe('AddscheduledflyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddscheduledflyService = TestBed.get(AddscheduledflyService);
    expect(service).toBeTruthy();
  });
});
