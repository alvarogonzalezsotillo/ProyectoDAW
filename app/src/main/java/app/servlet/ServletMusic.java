package app.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletMusica")
public class ServletMusic extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletOutputStream outputStream = response.getOutputStream();

        String cancion = request.getParameter("cancionMelom");

        byte[] bytes = cancion.getBytes();

        writeBytesInStream(response, outputStream, bytes);


    }

    private void writeBytesInStream(HttpServletResponse response, ServletOutputStream outputStream, byte[] bytes) throws IOException {

        response.setContentType("audio/mpeg3");

        response.setContentLength(bytes.length);

        outputStream.write(bytes);

        outputStream.flush();
    }
}
