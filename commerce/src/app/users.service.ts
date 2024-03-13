import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseURL = ["http://localhost:2020/"];

@Injectable({
  providedIn: 'root'
})

export class UsersService {

  constructor(private http: HttpClient) { }

  addUser(saveUsers: any): Observable<any> {
    return this.http.post(baseURL + "user", saveUsers);
  }

  getAllUsers(): Observable<any> {
    return this.http.get(baseURL + "user");
  }

  updateUser(id: number, editUser: any): Observable<any> {
    return this.http.put(baseURL + "user" + id, editUser);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(baseURL + "user/" + id);
  }
}
