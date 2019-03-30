import { Component } from '@angular/core';
import { Registro } from './registro';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent {

  constructor() { }

  title = 'Sistema de carteleras Informatica UNLP';
  model = new Registro('', '', '', '');
  submitted = false;
  error = '';
  onSubmit() {
    this.submitted = true;
  }




}
