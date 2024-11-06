public class AgendarCita {

    //Atributos
    private String fecha;
    private String hora;
    private String detalle;

    //Constructor
    public AgendarCita(String fecha, String hora, String detalle) {
        this.fecha = fecha;
        this.hora = hora;
        this.detalle = detalle;
    }

    //Metodo
    public String toString() {
        return "Fecha: " + fecha + ", Hora: " + hora + ", Detalle: " + detalle;
    }

}

