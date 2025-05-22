import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    static Scanner scanner = new Scanner(System.in);
    DatosLogin datos = new DatosLogin();
    Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public static void menu() {
        String opcion;

        do {
            mostrarOpciones();
            opcion = scanner.nextLine();
            ejecutarOpcion(opcion);

        } while (!opcion.equals("2"));
    }

    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private static void mostrarOpciones() {
        System.out.println("Consola Login");
        System.out.println("Selecciona una opcion: ");
        System.out.println("1. Log In");
        System.out.println("2. Salir");
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private static void ejecutarOpcion(String opcion) {
        switch (opcion) {
            case "1" -> manejarLogin();
            case "2" -> {
                System.out.println("Saliendo del Sistema...");
                scanner.close();
            }
            default -> System.out.println("Opcion invalida");
        }
    }

    /**
     * Solicita usuario y contraseña, y muestra el resultado.
     */
    private static void manejarLogin() {
        System.out.println("Ingrese el usuario: ");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        Login login = new Login();
        if (login.autenticar(usuario, contrasena, new DatosLogin())) {
            System.out.println("Se ha autenticado el usuario, bienvenido al sistema");
        } else {
            System.out.println("Inicio de sesion fallido");
        }


        // TODO: Pedir usuario y contraseña por consola
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
    }
}