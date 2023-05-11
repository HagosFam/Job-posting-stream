import { Injectable } from '@angular/core';
import { JobPosting } from './job-postings';
import { HttpClient } from '@angular/common/http';
import { Observable  } from 'rxjs';
import { NgZone } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JobPostingsService {
  url = 'http://localhost:8080/jobpostings/stream';

  constructor(private zone: NgZone, private http: HttpClient) {}

  //If no streaming is used
  getJobPostings() {
    return this.http.get<JobPosting[]>(this.url);
  }

  //For server sent streams/events
  streamMessages(): Observable<JobPosting> {
    return new Observable(
      observer => {
        let source = new EventSource(this.url);
        source.onmessage = event => {
          this.zone.run(() => {
            observer.next(event.data)
          })
        }

        source.onerror = event => {
          this.zone.run(() => {
            observer.error(event)
          })
        }
      }
    )
  }
}
