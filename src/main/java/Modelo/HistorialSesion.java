package Modelo;

import java.time.LocalDateTime;

public class HistorialSesion {
    private int cantidadTareasAgregadas;
    private LocalDateTime fechaInicioSesion;

    public HistorialSesion() {
        fechaInicioSesion = LocalDateTime.now();
        cantidadTareasAgregadas = 0;
    }

    public LocalDateTime getFechaInicioSesion() {
        return fechaInicioSesion;
    }

    public int getTareasAgregadas() {
        return cantidadTareasAgregadas;
    }

    public void setCantidadTareasAgregadas(int tareasAgregadas) {
        this.cantidadTareasAgregadas = tareasAgregadas;
    }

    @Override
    public String toString() {
        return "HistorialSesion{" +
                "Tareas creadas esta sesión: " + cantidadTareasAgregadas +
                ", Sesion iniciada el " + fechaInicioSesion +
                '}';
    }
}
