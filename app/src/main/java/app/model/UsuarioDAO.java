package app.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Query;

import app.beans.imp.UsuarioImp;

@ManagedBean(name = "UsuarioDao")
@ApplicationScoped
public class UsuarioDAO extends BaseDaoHibernate implements Serializable {

    private static final long serialVersionUID = 1L;

    public UsuarioDAO() {
        super();
    }

    public void insertUsuario(UsuarioImp usuario) {

        session = factory.openSession();
        transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
        session.close();

    }
    
    @SuppressWarnings("unchecked")
    public List<UsuarioImp> getAll(){
        
        List<UsuarioImp> listUsuarios;
        
        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from UsuarioImp");
        listUsuarios = query.list();
        transaction.commit();
        return listUsuarios;
    }

}
