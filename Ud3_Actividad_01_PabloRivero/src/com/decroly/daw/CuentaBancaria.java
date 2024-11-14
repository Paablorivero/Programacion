package com.decroly.daw;

public class CuentaBancaria {
    //Atributos
    private String iban;
    private String titular;
    private double saldo;

    private Movimiento [] movimientos;
    private int nMovimientos;

    public CuentaBancaria(String iban, String titular, double saldo){
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
        this.nMovimientos = 0;
    }

    public String iban(){
        return this.iban;
    }

    public String titular(){
        return this.titular;
    }

    public double saldo(){
        return this.saldo;
    }

    public String infoCuenta(){
        String info = String.format("TU CUENTA ES: " + "\nIBAN - %s, \nTITULAR DE LA CUENTA: %s, \nTU SALDO: %s", 
        this.iban, this.titular, this.saldo);
        return info;
    }

    public String infoIban(){
        String getIban = String.format("TU IBAN ES: " + this.iban);
        return getIban;
    }

    public boolean nuevoIngreso (Movimiento ing){
        boolean isAdd = false;
        if (ing != null){
            this.movimientos [nMovimientos] = ing;
            this.nMovimientos++;
            isAdd = true;
        } 
        return isAdd;
    }
}
