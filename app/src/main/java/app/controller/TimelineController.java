package app.controller;

import app.beans.MelomBean;
import app.controller.interfaces.Controller;
import app.model.MelomDAO;
import app.utils.UtilSessionHibernate;
import app.utils.UtilUserSession;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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