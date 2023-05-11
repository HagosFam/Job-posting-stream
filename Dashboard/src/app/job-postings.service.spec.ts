import { TestBed } from '@angular/core/testing';

import { JobPostingsService } from './job-postings.service';

describe('JobPostingsService', () => {
  let service: JobPostingsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobPostingsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
