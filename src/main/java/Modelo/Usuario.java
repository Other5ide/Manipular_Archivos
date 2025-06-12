package Modelo;

public class Usuario {
    private String nombre;
    private String clave;
    private Perfil perfil;
    private String correo;

    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
        //this.perfil = new Perfil();

    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
