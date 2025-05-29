import Controlador.Login;
import Modelo.DatosLogin;
import Vista.ConsolaLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsolaLoginTest {

    @BeforeEach
    void setUp() {
        ConsolaLogin consolaLogin = new ConsolaLogin();
    }

    @Test
    void testLoginValido() {
        DatosLogin datosLogin = new DatosLogin();
        Login login = new Login();
        assertTrue(login.autenticar("a","a",datosLogin));
    }

    @Test
    void testUsuarioInvalido() {
        DatosLogin datosLogin = new DatosLogin();
        Login login = new Login();
        assertFalse(login.autenticar("aaa","a",datosLogin));
    }
}