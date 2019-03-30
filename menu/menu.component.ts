import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/app.userService';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  perfil;
  constructor(private userService: UserService, private route: ActivatedRoute,
    private router: Router) {
      this.perfil = userService.getPerfil();
    }

  ngOnInit() {
  }

  logout() {
    this.userService.logout();
    this.router.navigate(['/login']);
  }

}
