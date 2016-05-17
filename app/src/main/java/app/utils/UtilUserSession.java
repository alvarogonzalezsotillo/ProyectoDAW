package app.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "userSession")
@ApplicationScoped
public class UtilUserSession {

    public static HttpSession getSession() {

        return (HttpSession) FacesContext.getCurrentInstance()
                                         .getExternalContext()
                                         .getSession(false);
    }

    public static HttpServletRequest getRequest() {

        return (HttpServletRequest) FacesContext.getCurrentInstance()
                                                .getExternalContext()
                                                .getRequest();
    }

    public static Long getUserId() {

        HttpSession session = getSession();

        if (session != null) {

            return (Long) session.getAttribute("userId");
        }

        else {

            return null;
        }
    }
}
