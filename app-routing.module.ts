import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { SesionGuard } from 'src/app/sesion.guard';
import { AdminGuard } from 'src/app/admin.guard';
import { LoginGuard } from 'src/app/login.guard';
import { NuevaCarteleraComponent } from './nueva-cartelera/nueva-cartelera.component';

const routes: Routes = [
  {path: 'inicio', component: InicioComponent, canActivate: [SesionGuard]},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent, canActivate: [LoginGuard]},
  {path: 'registro', component: RegistroComponent},
  {path: 'nuevaCartelera', component: NuevaCarteleraComponent, canActivate: [AdminGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
