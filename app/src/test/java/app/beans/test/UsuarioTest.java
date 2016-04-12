package app.beans.test;

import static org.junit.Assert.*;

import org.junit.*;

import app.beans.imp.UsuarioImp;
import app.controller.Util;

public class UsuarioTest {

    String nombreTest = "testingNombre";
    String apellidoTest = "testingApellido";
    String nickTest = "testingNick";
    String correoTest = "testingCorreo";
    boolean esUsuarioMusicoTestFalse = false;
    String webTest = "testingWeb";
    String grupoTest = "testingGrupo";
    String passwordTest = "testingPass";
    char[] arrayTestSalt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLOMNOPQRSTUVWXYZ$%&()".toCharArray();
    UsuarioImp sut;

    @Before
    public void setUp() throws Exception {

        try {
            sut = new UsuarioImp(nombreTest, apellidoTest, nickTest, correoTest, esUsuarioMusicoTestFalse, webTest,
                    grupoTest, passwordTest);
        }

        catch (ExceptionInInitializerError e) {

            throw new ExceptionInInitializerError("No se ha podido inicializar el SUT" + e);

        }
    }

    @After
    public void tearDown() throws Exception {

        try {

            sut = null;
        }

        catch (Exception e) {

            throw new ExceptionInInitializerError("No se ha podido destruir el SUT" + e);

        }
    }

    @Test
    public void shouldReturnTheUserName() {

        String actual = sut.getNombreDeUsuario();
        assertEquals(nombreTest, actual);
    }

    @Test
    public void shouldEstablishTheUserName() {

        String nuevo = "nuevoNombre";
        sut.setNombreDeUsuario(nuevo);
        assertEquals(nuevo, sut.getNombreDeUsuario());
    }

    @Test
    public void shouldReturnTheUserSurname() {

        String actual = sut.getApellidoDeUsuario();
        assertEquals(apellidoTest, actual);
    }

    @Test
    public void shouldEstablishTheUserSurname() {
        String nuevo = "nuevoApellido";
        sut.setApellidoDeUsuario(nuevo);
        assertEquals(nuevo, sut.getApellidoDeUsuario());
    }

    @Test
    public void shouldReturnTheUserNickname() {
        String actual = sut.getNickDeUsuario();
        assertEquals(nickTest, actual);
    }

    @Test
    public void shouldEstablishTheUserNickname() {
        String nuevo = "nuevoNick";
        sut.setNickDeUsuario(nuevo);
        assertEquals(nuevo, sut.getNickDeUsuario());
    }

    @Test
    public void shouldReturnTheUserEmail() {
        String actual = sut.getCorreoDeUsuario();
        assertEquals(correoTest, actual);
    }

    @Test
    public void shouldEstablishTheUserEmail() {
        String nuevo = "nuevoCorreo";
        sut.setCorreoDeUsuario(nuevo);
        assertEquals(nuevo, sut.getCorreoDeUsuario());
    }

    @Test
    public void shouldReturnTheUserMusicianVerification() {
        boolean actual = sut.getEsUsuarioMusico();
        assertEquals(esUsuarioMusicoTestFalse, actual);
    }

    @Test
    public void shouldEstablishTheUserMusicianVerification() {
        boolean nuevo = true;
        sut.setEsUsuarioMusico(nuevo);
        assertEquals(nuevo, sut.getEsUsuarioMusico());
    }

    @Test
    public void shouldReturnTheUserWeb() {
        String actual = sut.getWebDeUsuario();
        assertEquals(webTest, actual);
    }

    @Test
    public void shouldEstablishTheUserWeb() {
        String nuevo = "nuevaWeb";
        sut.setWebDeUsuario(nuevo);
        assertEquals(nuevo, sut.getWebDeUsuario());
    }

    @Test
    public void shouldReturnTheUserGroup() {
        String actual = sut.getGrupoDeUsuario();
        assertEquals(grupoTest, actual);
    }

    @Test
    public void shouldEstablishTheUserGroup() {
        String nuevo = "nuevoGrupo";
        sut.setGrupoDeUsuario(nuevo);
        assertEquals(nuevo, sut.getGrupoDeUsuario());
    }

    @Test
    public void shouldReturnTheUserPasswordHashed() {
        String hash = Util.hashPasswordSHA(passwordTest);
        assertEquals(hash, sut.getPasswordDeUsuario());
    }

    @Test
    public void shouldEstablishTheUserPasswordHashed() {
        String hash = Util.hashPasswordSHA(passwordTest);
        sut.setPasswordDeUsuario(passwordTest);
        assertEquals(hash, sut.getPasswordDeUsuario());
    }

    @Test
    public void shouldReturnTrueWhenSaltLenghtIsTwenty() {
        String salt = sut.getSaltPassword();
        assertTrue(salt.length() == 20);
    }

    @Test
    public void shouldEstablishANewUserSalt() {

        String anterior = sut.getSaltPassword();
        sut.setSaltPassword();
        assertNotEquals(anterior, sut.getSaltPassword());
    }
}
