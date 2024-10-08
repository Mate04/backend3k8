package org.example.service;

import org.example.Main;
import org.example.entities.Tipo;
import org.example.repository.TiposRepo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TipoService {
    private List<Tipo> tipos;
    private final TiposRepo tiposRepo = new TiposRepo();

    public TipoService() {
        this.tipos = tiposRepo.findAll();

    }
    public Tipo cargarTipo(String name){
        Tipo res= tiposRepo.findByName(name);
        if ( res == null){
            res=new Tipo(name);
            tiposRepo.save(res);
        }
        return res;

    }


    public void InasistenciasArchivo() {
        // Usar una ruta relativa o absoluta adecuada
        File archivo = new File("inasistencias.txt"); // Esto creará el archivo en la carpeta del proyecto

        try {
            // Si el archivo no existe, lo creamos
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            // Usar try-with-resources para cerrar automáticamente los recursos
            try (FileWriter fw = new FileWriter(archivo);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                // Escribir en el archivo
                bw.write("Tipo Inasistencia, cantidad\n");
                for (Tipo tipo : tipos) {
                    bw.write(
                            tipo.getNombre() + "," + tipo.contarTipoInasistencias() + "\n");
                }

                System.out.println("Archivo creado y escrito correctamente.");

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
