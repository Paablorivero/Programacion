package com;

import java.sql.Date;

public class Alquiler {
    
    private int id;
    private int codCliente;
    private int codArticulo;
    private Date fechaAlquiler;
    private Date fechaDevolucion;

    int cont;
    
    public Alquiler( int codCliente, int codArticulo) {
        this.id = cont;
        cont++;
        this.codCliente = codCliente;
        this.codArticulo = codArticulo;
    }

    public int getId() {
        return id;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Alquiler [id=" + id + ", codCliente=" + codCliente + ", codArticulo=" + codArticulo + ", fechaAlquiler="
                + fechaAlquiler + ", fechaDevolucion=" + fechaDevolucion + "]";
    }
}
