package app.model.test;

import static org.junit.Assert.*;

import app.utils.Util;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import app.beans.implementations.UsuarioBean;
import app.model.UsuarioDAO;

public class UsuarioDAOIT {

    private static UsuarioDAO sut;
    private  static UsuarioBean usuarioTest = new UsuarioBean();
    private static UsuarioBean usuarioParaLog = new UsuarioBean();

    
    @BeforeClass
    public static void tearUp(){
        
        try {

            sut = new UsuarioDAO();

            usuarioTest.setNombreDeUsuario("NombreTest");
            usuarioTest.setPasswordDeUsuario("pass");
            sut.insertUsuario(usuarioTest);

            usuarioParaLog.setNickDeUsuario("nickTest");
            usuarioParaLog.setPasswordDeUsuario("passTest");
            sut.insertUsuario(usuarioParaLog);

            
        }

        catch (ExceptionInInitializerError e) {

            throw new ExceptionInInitializerError("No se ha podido inicializar el SUT" + e);

        }
        
    }

    @AfterClass
    public static void tearDown() throws Exception {
        
        sut = null;
        usuarioTest = null;
        
    }

    @Test
    public void shouldReturnAllUsuariosInsertedWhenCallingGetAll() {

        assertEquals(2, sut.getAllUsuarios().size());

    }

    @Test
    public void shouldReturnTheUsuarioIdentifiedByIdWhenCallingGetUsuarioById() {

        UsuarioBean usuarioReturned = sut.getUsuarioById(1L);
        assertEquals("NombreTest", usuarioReturned.getNombreDeUsuario());

    }

    @Test
    public void shouldReturnTrueWhenNickAndPasswordAreFindInDBWhenCallingLoginUsuario() {

        String salt = Util.getSalt();
        String passwordHashed = Util.hashPasswordSHA("passTest"+salt);
        assertTrue(sut.loginUsuario("nickTest",passwordHashed));

    }

    @Test
    public void shouldDeleteTheUsuarioIdentifiedByIdWhenCallingDeleteUsuarioById(){

        sut.deleteUsuarioById(1L);
        sut.deleteUsuarioById(2L);
        assertEquals(0, sut.getAllUsuarios().size());

    }

    @Test
    public void shouldUpdateTheUsuarioWhenCallingUpdateUsuario() {

        UsuarioBean usuarioReturned = sut.getUsuarioById(1L);
        usuarioReturned.setCorreoDeUsuario("CorreoTest");
        assertNotNull(usuarioReturned.getCorreoDeUsuario());
        sut.updateUsuario(usuarioReturned);
        assertEquals("CorreoTest", sut.getUsuarioById(1L).getCorreoDeUsuario());

    }

    @Test
    public void shouldReturnAListOfNicksWhenCallingGetAllNicks() {

        assertNotNull(sut.getAllNicks());
        assertTrue(sut.getAllNicks().contains("nickTest"));

    }

}
