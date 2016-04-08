package app.beans.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import app.beans.imp.UsuarioImp;

import static org.mockito.Mockito.*;

public class TestUsuario {
	
	UsuarioImp usuarioTest = new UsuarioImp();
	
	String nombreTest = "NombreTest";
	String apellidoTest = "ApellidoTest";
	String nickTest = "NickTest";
	String correoTest = "CorreoTest";
	boolean esUsuarioMusicoTestFalse = false;
	boolean esUsuarioMusicoTestTrue = true;
	String passwordTest = "PasswordTest";
	String saltPasswordTest = "SaltPasswordTest";
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		
		usuarioTest = null;
		
	}

	@Test
	public void testSetNombreDeUsuario() {
		
		usuarioTest.setNombreDeUsuario(nombreTest);		
			
		assertNotNull(usuarioTest.getNombreDeUsuario());
		assertEquals(nombreTest, usuarioTest.getNombreDeUsuario());
		
	}

	@Test
	public void testGetNombreDeUsuario() {
		
		usuarioTest.setNombreDeUsuario(nombreTest);
		
		String nombreActual = usuarioTest.getNombreDeUsuario();			
		assertNotNull(usuarioTest.getNombreDeUsuario());
		assertEquals(nombreActual, nombreTest);
	}

	

}
