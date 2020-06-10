import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  login(user): Observable<any> {
    return this.http.post<any>(`${this.url}/login-user`, user);
  }

   registerForm(flight): Observable<any> {
    return this.http.post<any>(`${this.url}/add-user`, flight);
  }
}
