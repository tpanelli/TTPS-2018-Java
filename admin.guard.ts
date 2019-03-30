import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { UserService } from 'src/app/app.userService';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  constructor(
    private router: Router,
    private userService: UserService
) { }

canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const logueado = this.userService.logueado();
    if (logueado) {
        if (this.userService.getPerfil() === 1) {
          return true;
        } else {
          this.router.navigate(['/inicio']);
          return false;
        }
    } else {
      this.router.navigate(['/login']); // , { queryParams: { returnUrl: state.url } }
      return false;
    }
}
}
