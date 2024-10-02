package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entities.Album;
import org.example.repository.context.DbContext;
import org.hibernate.HibernateException;

import java.util.List;

public class AlbumRepositry implements Repository<Album, Integer> {
    EntityManager em;

    public AlbumRepositry() {
        em = DbContext.getInstance().getManager();
    }
    @Override
    public void save(Album entity) {
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
    public Album findById(Integer id) {
        return em.find(Album.class, id);
    }

    @Override
    public List<Album> findAll() {
        return List.of();
    }

    @Override
    public void update(Album entity) {

    }

    @Override
    public void delete(Integer id) {

    }
}
