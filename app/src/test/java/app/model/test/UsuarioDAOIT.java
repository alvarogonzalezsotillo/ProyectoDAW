package app.model.test;

import static org.junit.Assert.*;

import app.controller.Util;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import app.beans.imp.UsuarioImp;
import app.model.UsuarioDAO;

public class UsuarioDAOIT {

    private static UsuarioDAO sut;
    private  static UsuarioImp usuarioTest = new UsuarioImp();

    
    @BeforeClass
    public static void tearUp(){
        
        try {

            sut = new UsuarioDAO();
            usuarioTest.setNombreDeUsuario("NombreTest");
            usuarioTest.setNickDeUsuario("NickTest");
            usuarioTest.setPasswordDeUsuario("pass");
            sut.insertUsuario(usuarioTest);
            
            
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
        
        assertEquals(1, sut.getAll().size());
        
    }

    @Test
    public void shouldReturnTheUsuarioIdentifiedByIdWhenCallingGetUsuarioById() {
        
        UsuarioImp usuarioReturned = sut.getUsuarioById(1L);
        assertEquals("NombreTest", usuarioReturned.getNombreDeUsuario());
        
    }
    
    @Test
    public void shouldDeleteTheUsuarioIdentifiedByIdWhenCallingDeleteUsuarioById(){
        
        sut.deleteUsuarioById(1L);
        assertEquals(0, sut.getAll().size());
        
    }
    
    @Test
    public void shouldUpdateTheUsuarioWhenCallingUpdateUsuario() {
        
        UsuarioImp usuarioReturned = sut.getUsuarioById(1L);
        usuarioReturned.setNombreDeUsuario("NuevoNombre");
        sut.updateUsuario(usuarioReturned);
        assertNotEquals("NombreTest", usuarioReturned.getNombreDeUsuario());
        assertEquals("NuevoNombre", usuarioReturned.getNombreDeUsuario());
        
    }

    @Test
    public void shouldReturnTrueWhenNickAndPasswordAreFindInDBWhenCallingLoginUsuario() {

        String salt = Util.getSalt();
        String passwordHashed = Util.hashPasswordSHA("pass"+salt);
        assertTrue(sut.loginUsuario("NickTest",passwordHashed));

    }

}
