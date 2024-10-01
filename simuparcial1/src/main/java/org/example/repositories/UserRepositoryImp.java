package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.User;
import org.example.repositories.context.DbContext;
import org.example.repositories.interfaces.Repository;
import org.hibernate.HibernateException;

import java.util.List;

public class UserRepositoryImp implements Repository<User, Long> {

    EntityManager manager;

    public UserRepositoryImp() {
        manager = DbContext.getInstance().getManager();
    }

    @Override
    public void save(User entity) {
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
    public User findById(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        try {
            String jpql = String.format("SELECT e FROM %s e", User.class);
            Query query = manager.createQuery(jpql);
            return query.getResultList();
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(User entity) {
        this.manager.getTransaction().begin();
        this.manager.merge(entity);
        this.manager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        this.manager.getTransaction().begin();
        User usuario = this.findById(id);
        this.manager.remove(usuario);
        this.manager.getTransaction().commit();
    }
}
