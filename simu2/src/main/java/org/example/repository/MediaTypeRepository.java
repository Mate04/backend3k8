package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entities.MediaType;
import org.example.repository.context.DbContext;
import org.hibernate.HibernateException;

import java.util.List;

public class MediaTypeRepository implements Repository<MediaType,Integer> {

    EntityManager em;

    public MediaTypeRepository() {
        em = DbContext.getInstance().getManager();
    }

    @Override
    public void save(MediaType entity) {
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
    public MediaType findById(Integer id) {
        return em.find(MediaType.class, id);
    }

    @Override
    public List<MediaType> findAll() {
        return List.of();
    }

    @Override
    public void update(MediaType entity) {

    }

    @Override
    public void delete(Integer id) {

    }
}
