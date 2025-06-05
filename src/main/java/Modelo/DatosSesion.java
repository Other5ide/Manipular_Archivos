package Modelo;

import Helper.Helpers;

import java.io.*;
import java.util.Scanner;

/**
 * Maneja las tareas personales de un usuario autenticado.
 */
public class DatosSesion {
    private final String nombreArchivo;

    public DatosSesion(String usuario) {
        this.nombreArchivo = "TODO/"+usuario + "_todo.txt";
        Helpers.creaArchivoSiNoExiste(nombreArchivo);
    }

    /**
     * Crea el archivo de tareas si no existe.
     */

    /**
     * Escribe una nueva tarea al final del archivo.
     *
     * @param tarea Texto de la tarea.
     * @return true si se guardó correctamente, false si ocurrió un error.
     */
    public boolean escribirTarea(String tarea) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            escritor.write(tarea);
            escritor.newLine();
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir tarea: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Muestra todas las tareas almacenadas en el archivo.
     */
    public void mostrarTareas() {
            try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) { //Esta logica es demasiado compleja como para implementar un boque try-catch
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                    }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());

            }
    }
}