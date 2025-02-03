public class Coche{

    String color;
    String marca;

    public Coche(String color, String marca){
        this.color = color;
        this.marca = marca;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getColor(){
        return color;
    }

    public String getMarca(){
        return marca;
    }

    public void mostrarDatos(){
        System.out.println("El coche de marca " + marca + " y color " + color);
    }
}