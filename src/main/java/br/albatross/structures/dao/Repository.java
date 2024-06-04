package br.albatross.structures.dao;

import java.util.List;
import java.util.Optional;

public interface Repository<T, K> {

    T persist(T entity);
    T merge(T entity);

    List<T> findAll();

    Optional<T> findById(K id);
    Optional<T> getReferenceById(K id);

    void remove(T entityReference);

}
