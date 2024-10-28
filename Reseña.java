import java.util.ArrayList;

public class Reseña {

    private String nombre;
    private int calificacion;

    public Reseña(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String toString() {
        return Idioma.getTexto(8) + ": " + nombre + ", " + Idioma.getTexto(9) + ": " + calificacion;
    }

    //Almacenar Reseña
    private ArrayList<Reseña> reseñas;

    public Reseña() {
        reseñas = new ArrayList<>();
    }

    //Agregar Reseña
    public void agregarReseña(String nombre, int calificacion) {
        Reseña nuevaReseña = new Reseña(nombre, calificacion);
        reseñas.add(nuevaReseña);
    }

    //Método Ver Reseña
    public ArrayList<Reseña> obtenerReseñas() {
        return reseñas;
    }
}
