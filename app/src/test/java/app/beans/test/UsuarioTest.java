package app.beans.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.beans.imp.UsuarioImp;


import static org.mockito.Mockito.*;

public class UsuarioTest {

	String nombreTest = "testingNombre";
	String apellidoTest = "testingApellido";
	String nickTest = "testingNick";
	String correoTest = "testingCorreo";	
	boolean esUsuarioMusicoTestFalse = false;
	String webTest = "testingWeb";
	String grupoTest = "testingGrupo";
	String passwordTest = "testingPass";
	String saltPasswordTest = "testingSalt";
	
	UsuarioImp sut = new UsuarioImp(nombreTest,apellidoTest,nickTest,correoTest,esUsuarioMusicoTestFalse,webTest,grupoTest,passwordTest,saltPasswordTest);

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {

		sut = null;

	}

	@Test
	public void testGetNombreDeUsuario() {

		String actual = sut.getNombreDeUsuario();
		Assert.assertEquals(nombreTest, actual);

	}

	@Test
	public void testSetNombreDeUsuario() {

		Assert.assertEquals(nombreTest, sut.getNombreDeUsuario());
		
	}

	@Test
	public void testGetApellidoDeUsuario() {

		sut.getApellidoDeUsuario();

		when(sut.getApellidoDeUsuario()).thenReturn(apellidoTest);

		verify(sut).getApellidoDeUsuario();
	}
	
	/*

	@Test
	public void testSetApellidoDeUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNickDeUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNickDeUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCorreoDeUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCorreoDeUsuario() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetWebDeUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWebDeUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPasswordDeUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSaltPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEsUsuarioMusico() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEsUsuarioMusico() {
		fail("Not yet implemented");
	}
*/
}
