import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend-erp');
  protected readonly mensaje = signal('Selecciona un módulo para interactuar');

  verDetalle(modulo: string) {
    this.mensaje.set(`Módulo seleccionado: ${modulo} (Listo para consumir /api/v3/)`);
  }
}
