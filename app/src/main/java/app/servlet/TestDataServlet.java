package app.servlet;

import app.beans.UsuarioBean;
import app.utils.UtilSessionHibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="testData", urlPatterns={"/testData"})
public class TestDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Session session = UtilSessionHibernate.initSession();

        Transaction tx = session.beginTransaction();
        UsuarioBean u1 = new UsuarioBean("alvaro","gonzalez","alvaro","","","","","alvaro",null);
        session.save(u1);



        tx.commit();
        response.getWriter().append(u1.toString());
    }

    private void writeBytesInStream(HttpServletResponse response, ServletOutputStream outputStream, byte[] bytes) throws IOException {

        response.setContentType("audio/mpeg3");

        response.setContentLength(bytes.length);

        outputStream.write(bytes);

        outputStream.flush();
    }
}
