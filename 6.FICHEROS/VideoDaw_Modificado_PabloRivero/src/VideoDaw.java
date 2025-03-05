import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class VideoDaw {
    // ATRIBUTOS
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private List<Articulo> articulosRegistrados;
    private List<Cliente> clientesRegistrados;

    // CONSTRUCTORES
    public VideoDaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
        this.articulosRegistrados = new ArrayList<>();
        this.clientesRegistrados = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<Articulo> getArticulosRegistrados() {
        return articulosRegistrados;
    }

    public List<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    // MÉTODOS PARA GESTIÓN DE CLIENTES
    public boolean registrarCliente(Cliente cliente) throws ClienteExistenteException {
        // Verificar si el cliente ya está registrado
        for (Cliente c : clientesRegistrados) {
            if (c.getDni().equals(cliente.getDni())) {
            throw new ClienteExistenteException("El cliente con DNI " + cliente.getDni() + " ya está registrado.");
            }
        }
        
        clientesRegistrados.add(cliente);
        return true;
    }

    public void darBajaCliente(Cliente cliente) {
        // Buscamos el cliente en la lista
        for (int i = 0; i < clientesRegistrados.size(); i++) {
            if (clientesRegistrados.get(i).getDni().equals(cliente.getDni())) {
                // Damos de baja al cliente
                clientesRegistrados.get(i).setFechaBaja(LocalDate.now());
            }
        }
    }

    // MÉTODOS PARA GESTIÓN DE ARTÍCULOS
    public void registrarArticulo(Articulo articulo) {
        articulosRegistrados.add(articulo);
    }

    public void darBajaArticulo(int codigoArticulo) {
        for (int i = 0; i < articulosRegistrados.size(); i++) {
            if (articulosRegistrados.get(i).getCodigo() == codigoArticulo) {
                articulosRegistrados.get(i).darDeBaja();
            }
        }
    }

    // MÉTODOS DE ALQUILER Y DEVOLUCIÓN
    public void alquilar(Cliente cliente, Articulo articulo) throws ArticuloAlquiladoException {
        boolean isAlquilado = false;
        
        //Comrponamos si es pelicula o videojuego y si esta alquilado
        if (articulo instanceof Pelicula) {
            isAlquilado = ((Pelicula) articulo).isAlquilada();
        } else if (articulo instanceof Videojuego) {
            isAlquilado = ((Videojuego) articulo).isAlquilado();
        }
        
        if (isAlquilado == true) {
            throw new ArticuloAlquiladoException("El artículo ya está alquilado");
        }

        //Alquilamos el artículo
        LocalDateTime fechaAlquiler = LocalDateTime.now();
        
        if (articulo instanceof Pelicula) {
            ((Pelicula) articulo).setFechaAlquiler(fechaAlquiler);
            ((Pelicula) articulo).setAlquilada(true);
        } else if (articulo instanceof Videojuego) {
            ((Videojuego) articulo).setFechaAlquiler(fechaAlquiler);
            ((Videojuego) articulo).setAlquilado(true);
        }

        //Añadimos el artículo a la lista de alquilados del cliente
        cliente.addArticulo(articulo);
    }

    public void devolver(Cliente cliente, Articulo articulo) throws TiempoExcedidoException {
        LocalDateTime fechaAlquiler = null;
        
        //Comprobamos si es pelicula o videojuego, obtenemos la fecha de alquiler y lo devolvemos
        if (articulo instanceof Pelicula) {
            fechaAlquiler = ((Pelicula) articulo).getFechaAlquiler();
            ((Pelicula) articulo).setAlquilada(false);
        } else if (articulo instanceof Videojuego) {
            fechaAlquiler = ((Videojuego) articulo).getFechaAlquiler();
            ((Videojuego) articulo).setAlquilado(false);
        }

        //Verificamos que no se haya excedido el tiempo máximo de 48 horas
        if (fechaAlquiler != null) {
            long horasTranscurridas = ChronoUnit.HOURS.between(fechaAlquiler, LocalDateTime.now());
            
            if (horasTranscurridas > 48) {
                throw new TiempoExcedidoException("Se ha excedido el tiempo máximo de alquiler (48 horas)");
            }
        }

        //Removemod el artículo de la lista de alquilados del cliente
        cliente.elimArticulo(articulo);
    }

    // MÉTODOS DE VISUALIZACIÓN
    public String mostrarInfoVideoClub() {
        return String.format("INFO DEL VIDEOCLUB\n" +
                "CIF: %s\n" +
                "Dirección: %s\n" +
                "Fecha de alta: %s\n" +
                "Artículos registrados: %d\n" +
                "Clientes registrados: %d",
                this.cif, this.direccion, this.fechaAlta, 
                this.articulosRegistrados.size(), this.clientesRegistrados.size());
    }

    public String mostrarArticulosRegistrados() {
        String mostrarArticulosRegistrados = "";
        if (articulosRegistrados.isEmpty()) {
            return "No hay artículos registrados en el videoclub";
            
        }

       mostrarArticulosRegistrados = "ARTÍCULOS REGISTRADOS:";
        for (int i = 0; i < articulosRegistrados.size(); i++) {
            Articulo articulo = articulosRegistrados.get(i);
            mostrarArticulosRegistrados += i + ". " + articulo.toString();
            
            //Mostramos información adicional si es una película o videojuego
            if (articulo instanceof Pelicula) {
                Pelicula pelicula = (Pelicula) articulo;
                mostrarArticulosRegistrados +="   Género: " + pelicula.getGenero() + "\n" +
                "   Alquilada: " + (pelicula.isAlquilada() ? "Sí" : "No");
            } else if (articulo instanceof Videojuego) {
                Videojuego videojuego = (Videojuego) articulo;
                mostrarArticulosRegistrados += "   Género: " + videojuego.getGenero() + "\n" +
                "   Alquilado: " + (videojuego.isAlquilado() ? "Sí" : "No");
            }
        }
        return mostrarArticulosRegistrados;
    }

    public String mostrarArticulosDisponibles() {
        String articulosDisponibles = "";
        if (articulosRegistrados.isEmpty()) {
            articulosDisponibles = "No hay artículos registrados en el videoclub"; 
        }

        articulosDisponibles = "ARTÍCULOS DISPONIBLES PARA ALQUILAR:\n";
        boolean hayDisponibles = false;
        
        for (int i = 0; i < articulosRegistrados.size(); i++) {
            Articulo articulo = articulosRegistrados.get(i);
            boolean disponible = false;
            
            if (articulo instanceof Pelicula) {
                disponible = !((Pelicula) articulo).isAlquilada() ;
            } else if (articulo instanceof Videojuego) {
                disponible = !((Videojuego) articulo).isAlquilado() ;
            }
            
            if (disponible) {
                articulosDisponibles += i + ". " + articulo.toString();
                hayDisponibles = true;
            }
        }
        
        if (!hayDisponibles) {
            return "No hay artículos disponibles para alquilar";
        }
        return articulosDisponibles;
    }

    public String mostrarClientesRegistrados() {
        String mostrarclientesRegistrados = "";   
        if (clientesRegistrados.isEmpty()) {
            return "No hay clientes registrados en el videoclub";
        }

        mostrarclientesRegistrados = "CLIENTES REGISTRADOS:";
        for (int i = 0; i < clientesRegistrados.size(); i++) {
            Cliente cliente = clientesRegistrados.get(i);
            if (cliente.getFechaBaja() == null) {
                mostrarclientesRegistrados += i + ". " + cliente.toString();
            }
        }
        return mostrarclientesRegistrados;
    }

    // Clases de excepción personalizadas
    public class ClienteExistenteException extends Exception {
        public ClienteExistenteException(String mensaje) {
            super(mensaje);
        }
    }

    public class ArticuloAlquiladoException extends Exception {
        public ArticuloAlquiladoException(String mensaje) {
            super(mensaje);
        }
    }

    public class TiempoExcedidoException extends Exception {
        public TiempoExcedidoException(String mensaje) {
            super(mensaje);
        }
    }
}