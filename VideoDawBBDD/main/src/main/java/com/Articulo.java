package com;

import java.util.Date;

public class Articulo{

    public int codigo;
    public String titulo;
    public String descripcion;
    public Date fechaRegistro;
    public Date fechaBaja;

    private static int contador = 0;

    public Articulo(String titulo){
        this.codigo = this.contador;
        this.contador++;
        this.titulo = titulo;
        this.fechaRegistro = new Date();
        this.fechaBaja = null;
    }

    public Articulo(int codigo, String titulo, String descipcion, Date fechaRegistro) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descipcion;
        this.fechaRegistro = fechaRegistro;
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

    @Override
    public String toString() {
        return "Articulo [codigo=" + codigo + ", titulo=" + titulo + ", fechaRegistro=" + 
        fechaRegistro + ", fechaBaja=" + fechaBaja + "]";
    }
}