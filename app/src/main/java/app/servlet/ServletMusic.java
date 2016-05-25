package app.servlet;

import app.beans.MelomBean;
import app.model.MelomDAO;
import app.servlet.interfaces.Servlet;
import app.utils.UtilSessionHibernate;
import org.hibernate.Session;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletMusica")
public class ServletMusic extends HttpServlet implements Servlet<MelomDAO> {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MelomDAO melomDao = initDao(request);

        ServletOutputStream outputStream = response.getOutputStream();

        String id = request.getParameter("idMelom");

        Long idMelom = Long.parseLong(id);

        initSessionForDao(melomDao);

        MelomBean melomReturned = melomDao.getById(idMelom);

        closeSession(melomDao);

        writeBytesInStream(response, outputStream, melomReturned);


    }

    private void writeBytesInStream(HttpServletResponse response, ServletOutputStream outputStream, MelomBean melomReturned) throws IOException {

        byte[] cancionBytes = melomReturned.getCancion();

        response.setContentType("audio/mpeg3");

        response.setContentLength(cancionBytes.length);

        outputStream.write(cancionBytes);

        outputStream.flush();
    }

    public MelomDAO initDao(HttpServletRequest request) {

        ServletContext context = request.getSession().getServletContext();
        return (MelomDAO) context.getAttribute("melomDao");
    }



    public void initSessionForDao(MelomDAO melomDao) {
        Session session = UtilSessionHibernate.initSession();
        melomDao.setSession(session);
    }

    public void initTransactionForDao(MelomDAO melomDao) {
        Session session = melomDao.getSession();
        UtilSessionHibernate.initTransaction(session);
    }

    public void commitAndCloseSession(MelomDAO melomDao) {
        Session session = melomDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);
    }

    public void closeSession(MelomDAO melomDao) {
        Session session = melomDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }
}
