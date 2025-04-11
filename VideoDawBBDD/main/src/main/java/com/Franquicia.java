package com;

import java.time.LocalDate;

public class Franquicia extends Exception{
    // ATRIBUTOS
    private int id;
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;

    // CONSTRUCTORES
    public Franquicia(String cif, String direccion) {
        this.id = id;
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
    }

    public String getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Franquicia{");
        sb.append("cif=").append(cif);
        sb.append(", direccion=").append(direccion);
        sb.append(", fechaAlta=").append(fechaAlta);
        sb.append('}');
        return sb.toString();
    }
}