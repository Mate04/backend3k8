package org.example;

import org.example.entities.Estudiante;
import org.example.entities.Inasistencia;
import org.example.entities.Tipo;
import org.example.service.EstudianteService;
import org.example.service.InasistenciaService;
import org.example.service.TipoService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EstudianteService estudianteService = new EstudianteService();
        estudianteService.mostrarInasistenciasAlumnos();
        TipoService tipoService = new TipoService();
        tipoService.InasistenciasArchivo();
    }



    public static void cargarDatos(){
        try {
            TipoService tipoService = new TipoService();
            EstudianteService estudianteService = new EstudianteService();
            InasistenciaService inasistenciaService = new InasistenciaService();
            InputStream is = Main.class.getResource("/inasistencias.csv").openStream();
            Scanner scanner = new Scanner(is);
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] campos = line.split(",");
                Tipo tipo= tipoService.cargarTipo(campos[1]);
                Estudiante estudiante= estudianteService.cargarEstudiante(campos[0]);
                boolean justifica = Boolean.parseBoolean(campos[2]);
                float cantidad = Float.parseFloat(campos[3]);
                Inasistencia inasistencia= inasistenciaService.cargarInasistencias(justifica , "as",cantidad, estudiante, tipo);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}