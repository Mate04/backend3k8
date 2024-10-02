package ar.edu.utn.frc.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    // Relación muchos a uno con Pais
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    // Constructores, getters y setters

    public Autor(String nombre, String apellido, Pais pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
    }

    public Autor() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pais=" + pais.toString() +
                '}';
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
