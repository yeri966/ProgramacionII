import co.edu.uniquindio.Banco;
import co.edu.uniquindio.Usuario;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BancoTest {
    private Banco plataforma;

    @BeforeEach
    void setUp() {
        plataforma = new Banco();
        plataforma.agregarUsuario("Elizabeth Bedoya", "Calle 123", "12345678", "elizaB@mail.com", "password");
    }

    @Test
    void testRegistroYAutenticacionUsuario() {
        Usuario usuario = plataforma.autenticarUsuario("12345678", "password");
        assertNotNull(usuario);
    }

    @Test
    void testAutenticacionFallida() {
        assertThrows(IllegalArgumentException.class, () -> plataforma.autenticarUsuario("12345678", "wrongpassword"));
    }

    @Test
    void testRecargaBilletera() {
        Usuario usuario = plataforma.autenticarUsuario("12345678", "password");
        usuario.getBilletera().recargar(5000);
        assertEquals(5000, usuario.getBilletera().getSaldo());
    }

    @Test
    void testRecargaBilleteraMontoNegativo() {
        Usuario usuario = plataforma.autenticarUsuario("12345678", "password");
        assertThrows(IllegalArgumentException.class, () -> usuario.getBilletera().recargar(-1000));
    }

    @Test
    void testTransferenciaExitosa() {
        Usuario usuario1 = plataforma.autenticarUsuario("12345678", "password");
        Usuario usuario2 = new Usuario("Ana", "Calle 456", "87654321", "ana@mail.com", "pass123");
        usuario1.getBilletera().recargar(10000);
        usuario1.getBilletera().transferir(usuario2.getBilletera(), 5000);
        assertEquals(4800, usuario1.getBilletera().getSaldo());
        assertEquals(5000, usuario2.getBilletera().getSaldo());
    }

    @Test
    void testTransferenciaSaldoInsuficiente() {
        Usuario usuario1 = plataforma.autenticarUsuario("12345678", "password");
        Usuario usuario2 = new Usuario("Ana", "Calle 456", "87654321", "ana@mail.com", "pass123");
        assertThrows(IllegalArgumentException.class, () -> usuario1.getBilletera().transferir(usuario2.getBilletera(), 5000));
    }
}
