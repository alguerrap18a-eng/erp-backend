import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login-component/login-component';
import { VentanaPrincipalComponent } from './pages/ventana-principal/ventana-principal';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'ventana-principal', component: VentanaPrincipalComponent },
  { path: '**', redirectTo: 'login' }
];
