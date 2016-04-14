package app.model;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import app.beans.imp.UsuarioImp;

@ManagedBean(name = "UsuarioDao")
@ApplicationScoped
public class UsuarioDAO extends BaseDaoHibernate implements Serializable {

    private static final long serialVersionUID = 1L;

    public UsuarioDAO() {
        super();
    }

    public void insertUsuario(UsuarioImp usuario) {

        transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();

    }

}
