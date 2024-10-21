public class Idioma {
    
    private static int idiomaActual = 0;

    private static String[][] traducciones = {
        //Español (0)
        {
            "RECOMENDACIONES MÉDICAS", // 0
            "PÁGINAS CONFIABLES",      // 1
            "ASESORÍA VIRTUAL",        // 2
            "AGENDAR CITA",            // 3
            "RESEÑAS",                 // 4
            "NOMBRE DE LA PÁGINA",     // 5
            "IDIOMA",                  // 6
            "ATRÁS",                   // 7
            "NOMBRE",                  // 8
            "CALIFICACION",            // 9
            "GUARDAR RESEÑA",          // 10
            "VER RESEÑAS"              // 11
        },
        //Inglés (1)
        {
            "MEDICAL RECOMMENDATIONS", // 0
            "RELIABLE PAGES",          // 1
            "VIRTUAL ASSISTANCE",      // 2
            "SCHEDULE APPOINTMENT",    // 3
            "REVIEWS",                 // 4
            "PAGE NAME",               // 5
            "LANGUAGE",                // 6
            "BACK",                    // 7
            "NAME",                    // 8
            "SCORE",                   // 9
            "SAFE REVIEW",             // 10
            "SEE REVIEWS"              // 11
        }
    };

    //Texto De Los Objetos
    public static String getTexto(int clave) {
        return traducciones[idiomaActual][clave];
    }

    //Cambiar Idioma
    public static void cambiarIdioma(int nuevoIdioma) {
        if (nuevoIdioma == 0 || nuevoIdioma == 1) {
            idiomaActual = nuevoIdioma;
        }
    }

    
}

