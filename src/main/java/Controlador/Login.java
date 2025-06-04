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
        String intento = usuario + ";" + clave +";admin";


        for (int i = 0; i < datos.credenciales.size(); i++) { //Recorrer el arreglo credenciales de DatosLogin deberia ser un metodo aparte
            try { //Este bloque try-catch es demasiado complejo y generara problemas al hacer debugging
                if (intento.equals(datos.credenciales.get(i))) {
                    return true;
                } else if (usuario.contentEquals(obtenerCampoDesdeDatos(datos.credenciales.get(i)))) {
                    System.out.println("Contraseña incorrecta para el usuario " + usuario);
                }
            } catch (NullPointerException npe) {
                System.out.println("Usuario no encontrado");
            }
        }
        return false;
    }

    public static String obtenerCampoDesdeDatos(String lineaCredencial, int parteDeLinea) { //El texto antes del ';' de una linea es considerado una parte. El valor minimo de parteDeLinea es 0 y corresponde al nombre de usuario
        String[] partes = lineaCredencial.split(";");
        if (partes.length > 1) {
            return partes[parteDeLinea];
        } else {
            return null;
        }
    }
    public static String obtenerCampoDesdeDatos(String lineaCredencial) { //si no se especifica la parteDeLinea, el metodo asume que es igual a 0 (referencia a la parte 1, la cual es el nombre de usuario)
        return obtenerCampoDesdeDatos(lineaCredencial, 0);
    }

    public boolean esAdmin(String usuario, String clave, DatosLogin datos) {
        for (int i = 0; i < datos.credenciales.size(); i++) {
            if (datos.credenciales.get(i).equals("admin")) {}
        }
    return false;
    }
}