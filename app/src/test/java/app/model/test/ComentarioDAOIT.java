package app.model.test;


import app.beans.implementations.ComentarioBean;
import app.model.ComentarioDAO;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComentarioDAOIT extends BaseIT<ComentarioDAO>{

    @Before
    public void setUp(){
        sut = new ComentarioDAO();
        open();
    }

    @Test
    public void testShouldReturnAllComentariosInsertedWhenCallingGetAll() {

        assertEquals(2, sut.getAllComentarios().size());

    }


    @Test
    public void testShouldReturnTheComentarioIdentifiedByIdWhenCallingGetComentarioById() {

        ComentarioBean comentarioReturned = sut.getComentarioyId(1L);
        assertEquals("textoTest", comentarioReturned.getTexto());

    }



    @Test
    public void testShouldUpdateTheUsuarioWhenCallingUpdateUsuario() {

        ComentarioBean comentarioReturned = sut.getComentarioyId(1L);
        comentarioReturned.setTexto("nuevoTexto");
        assertNotNull(comentarioReturned.getTexto());
        sut.updateComentario(comentarioReturned);
        assertEquals("nuevoTexto", sut.getComentarioyId(1L).getTexto());

    }

    @Test
    public void testShouldReturnAllComentariosFilterByIdUsuarioWhenCallingGetAllByIdUsuario(){

        assertEquals(2,sut.getAllByIdUsuario(1L).size());

    }

    @Test
    public void testShouldReturnAllComentariosFilterByIdTweetWhenCallingGetAllByIdTweet(){


        assertEquals(2,sut.getAllByIdTweet(1L).size());

    }

    @Test
    public void testZShouldDeleteTheComentarioIdentifiedByIdWhenCallingDeleteComentarioById(){

        sut.deleteComentarioById(2L);
        assertEquals(1, sut.getAllComentarios().size());

    }

}
