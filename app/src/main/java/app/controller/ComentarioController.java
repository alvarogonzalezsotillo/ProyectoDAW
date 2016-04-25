package app.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import app.beans.implementations.ComentarioBean;
import app.builder.ComentarioBuilder;
import app.model.ComentarioDAO;

@ManagedBean(name = "comentarioController")
@ViewScoped
public class ComentarioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ComentarioBuilder comentarioBuilder;

	private String texto;
    private Long idUsuario = (long) 1;
    private Long idTweet = (long) 1;
	
    @ManagedProperty(value = "#{comentarioDao}")
    private ComentarioDAO comentarioDao;
    
    public void insertComentario() {
	    comentarioBuilder = new ComentarioBuilder(texto, idUsuario, idTweet);
	    	
	    ComentarioBean comentario = comentarioBuilder.build();
	    	
	    comentarioDao.insertComentario(comentario);
    	
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

	public Long getIdTweet() {
		return idTweet;
	}

	public void setIdTweet(Long idTweet) {
		this.idTweet = idTweet;
	}

	public ComentarioDAO getComentarioDao() {
		return comentarioDao;
	}

	public void setComentarioDao(ComentarioDAO comentarioDao) {
		this.comentarioDao = comentarioDao;
	}
	
	
}
