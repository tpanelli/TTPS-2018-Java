import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { UserService } from 'src/app/app.userService';

@Injectable({ providedIn: 'root' })
export class SesionGuard implements CanActivate {
    constructor(
        private router: Router,
        private userService: UserService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const logueado = this.userService.logueado();
        if (logueado) {
            // si esta logeado lo dejo activar la ruta
            return true;
        }
        // No esta logeado, entonces redirecciono a la pagina de login
        this.router.navigate(['/login']); // , { queryParams: { returnUrl: state.url } }
        return false;
    }
}
