import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../model/login.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl:string = 'http://localhost:9099/api/v1';
  

  constructor(private httpClient: HttpClient) { }

  getUsers(){
    return this.httpClient.get<Login[]>(`${this.baseUrl}/getlogin`);
  }

  
}
