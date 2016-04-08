package app.beans.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.beans.imp.UsuarioImp;

import static org.mockito.Mockito.*;

public class UsuarioTest {

	@Mock
	UsuarioImp sut;

	String nombreTest = "testingNombre";
	String apellidoTest = "testingApellido";
	String nickTest = "testingNick";
	String correoTest = "testingCorreo";
	String webTest = "testingWeb";
	boolean esUsuarioMusicoTestFalse = false;
	boolean esUsuarioMusicoTestTrue = true;
	String passwordTest = "testingPass";
	String saltPasswordTest = "testingSalt";

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

		sut.getNombreDeUsuario();

		when(sut.getNombreDeUsuario()).thenReturn(nombreTest);

		verify(sut).getNombreDeUsuario();

	}

	@Test
	public void testSetNombreDeUsuario() {

		sut.setNombreDeUsuario(apellidoTest);

		verify(sut).setNombreDeUsuario(apellidoTest);

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
