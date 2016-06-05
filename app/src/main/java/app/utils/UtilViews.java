package app.utils;

import org.mockito.internal.creation.instance.InstantationException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

public class UtilViews {

    private UtilViews() throws InstantiationError {

        throw new InstantationException("Clase estática no instanciable", null);

    }

    public static void redirectWithInfoMessage(String route, String summary, String detail) {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
            context.getCurrentInstance().addMessage(null, facesMessage);

            context.getExternalContext().redirect(route);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo redirigir" + e);
        }

    }

    public static void redirect(String route) {

        FacesContext context = FacesContext.getCurrentInstance();

        ExternalContext ec = context.getExternalContext();

        String contextPath = ec.getApplicationContextPath();

        try {

            context.getExternalContext().redirect(contextPath + route);

        } catch (IOException e) {

            throw new RuntimeException("No se pudo redirigir" + e);
        }
    }

    public static void sendErrorMessage(String summary, String detail) {

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

    }

    public static void sendFatalMessage(String summary, String detail) {

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

    }

    public static void sendWarningMessage(String summary, String detail) {

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

    }

    public static void sendInfoMessage(String summary, String detail) {

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

    }

}
