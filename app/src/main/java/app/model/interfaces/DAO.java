package app.model.interfaces;

import java.util.List;

public interface DAO <T> {

    void insert(T t);
    void update(T t);
    void deleteById(Long id);
    T getById(Long id);
    List<T> getAll();


}
