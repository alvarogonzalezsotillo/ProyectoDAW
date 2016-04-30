package app.model;

import app.beans.implementations.MelomBean;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

public class MelomDAO extends SessionFactoryImpl implements Serializable, DAO<MelomBean> {

    private static final long serialVersionUID = 1L;

    public MelomDAO() {

        super();
    }

    public void insert(MelomBean melomBean) {

        session.save(melomBean);

    }

    public void update(MelomBean melomBean) {

        session.update(melomBean);
    }

    public void deleteById(Long id) {
        MelomBean melomToDelete = session.load(MelomBean.class, id);
        session.delete(melomToDelete);
    }

    @SuppressWarnings("unchecked")
    public MelomBean getById(Long id) {

        List<MelomBean> listaMeloms;
        Query query = session.createQuery("from MelomBean meloms where meloms.id = :id");
        query.setParameter("id",id);
        listaMeloms = query.list();

        return listaMeloms.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<MelomBean> getAll() {

        List<MelomBean> listaMeloms;

        Query query = session.createQuery("from MelomBean");
        listaMeloms = query.list();

        return listaMeloms;
    }

    @SuppressWarnings("unchecked")
    public List<MelomBean> getAllByIdUsuario(Long idUsuario){

        List<MelomBean> listaMelomsFilterByUsuarioId;

        Query query = session.createQuery("from MelomBean meloms where meloms.idUsuario = :idUsuario");
        query.setParameter("idUsuario",idUsuario);
        listaMelomsFilterByUsuarioId = query.list();
        return listaMelomsFilterByUsuarioId;

    }
}
