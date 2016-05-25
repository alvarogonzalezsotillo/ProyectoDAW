package app.servlet;

import app.model.MelomDAO;

import javax.servlet.http.HttpServletRequest;

public interface Servlet<T> {

    T initDao(HttpServletRequest request);

    void initSessionForDao(T t);

    void commitAndCloseSession(T t);

    void closeSession(T t);

    void initTransactionForDao(T t);
}
