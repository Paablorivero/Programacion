public class App {
    public static void main(String[] args) throws Exception {
        
        Astro [] Astros = new Astro[5];
         Astros[1] = new Astro(1000, 30000, 100000, 200, 2);

         System.out.println(Astros[1].mostrarInfo());

         Astros[2] = new Planeta(2000, 12031, 2132, 34, 3, 150000000, 432000, false);
         System.out.println(Astros[2].mostrarInfo());

         Astros[3] = new Satelite(321000, 123654, 50000, 24, 5, 20000, 10002330, "Messier 51");
         System.out.println(Astros[3].mostrarInfo());
    }
}
