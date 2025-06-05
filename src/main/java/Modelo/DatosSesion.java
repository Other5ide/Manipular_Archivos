package Modelo;

import Helper.Helpers;

import java.io.*;
import java.util.ArrayList;

/**
 * Maneja las tareas personales de un usuario autenticado.
 */
public class DatosSesion {
    private final String nombreArchivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();
    private final String usuario;


    public DatosSesion(String usuario) {
        this.nombreArchivo = "TODO/"+usuario + "_todo.txt";
        this.usuario = usuario;
        Helpers.creaArchivoSiNoExiste(nombreArchivo);
        cargarTareas();
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
            tareas.add(new Tarea(tarea));
        } catch (IOException e) {
            System.out.println("Error al escribir tarea: " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Muestra todas las tareas almacenadas en el archivo.
     */
    public void cargarTareas() {
            try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) { //Esta logica es demasiado compleja como para implementar un bloque try-catch
                String linea;
                while ((linea = lector.readLine()) != null) {
                    tareas.add(new Tarea(linea));
                    }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
    }
    public void mostrarTareas() {
        System.out.println("Tus tareas anotadas:");
        for (Tarea tarea : tareas) {
            System.out.println(tarea.getDescripcion());
        }
    }
}