package org.example.repository.context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbContext {
    private static DbContext instance = null;
    private EntityManager manager;

    private DbContext(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tracks");
        this.manager = emf.createEntityManager();
    }

    public static DbContext getInstance(){
        if (instance==null) {
            return instance = new DbContext();
        }
        return instance;
    }

    public EntityManager getManager(){
        return this.manager;
    }
}
