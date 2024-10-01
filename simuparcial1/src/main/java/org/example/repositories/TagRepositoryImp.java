package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.Tag;
import org.example.repositories.context.DbContext;
import org.example.repositories.interfaces.Repository;
import org.hibernate.HibernateException;

import java.util.List;

public class TagRepositoryImp implements Repository<Tag,Long> {

    EntityManager manager;

    public TagRepositoryImp() {
        manager = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Tag entity) {
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
    public Tag findById(Long id) {
        return manager.find(Tag.class, id);
    }

    @Override
    public List<Tag> findAll() {
        try {
            String jpql = String.format("SELECT e FROM %s e", Tag.class);
            Query query = manager.createQuery(jpql);
            return query.getResultList();
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Tag entity) {
        this.manager.getTransaction().begin();
        this.manager.merge(entity);
        this.manager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        this.manager.getTransaction().begin();
        Tag tag = this.findById(id);
        this.manager.remove(tag);
        this.manager.getTransaction().commit();
    }
}
