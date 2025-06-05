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
        if (usuario == null || usuario == "" || clave == null || clave == "") {
            System.out.println("Usuario o Clave no pueden estar vacios");
            return false;
        } if (estaTomadoElNombre(usuario, new DatosLogin()))
            return false;
        return true;
    }

    public boolean estaTomadoElNombre(String usuario, DatosLogin datos) {
        String nombreUsuario = usuario + ";";

        for (int i = 0; i < datos.credenciales.size(); i++) {
                if (nombreUsuario.equals(datos.credenciales.get(i))) {
                    return true;
                } else if (usuario.contentEquals(obtenerCampoDesdeDatos(datos.credenciales.get(i)))) {
                    System.out.println("El usuario '" + usuario + "' ya existe");
                }
        }
        return false;
    }

}
