package Controlador;

import Helper.Helpers;
import Modelo.DatosSesion;
import Modelo.GestorUsuarios;

import java.util.Scanner;
//TODO: al crearse este objeto falla algo -> GestorUsuarios
/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private boolean adminPrivileges = false;
    private final String usuario;
    private final DatosSesion datosSesion;
    static Scanner scanner = new Scanner(System.in);

    public SesionActiva(String usuario, Boolean admin) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario);
        if (admin) {
            this.adminPrivileges = true;
        }
    }

    /**
     * Ciclo de operaciones disponibles en sesión.
     */
    public void menuSesion() {
        String opcion;
        do {
            mostrarOpciones();
            if (adminPrivileges) {
                mostrarOpciones();
            }
            opcion = scanner.nextLine();
            ejecutarOpcion(opcion);

        } while (!opcion.equals("2"));
        // TODO: Mostrar opciones según si el usuario es admin o no.
        // TODO: Escribir tareas.
        // TODO: Registrar usuarios (solo admin).
        // TODO: Salir de sesión.
    }

    private static void ejecutarOpcion(String opcion) {
        switch (opcion) {
            case "1" -> escribirTarea();
            case "2" -> {
                System.out.println("Cerrar Sesion...");
                scanner.close();
            }
            default -> System.out.println("Opcion invalida");
        }
    }

    private void mostrarOpciones() {
        if (adminPrivileges) {
            System.out.println("Sesion activa como Administrador:");
            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Añadir tarea a tu lista TODO");
            System.out.println("2. Cerrar Sesion");
            System.out.println("3. Registrar usuario");
        } else {
            System.out.println("Sesion activa como usuario:");
            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Añadir tarea a tu lista TODO");
            System.out.println("2. Cerrar Sesion");
        }

    }


    private static void escribirTarea() {
        // TODO: Pedir tarea al usuario y delegar a datosSesion.
    }

    private void registrarUsuario() {
        System.out.println("Ingrese el nuevo usuario: ");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese la nueva contraseña: ");
        String contrasena = scanner.nextLine();
        GestorUsuarios gestor = new GestorUsuarios(Helpers.quitarEspacios(usuario),Helpers.quitarEspacios(contrasena));

    }
}