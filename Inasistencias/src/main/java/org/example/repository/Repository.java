package org.example.repository;

import java.util.List;

public interface Repository <T,k>{
    void save(T entity);
    void delete(k id);
    void update(k id);
    T findById ( k id);
    T findByName (String name );
    List<T> findAll ();
}
