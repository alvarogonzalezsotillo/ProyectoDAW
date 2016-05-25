package app.beans.test;

import app.beans.FollowerBean;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FollowerTest {

    private Long idUsuarioTest = 2L;
    private Long idFollowerTest = 3L;

    FollowerBean sut;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new FollowerBean(idUsuarioTest,idFollowerTest);

        }

        catch (ExceptionInInitializerError e) {

            throw new ExceptionInInitializerError("No se ha podido inicializar el SUT" + e);

        }
    }

    @After
    public void tearDown() throws Exception {

        try {

            sut = null;
        }

        catch (Exception e) {

            throw new ExceptionInInitializerError("No se ha podido destruir el SUT" + e);

        }
    }

    @Test
    public void shouldReturnAllFollowerBeanAttributes(){

        Long idFollowerReturned = sut.getIdFollower();
        Long idUsuarioReturned = sut.getIdUsuario();

        Assert.assertEquals(idFollowerTest,idFollowerReturned);
        Assert.assertEquals(idUsuarioTest,idUsuarioReturned);

    }
}
