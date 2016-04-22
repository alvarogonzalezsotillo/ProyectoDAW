package app.beans.test;

import static org.junit.Assert.*;

import org.junit.*;

import app.beans.implementations.UsuarioBean;
import app.builder.UsuarioBuilder;
import app.controller.Util;

public class UsuarioTest {

    Long idTest = 1L;
    String nombreTest = "testingNombre";
    String apellidoTest = "testingApellido";
    String nickTest = "testingNick";
    String correoTest = "testingCorreo";
    boolean esUsuarioMusicoTestFalse = false;
    String tipoMusicaTest = "testingTipoMusica";
    String grupoTest = "testingGrupo";
    String webTest = "testingWeb";
    String passwordTest = "testingPass";
    String salt = Util.getSalt();
    UsuarioBean sut;

    UsuarioBuilder usuarioBuilder;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new UsuarioBean(nombreTest, apellidoTest, nickTest, correoTest, esUsuarioMusicoTestFalse, tipoMusicaTest,
                    grupoTest, webTest, passwordTest,null);
            sut.setId(idTest);

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
    public void shouldReturnTheUserId() {

        Long actual = sut.getId();
        assertEquals(idTest, actual);
    }

    @Test
    public void shouldEstablishTheUserID() {

        Long nuevo = 2L;
        sut.setId(nuevo);
        assertEquals(nuevo, sut.getId());
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
    public void shouldReturnTheUserMusicType() {
        String actual = sut.getTipoMusicaDeUsuario();
        assertEquals(tipoMusicaTest, actual);
    }

    @Test
    public void shouldEstablishTheUserMusicType() {
        String nuevo = "nuevoTipoMusica";
        sut.setTipoMusicaDeUsuario(nuevo);
        assertEquals(nuevo, sut.getTipoMusicaDeUsuario());
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
    public void shouldReturnTheUserPasswordHashed() {
        String hash = Util.hashPasswordSHA(passwordTest + salt);
        assertEquals(hash, sut.getPasswordDeUsuario());
    }

    @Test
    public void shouldEstablishTheUserPasswordHashed() {
        String hash = Util.hashPasswordSHA(passwordTest + salt);
        sut.setPasswordDeUsuario(passwordTest);
        assertEquals(hash, sut.getPasswordDeUsuario());
    }
}
