package Controlador;

import Modelo.DatosLogin;

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
    public boolean autenticar(String usuario, String clave, DatosLogin datos) {
        String intento = usuario + ";" + clave;

        for (int i = 0; i < datos.credenciales.size(); i++) {
            try {
                if (intento.equals(datos.credenciales.get(i))) {
                    return true;
                } else if (usuario.contentEquals(obtenerNombreDesdeDatos(datos.credenciales.get(i)))) {
                    System.out.println("Contraseña incorrecta para el usuario " + usuario);
                }
            } catch (NullPointerException npe) {
                System.out.println("Usuario no encontrado");
            }
        }
        return false;
    }

    public static String obtenerNombreDesdeDatos(String lineaCredencial) {
        String[] partes = lineaCredencial.split(";");
        if (partes.length > 1) {
            return partes[0];
        } else {
            return null;
        }
    }
}