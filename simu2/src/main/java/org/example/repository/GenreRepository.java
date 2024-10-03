package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entities.Genre;
import org.example.repository.context.DbContext;
import org.hibernate.HibernateException;

import java.util.List;

public class GenreRepository implements Repository<Genre, Integer> {
    EntityManager em;

    public GenreRepository() {
        em = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Genre entity) {
        try{
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
    public Genre findById(Integer id) {
        return em.find(Genre.class, id);
    }

    @Override
    public List<Genre> findAll() {
        return List.of();
    }

    @Override
    public void update(Genre entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Genre findByName(String name) {
        try {
            String jpql = "SELECT g FROM Genre g WHERE g.name = :name";
            return em.createQuery(jpql, Genre.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
