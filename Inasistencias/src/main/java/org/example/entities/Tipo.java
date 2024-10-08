package org.example.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToMany(mappedBy = "tipos")
    private List<Inasistencia> inasistencias;
    public Integer contarTipoInasistencias() {
        return inasistencias.size();
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

    public Tipo(String nombre) {
        this.nombre = nombre;
    }
    public Tipo() {
    }

}
