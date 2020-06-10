import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AddscheduledflyService {
  constructor(private http: HttpClient) { }
  url = 'http://localhost:8081';
  splice(arg0: number, arg1: number) {
    throw new Error('Method not implemented');
  }
  addScheduledFlight(flight): Observable<any> {
    return this.http.post<any>(`${this.url}/addScheduledFlight`, flight);
  }

  getAllFlight(): Observable<any> {
    return this.http.get<any>(`${this.url}/getAllFlight`);
  }

  updateScheduledFlight(flight): Observable<any> {
    return this.http.put<any>(`${this.url}/update-scheduledflightDetails`, flight);
  }
  
   deleteSchedule(flight: ScheduledFlight): Observable<any>{
     return this.http.delete<any>(`${this.url}/delete-scheduledflight/${flight.scheduledFId}`);
   }
}
