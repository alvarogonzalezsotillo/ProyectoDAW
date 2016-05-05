package app.model;

import app.beans.ComentarioBean;
import app.model.interfaces.DAO;
import org.hibernate.Query;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "comentarioDao")
@ApplicationScoped
public class ComentarioDAO extends SessionFactoryImpl implements Serializable,DAO<ComentarioBean> {

    private static final long serialVersionUID = 1L;

    public ComentarioDAO(){

        super();

    }

    public void insert(ComentarioBean comentario){

        session.save(comentario);
    }

    public void update(ComentarioBean comentarioToUpdate){

        session.update(comentarioToUpdate);
    }

    public void deleteById(Long id){

        ComentarioBean comentarioToDelete = session.load(ComentarioBean.class, id);
        session.delete(comentarioToDelete);
    }

    @SuppressWarnings("unchecked")
    public ComentarioBean getById(Long id){

        List<ComentarioBean> listaComentarios;

        Query query = session.createQuery("from ComentarioBean comentario where comentario.id = :id");
        query.setParameter("id",id);
        listaComentarios = query.list();

        return listaComentarios.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<ComentarioBean> getAll(){

        List<ComentarioBean> listaComentarios;

        Query query = session.createQuery("from ComentarioBean");
        listaComentarios = query.list();

        return listaComentarios;
    }

    @SuppressWarnings("unchecked")
    public List<ComentarioBean> getAllByIdUsuario(Long idUsuario){

        List<ComentarioBean> listaComentarios;

        Query query = session.createQuery("from ComentarioBean comentario where comentario.idUsuario = :idUsuario");
        query.setParameter("idUsuario",idUsuario);
        listaComentarios = query.list();

        return listaComentarios;
    }

    @SuppressWarnings("unchecked")
    public List<ComentarioBean> getAllByIdMelom(Long idMelom){

        List<ComentarioBean> listaComentarios;

        Query query = session.createQuery("from ComentarioBean comentario where comentario.idMelom = :idMelom");
        query.setParameter("idMelom",idMelom);
        listaComentarios = query.list();

        return listaComentarios;
    }

}
