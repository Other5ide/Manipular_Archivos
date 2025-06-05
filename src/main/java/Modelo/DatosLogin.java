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
    public ArrayList<String> credencialesAdmins = new ArrayList<>();

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
        cargarAdmins("DB/admins.txt");
        cargarUsuarios("DB/loginUsers.txt");
    }
    /**
     * Lee el archivo login.txt y agrega las líneas válidas a la lista de credenciales.
     */
    private void cargarUsuarios(String filePath) {
       Helpers.creaArchivoSiNoExiste(filePath); // Revisa si existe el archivo cada vez que se carga el metodo
        try (BufferedReader lector = new BufferedReader(new FileReader(filePath))) { //Esta logica es demasiado compleja como para implementar un boque try-catch
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(";")) {
                    credenciales.add(linea); //TODO: limpiar los caracteres invalidos como ';' y espacios
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());

        }
    }
    private void cargarAdmins(String filePath) {
        Helpers.creaArchivoSiNoExiste(filePath); // Revisa si existe el archivo cada vez que se carga el metodo
        try (BufferedReader lector = new BufferedReader(new FileReader(filePath))) { //Esta logica es demasiado compleja como para implementar un boque try-catch
            String linea;
            while ((linea = lector.readLine()) != null) {
                    credencialesAdmins.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());

        }
    }
}