package Controlador;

import Helper.Helpers;
import Modelo.DatosSesion;
import Modelo.GestorUsuarios;

import java.util.Scanner;
/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private static boolean adminPrivileges = false;
    private final String usuario;
    private final DatosSesion datosSesion;
    static Scanner scanner = new Scanner(System.in);

    public SesionActiva(String usuario, Boolean admin) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario);
        adminPrivileges = admin;
        menuSesion();
    }

    /**
     * Ciclo de operaciones disponibles en sesión.
     */
    public void menuSesion() {
        String opcion;
        do {
            mostrarOpciones();
            opcion = scanner.nextLine();
            ejecutarOpcion(opcion);

        } while (!opcion.equals("2"));
    }

    private void ejecutarOpcion(String opcion) {
        switch (opcion) {
            case "1" -> escribirTarea();
            case "2" -> {
                System.out.println("Cerrando Sesion...");
            }
            case "3" -> {
                if (!adminPrivileges) {
                    System.out.println("No tiene permiso para ejecutar esta opcion");
                } else {
                    registrarUsuario();
                }
            }
            case "4" -> {datosSesion.mostrarTareas();
            }
            default -> System.out.println("Opcion invalida");
        }
    }

    private void mostrarOpciones() {
        if (adminPrivileges) {
            System.out.println("Sesion activa como Administrador.");
            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Añadir tarea a tu lista TODO");
            System.out.println("2. Cerrar Sesion");
            System.out.println("3. Registrar usuario");
            System.out.println("4. Mostrar tareas");
        } else {
            System.out.println("Sesion activa como usuario.");
            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Añadir tarea a tu lista TODO");
            System.out.println("2. Cerrar Sesion");
            System.out.println("4. Mostrar tareas");
        }

    }


    private void escribirTarea() {
        System.out.println("Escribe la tarea para agregar: ");
        String tarea = scanner.nextLine();
        System.out.println("Define la prioridad de la tarea: (0,1 o 2)");
        int prioridad = scanner.nextInt(); //TODO: Implementar un try para evitar un crash debido al ingreso de una letra
        while (prioridad < 0 || prioridad > 2) {
            System.out.println("Prioridad invalida: debe ser un numero entero entre 0 y 2");
            prioridad = scanner.nextInt();
        }

        if (this.datosSesion.escribirTarea(tarea, prioridad)) {
            System.out.println("Se ha escrito la tarea '" + tarea+"' existosamente");
        } else {
            System.out.println("No se ha podido escribir la tarea '" + tarea+"'");
        }
    }

    private void registrarUsuario() {
        System.out.println("Ingrese el nuevo usuario: ");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese la nueva contraseña: ");
        String contrasena = scanner.nextLine();
        GestorUsuarios gestor = new GestorUsuarios(Helpers.quitarEspacios(usuario),Helpers.quitarEspacios(contrasena));

    }
}