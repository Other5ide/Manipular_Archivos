package Modelo;

import Controlador.SesionActiva;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Perfil {
    private Usuario usuario;
    private String correo;
    private static final LocalDateTime fechaCreacion = LocalDateTime.now();
    private int tareasPrioridadBaja = 0;
    private int tareasPrioridadMedia = 0;
    private int tareasPrioridadAlta = 0;
    private final ArrayList<Tarea> listaTareas;

    public Perfil(String nombre, String clave) {
        this.usuario = new Usuario(nombre,clave);
        this.correo = correo;
        DatosSesion datosSesion = new DatosSesion(usuario.getNombre());
        this.listaTareas = datosSesion.getTareas();
    }

    public String getCorreo() {
        return correo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void contarPrioridadesDeTareas() {
        for (Tarea tarea : listaTareas) {
            switch (tarea.getPrioridad()){
                case BAJA -> tareasPrioridadBaja++;
                case MEDIA -> tareasPrioridadMedia++;
                case ALTA -> tareasPrioridadAlta++;
                default -> throw new IllegalStateException("Unexpected value: " + tarea.getPrioridad());

            }
        }
    }
    @Override
    public String toString() {
        return "Perfil{" +
                "tareasPrioridadBaja=" + tareasPrioridadBaja +
                ", tareasPrioridadMedia=" + tareasPrioridadMedia +
                ", tareasPrioridadAlta=" + tareasPrioridadAlta +
                '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
