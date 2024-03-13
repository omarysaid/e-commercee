import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseURL = "http://localhost:2020"; // Remove array brackets

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }

  addProduct(saveProducts: any): Observable<any> {
    return this.http.post(baseURL + "/Product", saveProducts);
  }

  getAllProducts(): Observable<any> {
    return this.http.get(baseURL + "/Product");
  }

  getProductById(id: number): Observable<any> {
    return this.http.get(baseURL + "/Product/" + id); // Add "/" before the endpoint
  }


  updateProduct(id: number, product: any): Observable<any> {
    return this.http.put(baseURL + "/Product/" + id, product);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(baseURL + "/Product/" + id);
  }
}


