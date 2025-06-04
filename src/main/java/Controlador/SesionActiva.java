package Controlador;

import Helper.Helpers;
import Modelo.DatosSesion;
import Modelo.GestorUsuarios;

import java.util.Scanner;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final String usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;

    public SesionActiva(String usuario, Boolean admin) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario);
    }

    /**
     * Ciclo de operaciones disponibles en sesión.
     */
    public void menuSesion() {
        // TODO: Mostrar opciones según si el usuario es admin o no.
        // TODO: Escribir tareas.
        // TODO: Registrar usuarios (solo admin).
        // TODO: Salir de sesión.
    }

    private void escribirTarea() {
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