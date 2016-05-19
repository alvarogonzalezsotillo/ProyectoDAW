package app.model;

import app.beans.MelomBean;
import app.model.interfaces.DAO;
import org.hibernate.Query;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@ManagedBean(name = "melomDao")
@ApplicationScoped
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
    public List<MelomBean> getAllByIdUsuario(Collection<Long> listaIdUsuario){

        List<MelomBean> listaMelomsFilterByUsuarioId;

        Query query = session.createQuery("from MelomBean meloms where meloms.idUsuario in (:listaIdUsuario) order by fechaPublicacion");
        query.setParameterList("listaIdUsuario",listaIdUsuario);
        listaMelomsFilterByUsuarioId = query.list();
        return listaMelomsFilterByUsuarioId;

    }

    public List<MelomBean> getAllMelomsByFollower(Long idFollower){

        List listUserWhoFollow;
        List<MelomBean> listMelomsFilterByidUsuario;

        Query query = session.createQuery("select follower.idUsuario from FollowerBean follower where follower.idFollower = :idFollower");
        query.setParameter("idFollower", idFollower);
        listUserWhoFollow = query.list();

        Query query2 = session.createQuery("from MelomBean where idUsuario in :listId");
        query2.setParameterList("listId",listUserWhoFollow);
        listMelomsFilterByidUsuario = query2.list();

        return listMelomsFilterByidUsuario;


    }
}
