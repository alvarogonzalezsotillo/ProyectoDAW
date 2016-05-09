package app.controller;

import app.controller.interfaces.Controller;
import app.utils.UtilViews;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "navigationController")
@ViewScoped
public class NavigationController implements Controller, Serializable{

    public void redirect(String route){

        UtilViews.redirect(route);

    }

    public void redirectWithInfoMessage(String route, String summary, String detail){

        UtilViews.redirectWithInfoMessage(route,summary,detail);

    }
    
    public void initSessionForDao() {
        
    }

    public void commitAndCloseSession() {

    }

    public void closeSession() {

    }

    public void initTransactionForDao() {

    }
}
