package com.decroly.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private static int contador = 0;

    //Atributos
    private int id;
    private String fecha;
    private String tipo;
    private double cantidad;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

    //Constructores
    public Movimiento(String tipo, double cantidad){
        this.id = this.contador;
        this.contador++;

        this.fecha = LocalDateTime.now().format(formatter);
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

    public String getInfo(){
        String getMovimiento = String.format("ID: %s, FECHA: %s, TIPO DE OPERACION: %s, CANTIDAD INGRESADA: %s EUROS \n",
         this.id, this.fecha, this.tipo, this.cantidad );
        return getMovimiento;
    }
}
