import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login-component.html',
  styleUrls: ['./login-component.css']
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private http: HttpClient, private router: Router) {}

  onLogin() {
    const credentials = { username: this.username, password: this.password };

    this.http.post<any>('http://localhost:8080/api/auth/login', credentials).subscribe({
      next: (response) => {
        // Si el login es correcto, redirige a la ventana principal
        this.router.navigate(['/ventana-principal']);
      },
      error: (err) => {
        console.error('Error de autenticación', err);
        alert('Usuario o contraseña incorrectos');
      }
    });
  }
}
