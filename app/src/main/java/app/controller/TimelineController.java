package app.controller;

import app.beans.MelomBean;
import app.controller.interfaces.Controller;
import app.model.MelomDAO;
import app.utils.UtilFacesContext;
import app.utils.UtilSessionHibernate;
import app.utils.UtilUserSession;
import app.utils.UtilViews;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "timelineController")
@ViewScoped
public class TimelineController implements Controller, Serializable {

    @ManagedProperty(value = "#{melomDao}")
    private MelomDAO melomDao;

    private List<MelomBean> listaMeloms;

    private boolean isAnonymous;

    public void init() {

        checkUserIsAnonymous();

        if(!isAnonymous){

            initSessionForDao();
            this.listaMeloms = melomDao.getAllMelomsByIdFollower(UtilUserSession.getUserId());
            closeSession();
        }
    }

    public void write(byte[] file) throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        ServletContext servletcontext = (ServletContext) facesContext.getExternalContext().getContext();

        try {

            response.setContentType("audio/mpeg");
            response.setContentLength(file.length);
            response.getOutputStream().write(file, 0, file.length);
            response.getOutputStream().flush();

            facesContext.responseComplete();
            facesContext.renderResponse();

        }
        catch (Exception e){

            System.out.print(e.getStackTrace());

        }
    }

    private void checkUserIsAnonymous() {

        if(UtilUserSession.getUserId() == null){

            isAnonymous = true;
        }

        else{

            isAnonymous = false;
        }

    }

    public void initSessionForDao() {
        Session session = UtilSessionHibernate.initSession();
        melomDao.setSession(session);
    }

    public void initTransactionForDao() {
        Session session = melomDao.getSession();
        UtilSessionHibernate.initTransaction(session);
    }

    public void commitAndCloseSession() {
        Session session = melomDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);
    }

    public void closeSession() {
        Session session = melomDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }

    public MelomDAO getMelomDao() {
        return melomDao;
    }

    public void setMelomDao(MelomDAO melomDao) {
        this.melomDao = melomDao;
    }

    public List<MelomBean> getListaMeloms() {
        return listaMeloms;
    }

    public void setListaMeloms(List<MelomBean> listaMeloms) {
        this.listaMeloms = listaMeloms;
    }

    public boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

}
