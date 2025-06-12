package Modelo;

public class Tarea {
    private String descripcion;
    private enum prioridad {LOW, MEDIUM, HIGH};

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
    }
}
