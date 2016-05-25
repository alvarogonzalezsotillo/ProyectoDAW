package app.builder.test;

import app.beans.FollowerBean;
import app.builder.FollowerBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FollowerBuilderTest {

    private FollowerBuilder sut;

    private Long idUsuarioTest = 1L;
    private Long idFollowerTest = 2L;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new FollowerBuilder(idUsuarioTest,idFollowerTest);

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
    public void shouldCreateANewFollowerBean(){

        FollowerBean followerBean = sut.build();

        Long idUsuarioReturned = followerBean.getIdUsuario();
        Long idFollowerReturned = followerBean.getIdFollower();

        Assert.assertEquals(idUsuarioTest, idUsuarioReturned);
        Assert.assertEquals(idFollowerTest, idFollowerReturned);

    }

}
