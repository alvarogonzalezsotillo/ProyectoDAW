package app.controller;

import app.beans.implementations.ConciertoBean;
import app.builder.ConciertoBuilder;
import app.controller.interfaces.Controller;
import app.model.ConciertoDAO;
import app.utils.UtilSessionHibernate;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "conciertoController")
@ViewScoped
public class ConciertoController implements Serializable, Controller{

    private static final long serialVersionUID = 1L;

    private ConciertoBuilder conciertoBuilder;

    private String pais;
    private String ciudad;
    private String lugar;
    private Long idUsuario;

    @ManagedProperty(value = "#{conciertoDao}")
    ConciertoDAO conciertoDao;


    public void insertConcierto(){

        conciertoBuilder = new ConciertoBuilder(idUsuario,lugar,ciudad,pais);

        ConciertoBean comentario = conciertoBuilder.build();

        initSessionForDao();
        initTransactionForDao();
        conciertoDao.insert(comentario);
        commitAndCloseSession();

    }

    public void initSessionForDao(){
        Session session = UtilSessionHibernate.initSession();
        conciertoDao.setSession(session);
    }

    public void commitAndCloseSession(){
        Session session = conciertoDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);

    }

    public void closeSession(){
        Session session = conciertoDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }

    public void initTransactionForDao(){
        Session session = conciertoDao.getSession();
        UtilSessionHibernate.initTransaction(session);

    }

    public ConciertoBuilder getConciertoBuilder() {
        return conciertoBuilder;
    }

    public void setConciertoBuilder(ConciertoBuilder conciertoBuilder) {
        this.conciertoBuilder = conciertoBuilder;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ConciertoDAO getConciertoDao() {
        return conciertoDao;
    }

    public void setConciertoDao(ConciertoDAO conciertoDao) {
        this.conciertoDao = conciertoDao;
    }
}
