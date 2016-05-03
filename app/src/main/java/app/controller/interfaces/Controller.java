package app.controller.interfaces;

public interface Controller{

    void initSessionForDao();

    void commitAndCloseSession();

    void closeSession();

    void initTransactionForDao();
    
}
