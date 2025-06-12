package Modelo;

import Controlador.SesionActiva;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Perfil {
    private String correo;
    private static final LocalDateTime fechaCreacion = LocalDateTime.now();
    private ArrayList<Tarea> listaTareas = new ArrayList<>();

    Perfil(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getPrioridad() {
        return listaTareas.toString();
    }
}
