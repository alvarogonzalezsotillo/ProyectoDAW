package app.utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

public class UtilFacesContext {

    private static FacesContext getFacesContext() {

        return FacesContext.getCurrentInstance();
    }

    public static void writeFile(byte[] file) throws IOException {
        FacesContext facesContext = getFacesContext();
        ExternalContext externalContext = facesContext.getExternalContext();

        externalContext.setResponseContentType("audio/mpeg3");
        externalContext.setResponseContentLength(file.length);
        externalContext.getResponseOutputStream().write(file);
        externalContext.getResponseOutputStream().flush();
//        facesContext.responseComplete();
    }

}
