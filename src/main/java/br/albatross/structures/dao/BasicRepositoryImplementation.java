package br.albatross.structures.dao;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BasicRepositoryImplementation<T, K> implements Repository<T, K> {

    private EntityManager entityManager;

    private Class<T> entityClazz;

    public BasicRepositoryImplementation(EntityManager entityManager, Class<T> entityClazz) {
        this.entityManager = entityManager;
        this.entityClazz = entityClazz;

    }

    @Override
    public T persist(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T merge(T entity) {

        return entityManager.merge(entity);

    }

    @Override
    public List<T> findAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery  = criteriaBuilder.createQuery(entityClazz);
        criteriaQuery.from(entityClazz);

        return entityManager
                .createQuery(criteriaQuery)
                .getResultList();

    }

    @Override
    public Optional<T> findById(K id) {

        return Optional.ofNullable(entityManager.find(entityClazz, id));

    }

    @Override
    public Optional<T> getReferenceById(K id) {

        return Optional.ofNullable(entityManager.getReference(entityClazz, id));

    }

    @Override
    public void remove(T entityReference) {

        entityManager.remove(entityReference);

    }

}
