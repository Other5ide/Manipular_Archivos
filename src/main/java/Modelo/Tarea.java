package Modelo;

public class Tarea {
    private String descripcion;
    private Prioridad prioridad;

    public String getDescripcion() {
        return descripcion;
    }
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.prioridad = null;
    }
}
