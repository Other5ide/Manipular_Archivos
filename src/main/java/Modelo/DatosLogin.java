package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
 * Clase responsable de cargar las credenciales desde un archivo.
 */
public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
        cargarUsuarios();
    }

    /**
     * Lee el archivo login.txt y agrega las líneas válidas a la lista de credenciales.
     */
    private void cargarUsuarios() {
        try (BufferedReader lector = new BufferedReader(new FileReader("DB/loginUsers.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(";")) {
                    credenciales.add(linea.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            creaArchivoSiNoExiste("DB/loginUsers.txt");
        }
        // TODO: Ignorar líneas vacías o mal formateadas
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
}