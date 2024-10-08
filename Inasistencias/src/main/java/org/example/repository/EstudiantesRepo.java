package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entities.Estudiante;
import org.example.entities.Tipo;

import java.util.List;

public class EstudiantesRepo implements Repository<Estudiante, Integer>{
    private EntityManager manager;

    public EstudiantesRepo() {
        manager = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Estudiante entity) {
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
    public Estudiante findById(Integer id) {
        return null;
    }

    @Override
    public Estudiante findByName(String nameParam) {
        try {
            return manager.createQuery("Select a from Estudiante a where a.nombre = :name", Estudiante.class)
                    .setParameter("name",nameParam)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Estudiante> findAll() {
        return manager.createQuery("select a from Estudiante a", Estudiante.class).getResultList();

    }
}
