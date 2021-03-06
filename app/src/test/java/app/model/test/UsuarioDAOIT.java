package app.model.test;

import app.beans.UsuarioBean;
import app.model.UsuarioDAO;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDAOIT extends BaseIT<UsuarioDAO> {

    @Before
    public void setUp() {
        sut = new UsuarioDAO();
        open();
    }

    @Test
    public void shouldReturnAllUsuariosInsertedWhenCallingGetAll() {

        assertEquals(2, sut.getAll().size());

    }

    @Test
    public void shouldReturnTheUsuarioIdentifiedByIdWhenCallingGetById() {

        UsuarioBean usuarioReturned = sut.getById(1L);
        assertEquals("nombreTest", usuarioReturned.getNombreDeUsuario());

    }

    @Test
    public void shouldReturnTheUsuarioIdWhenCallingGetUserId() {

        Long userId = sut.getUserId("nickTest");
        assertEquals((Long) 1L, userId);

    }

    @Test
    public void shouldReturnTrueWhenNickAndPasswordAreFindInDBWhenCallingLoginUsuario() {

        assertTrue(sut.loginUsuario("nickTest", "passwordTest"));

    }


    @Test
    public void shouldUpdateTheUsuarioWhenCallingUpdate() {

        UsuarioBean usuarioReturned = sut.getById(1L);
        usuarioReturned.setCorreoDeUsuario("correoTest");
        assertNotNull(usuarioReturned.getCorreoDeUsuario());
        sut.update(usuarioReturned);
        assertEquals("correoTest", sut.getById(1L).getCorreoDeUsuario());

    }

    @Test
    public void shouldReturnAListOfNicksWhenCallingGetAllNicks() {

        assertNotNull(sut.getAllNicks());
        assertTrue(sut.getAllNicks().contains("nickTest2"));

    }

    @Test
    public void shouldZDeleteTheUsuarioIdentifiedByIdWhenCallingDeleteById() {

        sut.deleteById(2L);
        assertEquals(1, sut.getAll().size());

    }
}
