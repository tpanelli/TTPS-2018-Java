import { Component, OnInit } from '@angular/core';
import { Cartelera } from './cartelera';
import { CarteleraService } from '../app.carteleraService';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-nueva-cartelera',
  templateUrl: './nueva-cartelera.component.html',
  styleUrls: ['./nueva-cartelera.component.css']
})
export class NuevaCarteleraComponent {

  constructor(private carteleraService: CarteleraService, private route: ActivatedRoute,
    private router: Router ) { }

  model = new Cartelera('', '', -1);
  submitted = false;
  error = '';

  onSubmit() {
    this.enviarCartelera();
    this.submitted = true;
  }

  enviarCartelera() {
    this.carteleraService.enviarCartelera(this.model).subscribe(
      res => {
              this.router.navigate(['/inicio']);
      },
      error => this.error = 'Ya existe una cartelera con ese nombre'
      );
  }


}
