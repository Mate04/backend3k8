package org.example.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToMany(mappedBy = "estudiante")
    private List<Inasistencia> inasistencias;
    public float contarInasistencias() {
      float contador = 0;
      for (Inasistencia inasistencia : inasistencias) {
          contador+=inasistencia.getCantidad();
      }
      return contador;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inasistencia> getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(List<Inasistencia> inasistencias) {
        this.inasistencias = inasistencias;
    }

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }
    public Estudiante() {
    }

}
