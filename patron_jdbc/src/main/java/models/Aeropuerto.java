package models;

import java.util.List;
import java.util.ArrayList;

public class Aeropuerto {

    private Integer codigo;
    private String codigoInternacional;
    private String nombre;
    private List<Terminal> terminales;
    private DepositoEquipaje depositoTransito;

    public Aeropuerto( int codigo,String codigoInternacional, String nombre) {
        this.codigo = codigo;
        this.codigoInternacional = codigoInternacional;
        this.nombre = nombre;
        this.terminales = new ArrayList<>();
    }

    public Aeropuerto( String codigoInternacional, String nombre) {
        this.codigoInternacional = codigoInternacional;
        this.nombre = nombre;
        this.terminales = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoInternacional() {
        return codigoInternacional;
    }

    public void setCodigoInternacional(String codigoInternacional) {
        this.codigoInternacional = codigoInternacional;
    }

    public void setTerminales(List<Terminal> terminalesByAeropuerto) {
        terminales = terminalesByAeropuerto;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "codigo=" + codigo +
                ", codigoInternacional='" + codigoInternacional + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
