import { Login } from 'src/app/app.login';
import { UserService } from 'src/app/app.userService';
import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private userService: UserService, private route: ActivatedRoute,
    private router: Router ) { }

  title = 'Sistema de carteleras Informatica UNLP';
  model = new Login('', '');
  submitted = false;
  error = '';
  onSubmit() {this.login();
    this.submitted = true;
  }

  login() {

    this.userService.login(this.model.username, this.model.password).subscribe(
      res => {localStorage.setItem('token', res.headers.get('token'));
              localStorage.setItem('userInfo', JSON.stringify(res.body));
             this.router.navigate(['/inicio']); },
      error => this.error = 'Usuario o contraseña incorrectos. Por favor intente nuevamente.');
  }

}
