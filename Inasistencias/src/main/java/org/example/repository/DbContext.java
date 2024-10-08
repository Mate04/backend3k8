package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

public class DbContext {
    private static DbContext instance=null;
    private EntityManager manager;
    private DbContext(){
        var rfm= Persistence.createEntityManagerFactory("Insaistencias");
        manager=rfm.createEntityManager();
    }

    public static DbContext getInstance() {
        if (instance==null){
            instance = new DbContext();
        }
        return instance;
    }

    public EntityManager getManager() {
        return manager;
    }
}
