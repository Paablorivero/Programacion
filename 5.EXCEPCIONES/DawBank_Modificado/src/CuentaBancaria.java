import java.util.ArrayList;
import java.util.Iterator;

public class CuentaBancaria {
    //Atributos
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
        this.movimientos = new ArrayList<>();
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

    public String infoCliente(){
        String getCliente = String.format("\nDATOS DEL CLIENTE: " + this.cliente);
        return getCliente;
    }

    public boolean nuevoIngreso (Movimiento ing) throws CuentaExcepcion, AvisarHaciendaExcepcion{
        if (ing == null) {
            throw new CuentaExcepcion("El movimiento no puede ser nulo");
        }
        if(ing.getCantidad() <= 0){
            throw new CuentaExcepcion("NO SE PUEDE INGRESAR UNA CANTIDAD NEGATIVA O IGUAL A 0");
        }
        movimientos.add(ing);
        saldo += ing.getCantidad();

        if (ing.getCantidad() > 3000){
            throw new AvisarHaciendaExcepcion("ES NECESARIO NOTIFICAR A HACIENDA",
            this.cliente.getNombre(),
            this.iban,
            ing);//Lanzamos el aviso a hacienda
        }
            
        
        return true;
    }

    public boolean nuevoRetirada (Movimiento ret) throws CuentaExcepcion, AvisarHaciendaExcepcion{
        if (ret == null) {
            throw new CuentaExcepcion("El movimiento no puede ser nulo");
        }
        if (ret.getCantidad() <= 0) {
            throw new CuentaExcepcion("NO SE PUEDE RETIRAR UNA CANTIDAD NEGATIVA O IGUAL A 0");
        }
        if ((saldo - ret.getCantidad()) < -50) {
            throw new CuentaExcepcion("SALDO INSUFICIENTE, POR FAVOR REALIZA OTRA RETIRADA O INGRESE DINERO");
        }

        saldo -= ret.getCantidad();
        movimientos.add(ret);
        if (saldo > -50 && saldo < 0) {
            throw new CuentaExcepcion("EL SALDO ACTUAL ES NEGATIVO." + "\nSALDO ACTUAL: " + this.saldo);   
        }
        if (ret.getCantidad() > 3000){
            throw new AvisarHaciendaExcepcion("ES NECESARIO NOTIFICAR A HACIENDA",
            this.cliente.getNombre(),
            this.iban,
            ret);//Lanzamos el aviso a hacienda
        }
        
        return true;
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