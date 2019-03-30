import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserService } from './app.userService';
import { CarteleraService } from './app.carteleraService';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { MenuComponent } from './menu/menu.component';
import { MenuAdminComponent } from './menu-admin/menu-admin.component';
import { MenuDocenteComponent } from './menu-docente/menu-docente.component';
import { MenuAlumnoComponent } from './menu-alumno/menu-alumno.component';
import { MenuPublicadorComponent } from './menu-publicador/menu-publicador.component';
import { NuevaCarteleraComponent } from './nueva-cartelera/nueva-cartelera.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    LoginComponent,
    RegistroComponent,
    MenuComponent,
    MenuAdminComponent,
    MenuDocenteComponent,
    MenuAlumnoComponent,
    MenuPublicadorComponent,
    NuevaCarteleraComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService,
    CarteleraService],
  bootstrap: [AppComponent]
})
export class AppModule { }
