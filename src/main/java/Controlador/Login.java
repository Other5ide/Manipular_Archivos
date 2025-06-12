package Controlador;

import Helper.Helpers;
import Modelo.DatosLogin;
import Modelo.Usuario;

import java.util.ArrayList;

/**
 * Clase encargada de verificar las credenciales del usuario.
 */
public class Login {

    DatosLogin datos = new DatosLogin();

    /**
     * Verifica si existe una línea con el formato exacto "usuario;clave y se encarga de auntenticar las credenciales".
     *
     * @param usuario nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @param datos objeto Modelo.DatosLogin que contiene la lista de credenciales
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public Usuario autenticar(String usuario, String clave, DatosLogin datos) {
        String intento = usuario + ";" + clave;

        if (validarUsuario(datos.listaUsuarios, intento)) {
            return new Usuario(usuario, clave);
        } else {
            System.out.println("contraseña o nombre de usuario incorrectos");
            return null;
        }

    }

    public boolean esAdmin(String usuario) {
        if (Helpers.contieneCoincidencia(datos.listaAdmins, usuario)){
            return true;
        }
        return false;
    }

    public static boolean validarUsuario(ArrayList<Usuario> listaUsuarios, String intento) {
        // Validación de parámetros
        if (listaUsuarios == null || intento == null) {
            return false;
        }

        // Buscar coincidencia exacta
        for (Usuario elemento : listaUsuarios) {
            if ((elemento.getNombre()+";"+elemento.getClave()).equals(intento)) {
                return true;
            }
        }

        return false;
    }
}