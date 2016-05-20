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
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "timelineController")
@ViewScoped
public class TimelineController implements Controller, Serializable {

    @ManagedProperty(value = "#{melomDao}")
    private MelomDAO melomDao;

    private List<MelomBean> listaMeloms;

    public void init() {
        initSessionForDao();
        List<MelomBean> list = melomDao.getAllMelomsByIdFollower(UtilUserSession.getUserId());
        closeSession();
        this.listaMeloms = null;
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
}