import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/LigneProd';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class MachinesService {
  
  private baseUrl = 'http://localhost:8080/api/Machines';

  constructor(private http: HttpClient) { }
  getmach(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getById/${id}`);
  }
  getAudits(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getaudit/${id}`);
  }
  createmach(machine: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add`, machine);
  }

  updatemach(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${id}`, value);
  }

  deletemach(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  getmachList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getall`);
  }
}
