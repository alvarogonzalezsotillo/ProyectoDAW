package app.model;

import app.beans.MelomBean;
import app.beans.UsuarioBean;
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

    @SuppressWarnings("unchecked")
    public List<MelomBean> getAllMelomsByIdFollower(Long idFollower){

        List listUserWhoFollow;
        List<MelomBean> listMelomsFilterByidUsuario;


        Query query = session.createQuery("select follower.idUsuario from FollowerBean follower where follower.idFollower = :idFollower");
        query.setParameter("idFollower", idFollower);
        listUserWhoFollow = query.list();

        if(listUserWhoFollow.size() == 0){

            Query query2 = session.createQuery("from MelomBean where idUsuario = :idFollower order by fechaPublicacion desc");
            query2.setParameter("idFollower", idFollower);
            listMelomsFilterByidUsuario = query2.list();
        }

        else {

            Query query2 = session.createQuery("from MelomBean where idUsuario in (:listId, :idFollower) order by fechaPublicacion desc");
            query2.setParameterList("listId", listUserWhoFollow);
            query2.setParameter("idFollower", idFollower);
            listMelomsFilterByidUsuario = query2.list();
        }

        return listMelomsFilterByidUsuario;
    }

    @SuppressWarnings("unchecked")
    public List<String> getAllAutoresByIdFollower(Long idFollower){

        List<String> listAutores;

        Query subQuery = session.createQuery("select idUsuario from FollowerBean where idFollower = :idFollower");
        subQuery.setParameter("idFollower", idFollower);
        List subQueryResult = subQuery.list();

        Query query = session.createQuery("select usuarios.nombreDeUsuario from UsuarioBean usuarios where usuarios.id in (:subQueryResult)");
        query.setParameterList("subQueryResult", subQueryResult);
        listAutores = query.list();

        return listAutores;
    }
}
