package repository;

import java.util.List;
//T es el objeto que va a devolver
//K seria la pk que buscaria
public interface Repository <T, K>{
    void add(T model);
    //aca buscamos el tipo generico que me va devolver
    //un valor de T
    T findById(K id);
    List<T> findAll();
}
