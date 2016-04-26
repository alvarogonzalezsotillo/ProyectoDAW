package app.controller;

import app.beans.implementations.UsuarioBean;
import app.builder.UsuarioBuilder;
import app.model.UsuarioDAO;
import app.utils.UtilSessionHibernate;
import org.hibernate.Session;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    private UsuarioBuilder usuarioBuilder;

    private String nombre;
    private String apellido;
    private String nick;
    private String password;
    private String correo;
    private String web;
    private String grupo;
    private String tipoMusica;
    private transient UploadedFile imagen;

    @ManagedProperty(value = "#{usuarioDao}")
    private UsuarioDAO usuarioDao;

    public void insert() {

        initSessionForDao();
        List<String> listNicks = usuarioDao.getAllNicks();
        closeSession();

        if(listNicks.contains(nick)){

            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Has sido más lento", "Otro usuario ha registrado el nick " + nick + ", elige otro.");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        }

        else{

            usuarioBuilder = new UsuarioBuilder(nombre, apellido, nick, password);

            UsuarioBean usuario = usuarioBuilder.correo(correo)
                                                .web(web)
                                                .grupo(grupo)
                                                .tipoMusica(tipoMusica)
                                                .imagen(imagen)
                                                .build();

            initSessionForDao();
            initTransactionForDao();
            usuarioDao.insert(usuario);
            commitAndCloseSession();


            try {

                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getFlash().setKeepMessages(true);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Bienvenid@ " + nombre +"!", "Tu usuario "+ nick +" ha sido registrado, ¡ahora a Rockear!");
                context.getCurrentInstance().addMessage(null, facesMessage);

                context.getExternalContext().redirect("/views/index/login.xhtml");

            }

            catch (IOException e) {

                throw new RuntimeException("Fallo en UsuarioController: no se pudo redirigir" + e);

            }

        }
    }

    private void initSessionForDao(){
        Session session = UtilSessionHibernate.initSession();
        usuarioDao.setSession(session);
    }

    private void commitAndCloseSession(){
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);

    }

    private void closeSession(){
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }

    private void initTransactionForDao(){
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.initTransaction(session);

    }

    public UsuarioBuilder getUsuarioBuilder() {

        return usuarioBuilder;
    }

    public void setUsuarioBuilder(UsuarioBuilder usuarioBuilder) {

        this.usuarioBuilder = usuarioBuilder;
    }

    public UsuarioDAO getUsuarioDao() {

        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {

        this.usuarioDao = usuarioDao;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public String getNick() {

        return nick;
    }

    public void setNick(String nick) {

        this.nick = nick;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getCorreo() {

        return correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public String getWeb() {

        return web;
    }

    public void setWeb(String web) {

        this.web = web;
    }

    public String getGrupo() {

        return grupo;
    }

    public void setGrupo(String grupo) {

        this.grupo = grupo;
    }

    public String getTipoMusica() {

        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {

        this.tipoMusica = tipoMusica;
    }

    public UploadedFile getImagen() {
        return imagen;
    }

    public void setImagen(UploadedFile imagen) {
        this.imagen = imagen;
    }
}
