import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IdiomaFront extends JPanel {
    private JButton jcomp1;
    private JButton jcomp2;
    private JButton jcomp3;

    public IdiomaFront(JFrame frame) {
        //Construct components
        jcomp1 = new JButton("ESPAÑOL");
        jcomp2 = new JButton(Idioma.getTexto(7)); //"ATRÁS" o "BACK"
        jcomp3 = new JButton("ENGLISH");

        //Ajustar tamaño y establecer layout
        setPreferredSize(new Dimension(750, 531));
        setLayout(null);

        //Añadir componentes
        add(jcomp1);
        add(jcomp2);
        add(jcomp3);

        //Establecer bounds
        jcomp1.setBounds(270, 185, 200, 50);
        jcomp2.setBounds(5, 460, 100, 25);
        jcomp3.setBounds(270, 260, 200, 50);

        //Acción para el botón "ESPAÑOL"
        jcomp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Idioma.cambiarIdioma(0); // Cambiar el idioma a español (0)
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new FrontPrincipal(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        //Acción para el botón "ENGLISH"
        jcomp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Idioma.cambiarIdioma(1); // Cambiar el idioma a inglés (1)
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new FrontPrincipal(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        //Acción para el botón "ATRÁS"
        jcomp2.addActionListener(new ActionListener() {
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
        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new IdiomaFront(frame));
        frame.pack();
        frame.setVisible(true);
    }
}