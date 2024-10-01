package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.User;
import org.example.repositories.context.DbContext;
import org.example.entities.Repository;

import org.hibernate.HibernateException;

import java.util.List;

public class RepositoryRepositoryImp implements org.example.repositories.interfaces.Repository<Repository, Long> {
    EntityManager manager;

    public RepositoryRepositoryImp() {
        manager = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Repository entity) {
        try {
            this.manager.getTransaction().begin();
            this.manager.persist(entity);
            this.manager.getTransaction().commit();
        } catch (HibernateException ex) {
            this.manager.getTransaction().rollback();
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Repository findById(Long id) {
        return manager.find(Repository.class, id);
    }

    @Override
    public List<Repository> findAll() {
        try {
            String jpql = String.format("SELECT e FROM %s e", Repository.class);
            Query query = manager.createQuery(jpql);
            return query.getResultList();
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Repository entity) {
        this.manager.getTransaction().begin();
        this.manager.merge(entity);
        this.manager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        this.manager.getTransaction().begin();
        Repository repository = this.findById(id);
        this.manager.remove(repository);
        this.manager.getTransaction().commit();
    }
}
