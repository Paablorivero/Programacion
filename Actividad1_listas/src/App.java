import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        
        Producto producto1 = new Producto("zapatillas", 120);
        Producto producto2 = new Producto("camiseta", 50);
        Producto producto3 = new Producto("sudadera", 110);
        Producto producto4 = new Producto("abrigo", 150);
        Producto producto5 = new Producto("pantalones", 80);
        

        ArrayList<Producto> productos = new ArrayList<Producto>();

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        Iterator<Producto> itera = productos.iterator();

        Producto cadaProducto;

        while(itera.hasNext()){
            cadaProducto = itera.next();
            System.out.println(cadaProducto.mostrarInfo());
        }

        productos.remove(producto2);
        productos.remove(producto4);

        Producto producto6 = new Producto("gorra", 30);
        productos.add(2, producto6);

        Iterator<Producto> itera1 = productos.iterator();

        Producto cadaProducto1;

        System.out.println("\n");
        while(itera1.hasNext()){
            cadaProducto1 = itera1.next();
            System.out.println(cadaProducto1.mostrarInfo());
        }
    }
}
