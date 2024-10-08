package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
        return em.createQuery("select a from Album a", Album.class).getResultList();
    }

    @Override
    public void update(Album entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        em.getTransaction().begin();
        Album entity = findById(id);
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public Album findByName(String title) {
        // Cambia 'albums' por el nombre de la entidad 'Album' y usa un alias más coherente.
        try {
            String jpql = "SELECT a FROM Album a WHERE a.title = :title";
            return em.createQuery(jpql, Album.class)
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
