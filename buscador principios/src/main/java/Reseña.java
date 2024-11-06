import java.util.ArrayList;

public class Reseña {

    //ATRIBUTOS
    private String nombre;
    private int calificacion;
    private ArrayList<Reseña> reseñas;

    //CONSTRUCTOR
    public Reseña(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    //METODOS
    public String getNombre() {
        return nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String toString() {
        return Idioma.getTexto(8) + ": " + nombre + ", " + Idioma.getTexto(9) + ": " + calificacion;
    }

    public Reseña() {
        reseñas = new ArrayList<>();
    }

    //AGREGAR RESEÑA
    public void agregarReseña(String nombre, int calificacion) {
        Reseña nuevaReseña = new Reseña(nombre, calificacion);
        reseñas.add(nuevaReseña);
    }

    //VER RESEÑA
    public ArrayList<Reseña> obtenerReseñas() {
        return reseñas;
    }
}