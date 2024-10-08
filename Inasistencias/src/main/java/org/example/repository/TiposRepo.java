package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entities.Tipo;

import java.util.List;

public class TiposRepo implements Repository<Tipo , Integer>{
    private EntityManager manager;
    public TiposRepo(){
        manager= DbContext.getInstance().getManager();
    }

    @Override
    public void save(Tipo entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public Tipo findById(Integer id) {
        return null;
    }

    @Override
    public Tipo findByName(String name) {
        try {
            return manager.createQuery("Select a from Tipo a where a.nombre = :name",Tipo.class).setParameter("name",name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Tipo> findAll() {
        return manager.createQuery("Select a from Tipo a",Tipo.class).getResultList();
    }
}
