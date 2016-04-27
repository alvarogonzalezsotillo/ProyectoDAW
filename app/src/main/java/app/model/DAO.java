package app.model;

public interface DAO <T extends SessionFactoryImpl> {

    void insert(T t);
    void update(T t);
    void deleteById(Long id);


}
