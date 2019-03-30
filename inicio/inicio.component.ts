import { Component, OnInit } from '@angular/core';
import { CarteleraService } from 'src/app/app.carteleraService';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  carteleras: Object;
  constructor(private carteleraService: CarteleraService, private route: ActivatedRoute,
    private router: Router) {
      this.getCarteleras();
  }

  ngOnInit() {
  }

  getCarteleras() {
    this.carteleraService.getCarteleras().subscribe(
      res => {this.carteleras = res; } );
  }

}
