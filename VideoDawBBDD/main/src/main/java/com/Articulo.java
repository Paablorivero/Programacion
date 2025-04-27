package com;

import java.util.Date;

public class Articulo{

    private int codigo;
    private String titulo;
    private String descripcion;
    private Date fechaRegistro;
    private Date fechaBaja;
    private String tipo;
    private boolean isAlquilada; 

    private static int contador = 0;

    public Articulo(int codigo, String titulo, String descripcion, Date fechaRegistro, String tipo, boolean isAlquilada) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.tipo = tipo;
        this.isAlquilada = isAlquilada;
    }

    public Articulo(int codigo, String titulo, String descripcion, String tipo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    @Override
    public String toString() {
        return "Articulo [codigo=" + codigo + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaRegistro="
                + fechaRegistro + ", fechaBaja=" + fechaBaja + ", tipo=" + tipo + ", isAlquilada=" + isAlquilada + "]";
    }
}