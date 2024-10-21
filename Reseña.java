import java.util.ArrayList;

public class Reseña {

    public static class Datos {

        private String nombre;
        private int calificacion;

        public Datos(String nombre, int calificacion) {
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
            // Usar el Idioma.getTexto() para mostrar las traducciones adecuadas
            return Idioma.getTexto(8) + ": " + nombre + ", " + Idioma.getTexto(9) + ": " + calificacion;
        }

    }

    //Almacenar Reseña
    private ArrayList<Datos> reseñas;

    public Reseña() {
        reseñas = new ArrayList<>();
    }

    //Agregar Reseña
    public void agregarReseña(String nombre, int calificacion) {
        Datos nuevaReseña = new Datos(nombre, calificacion);
        reseñas.add(nuevaReseña);
    }

    //Método Ver Reseña
    public ArrayList<Datos> obtenerReseñas() {
        return reseñas;
    }
}