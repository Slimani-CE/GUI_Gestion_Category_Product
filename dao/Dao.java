package ma.enset.app.dao;

import java.util.*;

public interface Dao <T> {
    List<T> findAll();
    T findById(int id);
    T save(T o);
    boolean delete(T o);
    T update(T o);
}
