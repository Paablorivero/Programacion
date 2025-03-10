import java.io.Serializable;

public class Libro implements Serializable {

    private  static final long serialVersionUID = 1L;

    private String isbn;
    private String titulo;
    private String Autor;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        Autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + this.isbn + ", titulo=" + this.titulo + ", Autor=" + this.Autor + "]";
    }

    public Libro readObject() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readObject'");
    }
}