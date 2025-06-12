package Helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Helpers {

    public static String quitarEspacios(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static boolean creaArchivoSiNoExiste(String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                // Intenta crear el archivo y sus directorios padres si no existen
                file.getParentFile().mkdirs(); // Crea directorios padres si es necesario
                return file.createNewFile(); // Devuelve true si se creó exitosamente
            }
            return true; // El archivo ya existía
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
            return false;
        }
    }
    public static boolean contieneCoincidencia(ArrayList<String> lista, String busqueda) {
        // Validación de parámetros
        if (lista == null || busqueda == null) {
            return false;
        }

        // Buscar coincidencia exacta
        for (String elemento : lista) {
            if (busqueda.equals(elemento)) {
                return true;
            }
        }

        return false;
    }
    public static String obtenerParteDesdeLinea(String lineaCredencial, int parteDeLinea) { //El texto antes del ';' de una linea es considerado una parte. El valor minimo de parteDeLinea es 0 y corresponde al nombre de usuario
        String[] partes = lineaCredencial.split(";");
        if (partes.length > 1) {
            return partes[parteDeLinea];
        } else {
            return null;
        }
    }
    public static String obtenerParteDesdeLinea(String lineaCredencial) { //si no se especifica la parteDeLinea, el metodo asume que es igual a 0 (referencia a la parte 1, la cual es el nombre de usuario)
        return obtenerParteDesdeLinea(lineaCredencial, 0);
    }
}
