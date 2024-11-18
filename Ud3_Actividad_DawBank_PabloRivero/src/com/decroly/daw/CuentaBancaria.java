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
        this.movimientos = new Movimiento[100];
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
        String info = String.format("TU CUENTA ES: " + "\nIBAN - %s \nTITULAR DE LA CUENTA: %s \nTU SALDO: %s", 
        this.iban, this.titular, this.saldo);
        return info;
    }

    public String infoIban(){
        String getIban = String.format("\nTU IBAN ES: " + this.iban);
        return getIban;
    }

    public String infoTitular(){
        String getTitular = String.format("\nNOMBRE DEL TITULAR: " + this.titular);
        return getTitular;
    }

    public String infoSaldo(){
        String getSaldo = String.format("\nSALDO ACTUAL: " + this.saldo);
        return getSaldo;
    }

    public boolean nuevoIngreso (Movimiento ing){
        boolean isAdd = false;
        if (ing != null){
            this.movimientos [nMovimientos] = ing;
            this.nMovimientos++;
            saldo = ing.getCantidad() + saldo;
            isAdd = true;
        } 
        return isAdd;
    }

    public boolean nuevoRetirada (Movimiento ret){
        boolean isAdd = false;
        if (ret != null){
            if ((saldo - ret.getCantidad()) < -50) {
                System.out.println("SALDO INSUFICIENTE, POR FAVOR REALIZA OTRA RETIRADA O INGRESE DINERO" +
                "\nSALDO ACTUAL: " + this.saldo);
            }
            else if((saldo - ret.getCantidad()) >-50){
                saldo = saldo - ret.getCantidad();
                if (saldo > -50 && saldo < 0) {
                System.out.println("EL SALDO ACTUAL ES NEGATIVO." + "\nSALDO ACTUAL: " + this.saldo);   
                }
                this.movimientos [nMovimientos] = ret;
                this.nMovimientos++;
                isAdd = true;
            }
        }
        return isAdd;
    }

    public String infoMovimiento (){
        String infoMovimientos = "";
        for(int i = 0; i < nMovimientos; i++){
            infoMovimientos += movimientos [i].getInfo();
        }
        return infoMovimientos;
    }
}
