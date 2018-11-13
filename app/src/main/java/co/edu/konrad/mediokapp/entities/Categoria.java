package co.edu.konrad.mediokapp.entities;


public class Categoria {
    private String nombre;
    private int imagen;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


    public Categoria(String nombre, int imagen, String descripcion) {

        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
}
