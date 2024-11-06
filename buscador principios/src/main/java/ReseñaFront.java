import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReseñaFront extends JPanel {

    // Objetos
    private JLabel jcomp1;
    private JButton jcomp2;
    private JButton jcompGuardar;
    private JButton jcompVerReseñas; 
    private JTextField jcomp3;
    private JLabel jcomp4;
    private JTextField jcomp5;
    private Reseña reseña;

    public ReseñaFront(JFrame frame) {
       
        //Crear
        reseña = new Reseña();
        jcomp1 = new JLabel(Idioma.getTexto(8)); //"NOMBRE" o "NAME"
        jcomp2 = new JButton(Idioma.getTexto(7)); //"ATRAS" o "BACK"
        jcompGuardar = new JButton(Idioma.getTexto(10)); //"GUARDAR RESEÑA" o "SAFE REVIEW"
        jcompVerReseñas = new JButton(Idioma.getTexto(11)); //"VER RESEÑAS" o "SEE REVIEWS"
        jcomp3 = new JTextField(); //DATOS DE ENTRADA (NOMBRE)
        jcomp4 = new JLabel(Idioma.getTexto(9)); //"CALIFICACION" o "RATING"
        jcomp5 = new JTextField(); //DATOS DE ENTRADA (CALIFICACION)

        // Ajustar tamaño y establecer layout
        setPreferredSize(new Dimension(750, 531));
        setLayout(null);

        // Añadir componentes
        add(jcomp1);
        add(jcomp2);
        add(jcompGuardar);
        add(jcompVerReseñas);
        add(jcomp3);
        add(jcomp4);
        add(jcomp5);

        // Establecer bounds
        jcomp1.setBounds(155, 150, 100, 45);
        jcomp2.setBounds(5, 460, 100, 25);
        jcompGuardar.setBounds(240, 250, 150, 30);
        jcompVerReseñas.setBounds(400, 250, 150, 30); // Posición del nuevo botón "Ver Reseñas"
        jcomp3.setBounds(240, 162, 400, 25);
        jcomp4.setBounds(155, 180, 100, 45);
        jcomp5.setBounds(240, 192, 400, 25);

        // Acción para el botón "ATRÁS"
        jcomp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new FrontPrincipal(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        //Acción para el botón "GUARDAR RESEÑA"
        jcompGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = jcomp3.getText();
                int calificacion;
                try {
                    calificacion = Integer.parseInt(jcomp5.getText());
                    
                    // Validar que la calificación esté entre 1 y 5, FALTA POR TRADUCIR
                    if (calificacion < 1 || calificacion > 5) {
                        JOptionPane.showMessageDialog(frame, "La calificación debe ser un número entre 1 y 5", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    reseña.agregarReseña(nombre, calificacion);
                    JOptionPane.showMessageDialog(frame, "Reseña guardada correctamente");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Calificación debe ser un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Acción para el botón "VER RESEÑAS"
        jcompVerReseñas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la lista de reseñas y mostrarla
                StringBuilder reseñasTexto = new StringBuilder();
                for (Reseña reseña : reseña.obtenerReseñas()) {
                    reseñasTexto.append(reseña.toString()).append("\n");
                }

                // Mostrar las reseñas en un JOptionPane
                if (reseñasTexto.length() > 0) {
                    JOptionPane.showMessageDialog(frame, reseñasTexto.toString(), "Reseñas Guardadas", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "No hay reseñas guardadas", "Reseñas Guardadas", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

   
}