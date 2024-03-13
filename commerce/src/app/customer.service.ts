import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseURL = ["http://localhost:2020/"];

@Injectable({
  providedIn: 'root'
})
export class CustomerService {


  constructor(private http: HttpClient) { }


  addCustomer(customersSave: any): Observable<any> {
    return this.http.post(baseURL + "customer", customersSave);
  }

  getAllCustomers(): Observable<any> {
    return this.http.get(baseURL + "customer");
  }

  updateCustomer(id: number, editCustomer: any): Observable<any> {
    return this.http.put(baseURL + "customer" + id, editCustomer);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(baseURL + "customer/" + id);
  }
}
