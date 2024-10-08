package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entities.Inasistencia;

import java.util.List;

public class InasistenciasRepo implements Repository <Inasistencia ,Integer> {
    private EntityManager manager;
    public InasistenciasRepo(){
        manager = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Inasistencia entity) {
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
    public Inasistencia findById(Integer id) {
        return null;
    }

    @Override
    public Inasistencia findByName(String name) {
        return null;
    }

    @Override
    public List<Inasistencia> findAll() {
        return manager.createQuery("select a from Inasistencia a",Inasistencia.class).getResultList();
    }


}
