import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsolaLoginTest {

    @BeforeEach
    void setUp() {
        ConsolaLogin consolaLogin = new ConsolaLogin();
    }

    @Test
    void testConsolaLogin() {
        ConsolaLogin.menu();
    }
}