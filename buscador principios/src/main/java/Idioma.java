public class Idioma {
    
    //ATRIBUTOS
    private static int idiomaActual = 0;

    private static String[][] traducciones = {
        //Español (0)
        {
            "RECOMENDACIONES MÉDICAS", //0
            "PÁGINAS CONFIABLES",      //1
            "ASESORÍA VIRTUAL",        //2
            "AGENDAR CITA",            //3
            "RESEÑAS",                 //4
            "NOMBRE DE LA PÁGINA",     //5
            "IDIOMA",                  //6
            "ATRÁS",                   //7
            "NOMBRE",                  //8
            "CALIFICACION",            //9
            "GUARDAR RESEÑA",          //10
            "VER RESEÑAS",             //11
            "<html>Es fundamental que antes de tomar cualquier decisión relacionada con tu salud, " +
            "consultes a un profesional médico certificado. Si encuentras información en Internet, " +
            "asegúrate de que provenga de fuentes confiables, como organizaciones médicas reconocidas y " +
            "profesionales del área. Nuestro software te ayudará a identificar estas fuentes " + 
            "y proporcionará asesoría personalizada si lo necesitas.<html>",  //12
            "FECHA",                   //13
            "HORA",                    //14
            "DETALLES",                //15
            "GUARDAR CITA",            //16
            "VER CITAS",               //17
            "ENVIAR",                  //18
            "USUARIO:",                 //19
            "ASESOR:",                  //20
            "Un asesor te respondera pronto." //21
        },
        //Inglés (1)
        {
            "MEDICAL RECOMMENDATIONS", //0
            "RELIABLE PAGES",          //1
            "VIRTUAL ASSISTANCE",      //2
            "SCHEDULE APPOINTMENT",    //3
            "REVIEWS",                 //4
            "PAGE NAME",               //5
            "LANGUAGE",                //6
            "BACK",                    //7
            "NAME",                    //8
            "RATING",                   //9
            "SAVE REVIEW",             //10
            "SEE REVIEWS",             //11
            "<html>Before making any health-related decisions, it is essential to consult with a certified medical professional. " +
            "If you find information on the Internet, ensure it comes from reliable sources, such as recognized medical organizations " +
            "and professionals in the field. Our software will help you identify these sources and provide personalized advice " + 
            "if you need it.<html>",   //12
            "DATE",                    //13
            "TIME",                    //14
            "DETAILS",                 //15
            "SAVE APPOINTMENT",        //16
            "SEE APPOINTMENT",         //17
            "SEND",                    //18
            "USER:",                    //19
            "ADVISOR:",                 //20
            "An advisor will respond to you soon." //21
        }
        
    };

    //METODOS
    //TEXTO OBJETOS
    public static String getTexto(int clave) {
        return traducciones[idiomaActual][clave];
    }

    //CAMBIAR IDIOMA
    public static void cambiarIdioma(int nuevoIdioma) {
        if (nuevoIdioma == 0 || nuevoIdioma == 1) {
            idiomaActual = nuevoIdioma;
        }
    }

    
}