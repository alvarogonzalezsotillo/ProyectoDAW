package app.model.test;


import app.beans.implementations.ComentarioBean;
import app.model.ComentarioDAO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComentarioDAOIT {

    private static ComentarioDAO sut;
    private  static ComentarioBean comentarioTest = new ComentarioBean();
    private  static ComentarioBean comentarioToDelete = new ComentarioBean();

    @BeforeClass
    public static void tearUp(){

        try {

            sut = new ComentarioDAO();

            comentarioTest.setTexto("TextoTest");
            comentarioTest.setIdUsuario(1L);
            comentarioTest.setIdTweet(1L);
            sut.insertComentario(comentarioTest);

            comentarioToDelete.setId(2L);
            sut.insertComentario(comentarioToDelete);

        }

        catch (ExceptionInInitializerError e) {

            throw new ExceptionInInitializerError("No se ha podido inicializar o insertar el SUT" + e);

        }

    }

    @AfterClass
    public static void tearDown() throws Exception {

        sut = null;
        comentarioTest = null;

    }

    @Test
    public void testAShouldReturnAllComentariosInsertedWhenCallingGetAll() {

        assertEquals(2, sut.getAllComentarios().size());

    }

    @Test
    public void testBShouldInsertNewComentarioInDBWhenCallingInsertComentario(){

        ComentarioBean comTest = new ComentarioBean();
        sut.insertComentario(comTest);
        assertEquals(3, sut.getAllComentarios().size());

    }

    @Test
    public void testCShouldReturnTheComentarioIdentifiedByIdWhenCallingGetComentarioById() {

        ComentarioBean comentarioReturned = sut.getComentarioyId(1L);
        assertEquals("TextoTest", comentarioReturned.getTexto());

    }

    @Test
    public void testDShouldDeleteTheComentarioIdentifiedByIdWhenCallingDeleteComentarioById(){

        sut.deleteComentarioById(2L);
        assertEquals(2, sut.getAllComentarios().size());

    }

    @Test
    public void testEShouldUpdateTheUsuarioWhenCallingUpdateUsuario() {

        ComentarioBean comentarioReturned = sut.getComentarioyId(1L);
        comentarioReturned.setTexto("NuevoTexto");
        assertNotNull(comentarioReturned.getTexto());
        sut.updateComentario(comentarioReturned);
        assertEquals("NuevoTexto", sut.getComentarioyId(1L).getTexto());

    }

    @Test
    public void testFShouldReturnAllComentariosFilterByIdUsuarioWhenCallingGetAllByIdUsuario(){

        ComentarioBean comTest1 = new ComentarioBean();
        comTest1.setIdUsuario(2L);

        ComentarioBean comTest2 = new ComentarioBean();
        comTest2.setIdUsuario(2L);

        sut.insertComentario(comTest1);
        sut.insertComentario(comTest2);

        assertEquals(2,sut.getAllByIdUsuario(2L).size());

    }

    @Test
    public void testGShouldReturnAllComentariosFilterByIdTweetWhenCallingGetAllByIdTweet(){

        ComentarioBean comTest1 = new ComentarioBean();
        comTest1.setIdTweet(2L);

        ComentarioBean comTest2 = new ComentarioBean();
        comTest2.setIdTweet(2L);

        sut.insertComentario(comTest1);
        sut.insertComentario(comTest2);

        assertEquals(2,sut.getAllByIdTweet(2L).size());

    }

}
