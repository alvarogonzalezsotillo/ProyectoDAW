package app.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.beans.imp.UsuarioImp;
import app.model.UsuarioDAO;

public class UsuarioDAOTest{

    private UsuarioDAO sut;
    private UsuarioImp usuarioTest = new UsuarioImp();
    
    @Before
    public void setUp() throws Exception{
        
        sut = new UsuarioDAO();
        
        sut.insertUsuario(usuarioTest);
 
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() {
        assertEquals(1, sut.getAll().size());
    }

   
}
