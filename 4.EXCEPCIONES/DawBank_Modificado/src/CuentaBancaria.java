import java.util.ArrayList;
import java.util.Iterator;

public class CuentaBancaria {
    //ATRIBUTOS
    private Cliente cliente;
    private String iban;
    private double saldo;
    
    private ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
    Iterator<Movimiento> itera = movimientos.iterator();
    Movimiento cadaMovimiento;

   //CONSTRUCTOR
    public CuentaBancaria(Cliente cliente, String iban, double saldo) {
        this.cliente = cliente;
        this.iban = iban;
        this.saldo = saldo;
    }

    //GETTERS Y SETTERS
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //INFO ATRIBUTOS Y CUENTA   
    @Override
    public String toString() {
        return "CuentaBancaria [cliente=" + cliente + ", iban=" + iban + ", saldo=" + saldo + "]";
    }

    public String infoIban(){
        String getIban = String.format("\nTU IBAN ES: " + this.iban);
        return getIban;
    }

    public String infoSaldo(){
        String getSaldo = String.format("\nSALDO ACTUAL: " + this.saldo);
        return getSaldo;
    }

    //METODOS MOVIMIENTOS
    public boolean nuevoIngreso (Movimiento ing){
        boolean isAdd = false;
        if (ing != null){
            movimientos.add(ing);
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
                movimientos.add(ret);
                isAdd = true;
            }
        }
        return isAdd;
    }

    public String infoMovimiento (){
        String InfoMovimiento = "";
        while(itera.hasNext()){
            cadaMovimiento = itera.next();
            InfoMovimiento = cadaMovimiento.toString();
        }
        return InfoMovimiento;
    }
}