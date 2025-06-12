package Modelo;

import Helper.Helpers;

import java.io.*;
import static Controlador.Login.obtenerCampoDesdeDatos;

/**
 * Registra nuevos usuarios en login.txt.
 */
public class GestorUsuarios {
    private String archivo = "loginUsers.txt";

    public GestorUsuarios(String usuario, String clave) {
        Helpers.creaArchivoSiNoExiste("DB/LoginUsers.txt");
        registrar(usuario, clave);
    }

    public boolean registrar(String usuario, String clave) {
        if (validarRegistro(usuario, clave)) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter("DB/loginUsers.txt", true))) {
                escritor.write(usuario+";"+clave);
                escritor.newLine();
                escritor.flush();
            } catch (IOException e) {
                System.out.println("Error al registrar usuario: " + e.getMessage());
            }
            return true;
        }
        return false;
    }

    public boolean validarRegistro(String usuario, String clave) {
        if (usuario == null || usuario.isEmpty() || clave == null || clave.isEmpty()) {
            System.out.println("Usuario o Clave no pueden estar vacios");
            return false;
        }
        return !estaTomadoElNombre(usuario, new DatosLogin());
    }

    public boolean estaTomadoElNombre(String usuario, DatosLogin datos) {
        String nombreUsuario = usuario;

        for (int i = 0; i < datos.listaUsuarios.size(); i++) {
                if (nombreUsuario.equals(datos.listaUsuarios.get(i).getNombre())) {
                    System.out.println("El usuario '" + usuario + "' ya existe");
                    return true;
                }
        }
        return false;
    }


}
