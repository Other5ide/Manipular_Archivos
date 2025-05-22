/**
 * Clase encargada de verificar las credenciales del usuario.
 */
public class Login {

    DatosLogin datos = new DatosLogin();

    /**
     * Verifica si existe una línea con el formato exacto "usuario;clave".
     *
     * @param usuario nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @param datos objeto DatosLogin que contiene la lista de credenciales
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean autenticar(String usuario, String clave, DatosLogin datos) {
        String intento = usuario + ";" + clave;

        for (int i = 0; i < datos.credenciales.size(); i++) {
            if (intento.equals(datos.credenciales.get(i))) {
                return true;
            } else if (usuario.contentEquals(obtenerNombreDeDatos(datos.credenciales.get(i)))) {
                System.out.println("Contraseña incorrecta para el usuario " + usuario);
            }
        }
        return false;
    }

    public static String obtenerNombreDeDatos(String lineaCredencial) {
        String[] partes = lineaCredencial.split(";");
        if (partes.length > 1) {
            return partes[0];
        } else {
            System.out.println("No se encontró el carácter ';'");
            return null;
        }
    }
}