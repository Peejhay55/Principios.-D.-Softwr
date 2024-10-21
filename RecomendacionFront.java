import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class RecomendacionFront extends JPanel {
    
    // Objetos
    private JButton jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;

    public RecomendacionFront(JFrame frame) {

        //Crear 
        jcomp1 = new JButton(Idioma.getTexto(7)); // "ATRÁS" o "BACK"
        jcomp2 = new JLabel(Idioma.getTexto(0), SwingConstants.CENTER); 

        //FALTA POR TRADUCIR
        jcomp3 = new JLabel("<html>Es fundamental que antes de tomar cualquier decisión relacionada con tu salud, "
                + "consultes a un profesional médico certificado. Si encuentras información en Internet, asegúrate "
                + "de que provenga de fuentes confiables, como organizaciones médicas reconocidas y profesionales del "
                + "área. Nuestro software te ayudará a identificar estas fuentes y proporcionará asesoría personalizada "
                + "si lo necesitas.</html>");

        //Ajustar tamaño y establecer layout
        setPreferredSize(new Dimension(750, 531));
        setLayout(null);

        //Cambiar el tamaño de la fuente
        jcomp2.setFont(new Font("Arial", Font.BOLD, 24)); 
        jcomp3.setFont(new Font("Arial", Font.PLAIN, 16)); 

        // Añadir borde al texto explicativo
        Border borde = BorderFactory.createLineBorder(Color.BLACK);
        jcomp3.setBorder(borde);

        // Añadir componentes
        add(jcomp1);
        add(jcomp2);
        add(jcomp3);

        // Establecer bounds
        jcomp1.setBounds(5, 460, 100, 25);
        jcomp2.setBounds(125, 10, 500, 30); 
        jcomp3.setBounds(10, 50, 730, 120); 

        // Acción para el botón "ATRÁS"
        jcomp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new FrontPrincipal(frame));
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(Idioma.getTexto(0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RecomendacionFront(frame));
        frame.pack();
        frame.setVisible(true);
    }
}