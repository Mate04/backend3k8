package org.example.service;

import org.example.entities.Estudiante;

import org.example.repository.EstudiantesRepo;

import java.util.ArrayList;
import java.util.List;

public class EstudianteService {
    private List<Estudiante> estudiantes;
    private final EstudiantesRepo estudianteRepo = new EstudiantesRepo();

    public EstudianteService() {
        this.estudiantes = estudianteRepo.findAll();
    }
    public void mostrarInasistenciasAlumnos(){
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.getNombre()+":"+estudiante.contarInasistencias());
        }
    }
    public Estudiante cargarEstudiante(String nombre){
        Estudiante estudiante = estudianteRepo.findByName(nombre);
        if (estudiante==null){
            estudiante = new Estudiante(nombre);
            estudianteRepo.save(estudiante);
        }
        return estudiante;
    }
}
