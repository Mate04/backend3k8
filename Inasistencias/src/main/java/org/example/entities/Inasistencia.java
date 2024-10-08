package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "inasistencias")
public class Inasistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean justificada;
    private String motivo;
    private float cantidad;
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isJustificada() {
        return justificada;
    }

    public void setJustificada(boolean justificada) {
        this.justificada = justificada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }


    public Inasistencia(){};

    public Inasistencia(boolean justificada, String motivo, float cantidad, Estudiante estudiante, Tipo tipos) {
        this.justificada = justificada;
        this.motivo = motivo;
        this.cantidad = cantidad;
        this.estudiante = estudiante;
        this.tipos = tipos;
    }
}
