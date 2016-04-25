package app.model;

import app.beans.implementations.ComentarioBean;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

public class ComentarioDAO extends BaseDaoHibernate implements Serializable {

    private static final long serialVersionUID = 1L;

    public ComentarioDAO(){

        super();

    }

    public void insertComentario(ComentarioBean comentario){

        session = factory.openSession();
        transaction = session.beginTransaction();
        session.save(comentario);
        transaction.commit();

    }

    @SuppressWarnings("unchecked")
    public List<ComentarioBean> getAllComentarios(){

        List<ComentarioBean> listaComentarios;

        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from ComentarioBean");
        listaComentarios = query.list();
        transaction.commit();

        return listaComentarios;
    }

    @SuppressWarnings("unchecked")
    public List<ComentarioBean> getAllByIdUsuario(Long idUsuario){

        List<ComentarioBean> listaComentarios;

        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from ComentarioBean comentario where comentario.idUsuario = :idUsuario");
        query.setParameter("idUsuario",idUsuario);
        listaComentarios = query.list();
        transaction.commit();
        return listaComentarios;
    }

    @SuppressWarnings("unchecked")
    public List<ComentarioBean> getAllByIdTweet(Long idTweet){

        List<ComentarioBean> listaComentarios;

        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from ComentarioBean comentario where comentario.idTweet = :idTweet");
        query.setParameter("idTweet",idTweet);
        listaComentarios = query.list();
        transaction.commit();
        return listaComentarios;
    }

    @SuppressWarnings("unchecked")
    public ComentarioBean getComentarioyId(Long id){

        List<ComentarioBean> listaComentarios;

        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from ComentarioBean comentario where comentario.id = :id");
        query.setParameter("id",id);
        listaComentarios = query.list();
        transaction.commit();
        return listaComentarios.get(0);
    }

    public void deleteComentarioById(Long id){

        session = factory.openSession();
        transaction = session.beginTransaction();
        ComentarioBean comentarioToDelete = session.load(ComentarioBean.class, id);
        session.delete(comentarioToDelete);
        transaction.commit();
    }

    public void updateComentario(ComentarioBean comentarioToUpdate){

        session = factory.openSession();
        transaction = session.beginTransaction();
        session.update(comentarioToUpdate);
        transaction.commit();
    }

}
