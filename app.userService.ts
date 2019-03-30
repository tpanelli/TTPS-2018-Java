import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }
    login(username: string, password: string) {
        const headers = new HttpHeaders(
            {'username': username,
            'password': password}
            );
         return this.http.post('http://localhost:8080/ttps-spring/autenticacion', {}, {headers: headers, observe: 'response'});
    }

    logout() {
        localStorage.clear();
      }

    logueado() {
      return (localStorage.getItem('userInfo') != null);
    }

    getPerfil() {
        const user = JSON.parse(localStorage.getItem('userInfo'));
        return user.perfil.id;
    }
}
