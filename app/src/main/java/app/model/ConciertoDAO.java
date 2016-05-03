package app.model;

import app.beans.implementations.ConciertoBean;
import app.model.interfaces.DAO;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

public class ConciertoDAO extends SessionFactoryImpl implements Serializable, DAO<ConciertoBean> {


    public void insert(ConciertoBean conciertoBean) {

        session.save(conciertoBean);
    }

    public void update(ConciertoBean conciertoBean) {

        session.update(conciertoBean);
    }

    public void deleteById(Long id) {
        ConciertoBean conciertoToDelete = session.load(ConciertoBean.class, id);
        session.delete(conciertoToDelete);
    }

    @SuppressWarnings("unchecked")
    public ConciertoBean getById(Long id) {

        List<ConciertoBean> listaConciertos;
        Query query = session.createQuery("from ConciertoBean concierto where concierto.id = :id");
        query.setParameter("id",id);
        listaConciertos = query.list();
        return listaConciertos.get(0);
    }

    public List<ConciertoBean> getAll() {

        List<ConciertoBean> listaConciertos;
        Query query = session.createQuery("from ConciertoBean concierto");
        listaConciertos = query.list();
        return listaConciertos;
    }
}
