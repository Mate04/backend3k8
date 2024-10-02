package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paises")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pais")
    private int idPais;

    @Column(nullable = false, length = 50)
    private String nombre;


    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public Pais() {}

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
