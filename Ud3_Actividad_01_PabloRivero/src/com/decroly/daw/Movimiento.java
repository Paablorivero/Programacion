package com.decroly.daw;

import java.time.LocalDateTime;

public class Movimiento {

    private static int contador = 0;

    //Atributos
    private int id;
    private String fecha;
    private String tipo;
    private double cantidad;

    //Constructores
    public Movimiento(String tipo, double cantidad){
        this.id = this.contador;
        this.contador++;

        this.fecha = LocalDateTime.now().toString();
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public static int getContador(){
        return contador;
    }

    public int getId(){
        return this.id;
    }

    public String getTipo(){
        return this.tipo;
    }
    
    public double getCantidad(){
        return this.cantidad;
    }
  
}
