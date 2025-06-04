package Modelo;

import Helper.Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
 * Clase responsable de cargar las lineas validas desde un archivo y añadirlas a credenciales .
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
       Helpers.creaArchivoSiNoExiste("DB/loginUsers.txt"); // Revisa si existe el archivo loginUsers cada vez que se carga el metodo
        try (BufferedReader lector = new BufferedReader(new FileReader("DB/loginUsers.txt"))) { //Esta logica es demasiado compleja como para implementar un boque try-catch
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(";")) {
                    credenciales.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());

        }
        // TODO: Ignorar líneas vacías o mal formateadas
    }
}