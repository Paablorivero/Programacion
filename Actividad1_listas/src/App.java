import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {

        //Ejercicio con arrayList
        
        Producto producto1 = new Producto("zapatillas", 120);
        Producto producto2 = new Producto("camiseta", 50);
        Producto producto3 = new Producto("sudadera", 110);
        Producto producto4 = new Producto("abrigo", 150);
        Producto producto5 = new Producto("bufanda", 80);
        

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

        Collections.sort(productos, (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));

        Iterator<Producto> itera2 = productos.iterator();
        System.out.println("\nProductos ordenados alfabéticamente:");
        while (itera2.hasNext()) {
            Producto cadaProducto2 = itera2.next();
            System.out.println(cadaProducto2.mostrarInfo());
        }

        productos.clear();

        //Ejercicio con linkedList

        System.out.println("Ejecicio repetido con linkedlist:");

        LinkedList<Producto> productos1 = new LinkedList<>();

        productos1.add(producto1);
        productos1.add(producto2);
        productos1.add(producto3);
        productos1.add(producto4);
        productos1.add(producto5);

        System.out.println("\n" + "Productos en la linkedlist: ");
        Iterator <Producto> itera3 = productos1.iterator();
        Producto cadaProducto2;
        while (itera3.hasNext()){
            cadaProducto2 = itera3.next();
            System.out.println(cadaProducto2.mostrarInfo());
        }

        productos1.remove(producto2);
        productos1.remove(producto4);


        productos1.add(2, producto6);

        System.out.println("\n" + "Productos en la linkedlist: ");
        Iterator <Producto> itera4 = productos1.iterator();
        Producto cadaProducto4;
        while (itera4.hasNext()){
            cadaProducto4 = itera4.next();
            System.out.println(cadaProducto4.mostrarInfo());
        }

        productos1.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        System.out.println("\n" + "Productos ordenados alfabéticamente en la linkedlist: ");
        Iterator <Producto> itera5 = productos1.iterator();
        while (itera5.hasNext()){
            Producto cadaProducto5 = itera5.next();
            System.out.println(cadaProducto5.mostrarInfo());
        }
        
        productos1.clear();
    }
}
