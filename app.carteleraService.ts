import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cartelera } from './nueva-cartelera/cartelera';

@Injectable()
export class CarteleraService {
    constructor(private http: HttpClient) { }
    getCarteleras() {
        const token = localStorage.getItem('token');
        const headers = new HttpHeaders(
            {'token': token}
            );
         return this.http.get('http://localhost:8080/ttps-spring/carteleras', {headers: headers, observe: 'body'});
    }

    enviarCartelera(cartelera: Cartelera) {
        const token = localStorage.getItem('token');
        const headers = new HttpHeaders(
            {'token': token}
            );
            return this.http.post('http://localhost:8080/ttps-spring/carteleras', cartelera, {headers: headers, observe: 'body'});
    }
}
