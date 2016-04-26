package app.model.test;

import static org.junit.Assert.*;

import app.helpers.HibernateHelper;
import app.utils.Util;
import org.hibernate.type.UUIDBinaryType;
import org.junit.*;

import app.beans.implementations.UsuarioBean;
import app.model.UsuarioDAO;

public class UsuarioDAOIT extends BaseIT<UsuarioDAO> {

    @Before
    public void setUp(){
        sut = new UsuarioDAO();
        open();
    }

    @Test
    public void shouldReturnAllUsuariosInsertedWhenCallingGetAll() {

        assertEquals(2, sut.getAllUsuarios().size());

    }

    @Test
    public void shouldReturnTheUsuarioIdentifiedByIdWhenCallingGetUsuarioById() {

        UsuarioBean usuarioReturned = sut.getUsuarioById(1L);
        assertEquals("nombreTest", usuarioReturned.getNombreDeUsuario());

    }

    @Test
    public void shouldReturnTrueWhenNickAndPasswordAreFindInDBWhenCallingLoginUsuario() {

        assertTrue(sut.loginUsuario("nickTest2","passwordTest2"));

    }

    @Test
    public void shouldDeleteTheUsuarioIdentifiedByIdWhenCallingDeleteUsuarioById(){

        sut.deleteUsuarioById(2L);
        assertEquals(1, sut.getAllUsuarios().size());

    }

    @Test
    public void shouldUpdateTheUsuarioWhenCallingUpdateUsuario() {

        UsuarioBean usuarioReturned = sut.getUsuarioById(1L);
        usuarioReturned.setCorreoDeUsuario("correoTest");
        assertNotNull(usuarioReturned.getCorreoDeUsuario());
        sut.updateUsuario(usuarioReturned);
        assertEquals("correoTest", sut.getUsuarioById(1L).getCorreoDeUsuario());

    }

    @Test
    public void shouldReturnAListOfNicksWhenCallingGetAllNicks() {

        assertNotNull(sut.getAllNicks());
        assertTrue(sut.getAllNicks().contains("nickTest2"));

    }

}
