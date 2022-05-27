import {  HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/LigneProd';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class LinepService {
  
  private baseUrl = 'http://localhost:8080/api/LigneProd';

  constructor(private http: HttpClient) { }

  getLineProd(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getById/${id}`);
  }
  getAudits(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getaudit/${id}`);
  }
  createLineProd(lprod: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add`, lprod);
  }

  updateLineProd(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${id}`, value);
  }

  deletelprod(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  getlprodList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getall`);
  }
}
