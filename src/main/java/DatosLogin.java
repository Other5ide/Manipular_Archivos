import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        try (BufferedReader lector = new BufferedReader(new FileReader("login.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(";")) {
                    credenciales.add(linea.trim());
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        // TODO: Ignorar líneas vacías o mal formateadas
    }

}