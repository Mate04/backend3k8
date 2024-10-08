package org.example.service;

import org.example.entities.Estudiante;
import org.example.entities.Inasistencia;
import org.example.entities.Tipo;
import org.example.repository.InasistenciasRepo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InasistenciaService {
    private List<Inasistencia> inasistencias;
    private final InasistenciasRepo inasistenciasRepo = new InasistenciasRepo();

    public InasistenciaService() {
        this.inasistencias = inasistenciasRepo.findAll();
    }


    public Inasistencia cargarInasistencias(boolean justificada, String motivo, float cantidad, Estudiante estudiante, Tipo tipos) {
        Inasistencia inasistencia = new Inasistencia(justificada, motivo, cantidad, estudiante, tipos);
        inasistenciasRepo.save(inasistencia);
        return inasistencia;
    }
}
