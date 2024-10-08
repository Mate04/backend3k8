package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.example.entities.Track;
import org.example.repository.context.DbContext;
import org.hibernate.HibernateException;

import java.util.List;

public class TrackRepository implements Repository<Track, Integer> {
    static final EntityManager manager = DbContext.getInstance().getManager();

    public TrackRepository(){
    }
    @Override
     public void save(Track entity) {
        try {
            manager.getTransaction().begin();
            manager.persist(entity);

        }catch (HibernateException e){
            manager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            manager.getTransaction().commit();
        }
    }

    @Override
    public Track findById(Integer id) {
        return manager.find(Track.class, id);
    }

    @Override
    public List<Track> findAll() {
        try {
            String jpql = String.format("SELECT t FROM %2 t ORDER BY t.id", Track.class.getSimpleName());
            Query query = manager.createQuery(jpql);
            return query.getResultList();
        }catch (HibernateException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(Track entity) {
        try {
            manager.getTransaction().begin();
            manager.merge(entity);
        }catch (HibernateException e){
            manager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }finally {
            manager.getTransaction().commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            manager.getTransaction().begin();
            Track entity = this.findById(id);
            manager.remove(entity);
            manager.flush();

        }catch (HibernateException e){
            manager.getTransaction().rollback();
        }finally {
            manager.getTransaction().commit();
        }
    }

    @Override
    public Track findByName(String name) {
        try {
            String jpql = "SELECT t FROM Track t WHERE t.title = :name";
            return manager.createQuery(jpql, Track.class)
            .setParameter("name", name)
            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
