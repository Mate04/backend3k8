package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.example.entities.Composer;
import org.example.repository.context.DbContext;
import org.hibernate.HibernateException;

import java.util.List;

public class ComposerRepository implements Repository<Composer, Integer> {
    EntityManager em;

    public ComposerRepository() {
        em = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Composer entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
        }catch (HibernateException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }finally {
            em.getTransaction().commit();
        }
    }

    @Override
    public Composer findById(Integer id) {
        return em.find(Composer.class, id);
    }

    @Override
    public List<Composer> findAll() {
        return List.of();
    }

    @Override
    public void update(Composer entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Composer findByName(String name) {
        try {
            String jpql = "select c from Composer c where c.name = :name";
            return em.createQuery(jpql,Composer.class)
                    .setParameter("name",name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
