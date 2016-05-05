package app.controller;

import app.beans.ComentarioBean;
import app.builder.ComentarioBuilder;
import app.controller.interfaces.Controller;
import app.model.ComentarioDAO;
import app.utils.UtilSessionHibernate;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "comentarioController")
@ViewScoped
public class ComentarioController implements Serializable, Controller {
	
	private static final long serialVersionUID = 1L;
	
	private ComentarioBuilder comentarioBuilder;

	private String texto;
    private Long idUsuario = 1L;
    private Long idMelom = 1L;
	
    @ManagedProperty(value = "#{comentarioDao}")
    private ComentarioDAO comentarioDao;
    
    public void insertComentario() {
	    comentarioBuilder = new ComentarioBuilder(texto, idUsuario, idMelom);
	    	
	    ComentarioBean comentario = comentarioBuilder.build();

		initSessionForDao();
		initTransactionForDao();
	    comentarioDao.insert(comentario);
		commitAndCloseSession();
    	
    }

	public void deleteComentario(Long id) {

		initSessionForDao();
		initTransactionForDao();
		comentarioDao.deleteById(id);
		commitAndCloseSession();

	}

	public void listComentario() {

		initSessionForDao();
		List<ComentarioBean> listaComentarios = comentarioDao.getAll();//Falta saber como pasar este dato a la vista
		closeSession();

	}

	public void getComentario(Long id) {

		initSessionForDao();
		ComentarioBean comentarioReturned = comentarioDao.getById(id);//Falta saber como pasar este dato a la vista
		closeSession();

	}

	public void listComentarioByIdUsuario(Long idusuario) {

		initSessionForDao();
		List<ComentarioBean> listaComentariosFilterByIdUsuario = comentarioDao.getAllByIdUsuario(idusuario);//Falta saber como pasar este dato a la vista
		closeSession();

	}

	public void listComentarioByIdMelom(Long idMelom) {

		initSessionForDao();
		List<ComentarioBean> listaComentariosFilterByIdMelom = comentarioDao.getAllByIdMelom(idMelom);//Falta saber como pasar este dato a la vista
		closeSession();

	}

	public void updateComentario() {
		comentarioBuilder = new ComentarioBuilder(texto, idUsuario, idMelom);

		ComentarioBean comentario = comentarioBuilder.build();

		initSessionForDao();
		initTransactionForDao();
		comentarioDao.update(comentario);
		commitAndCloseSession();

	}

	public void initSessionForDao(){
		Session session = UtilSessionHibernate.initSession();
		comentarioDao.setSession(session);
	}

	public void commitAndCloseSession(){
		Session session = comentarioDao.getSession();
		UtilSessionHibernate.commitAndCloseSession(session);

	}

	public void closeSession(){
		Session session = comentarioDao.getSession();
		UtilSessionHibernate.closeSession(session);
	}

	public void initTransactionForDao(){
		Session session = comentarioDao.getSession();
		UtilSessionHibernate.initTransaction(session);

	}
    
	public ComentarioBuilder getComentarioBuilder() {
		return comentarioBuilder;
	}

	public void setComentarioBuilder(ComentarioBuilder comentarioBuilder) {
		this.comentarioBuilder = comentarioBuilder;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdMelom() {
		return idMelom;
	}

	public void setIdMelom(Long idMelom) {
		this.idMelom = idMelom;
	}

	public ComentarioDAO getComentarioDao() {
		return comentarioDao;
	}

	public void setComentarioDao(ComentarioDAO comentarioDao) {
		this.comentarioDao = comentarioDao;
	}
	
	
}
