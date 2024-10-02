package ar.edu.utn.frc.backend;


import ar.edu.utn.frc.backend.entities.Autor;
import ar.edu.utn.frc.backend.entities.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.nio.channels.Pipe;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("academico");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pais autor = em.find(Pais.class, 1);
        System.out.println(autor.getAutores());
        em.getTransaction().commit();
        em.close();
    }
}