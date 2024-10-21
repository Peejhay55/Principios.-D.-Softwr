import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FrontPrincipal extends JPanel {

    //Objetos
    private JTextArea jcomp1;
    private JTextArea jcomp2;
    private JTextArea jcomp3;
    private JButton jcomp4;
    private JButton jcomp5;
    private JButton jcomp6;
    private JButton jcomp7;
    private JTextField jcomp8;
    private JButton jcomp9;
    private JLabel jcomp10;
    private JButton jcomp11;

    public FrontPrincipal(JFrame frame) {

        //Crear 
        jcomp1 = new JTextArea(5, 5);
        jcomp2 = new JTextArea(5, 5);
        jcomp3 = new JTextArea(5, 5);
        jcomp4 = new JButton(Idioma.getTexto(0)); //"RECOMENDACIONES MÉDICAS" o "MEDICAL RECOMMENDATIONS"
        jcomp5 = new JButton(Idioma.getTexto(1)); //"PÁGINAS CONFIABLES" o "RELIABLE PAGES"
        jcomp6 = new JButton(Idioma.getTexto(2)); //"ASESORÍA VIRTUAL" o "VIRTUAL ASSISTANCE"
        jcomp7 = new JButton(Idioma.getTexto(3)); //"AGENDAR CITA" o "SCHEDULE APPOINTMENT"
        jcomp8 = new JTextField(5);
        jcomp9 = new JButton(Idioma.getTexto(4)); //"RESEÑAS" o "REVIEWS"
        jcomp10 = new JLabel(Idioma.getTexto(5), SwingConstants.CENTER); //"NOMBRE DE LA PÁGINA" o "PAGE NAME"
        jcomp11 = new JButton(Idioma.getTexto(6)); //"IDIOMA" o "LANGUAGE"

        //Ajustar tamaño y establecer layout
        setPreferredSize(new Dimension(777, 486));
        setLayout(null);

        //Añadir componentes
        add(jcomp10);
        add(jcomp11);
        add(jcomp1);
        add(jcomp2);
        add(jcomp3);
        add(jcomp4);
        add(jcomp5);
        add(jcomp6);
        add(jcomp7);
        add(jcomp8);
        add(jcomp9);

        //Establecer los bounds de los componentes
        int labelWidth = 300;
        jcomp10.setBounds((getWidth() - labelWidth) / 2, 5, labelWidth, 40);
        jcomp11.setBounds(5, 460, 100, 25);
        jcomp1.setBounds(10, 100, 250, 85);
        jcomp2.setBounds(265, 100, 250, 85);
        jcomp3.setBounds(520, 100, 250, 85);
        jcomp4.setBounds(25, 50, 210, 40);
        jcomp5.setBounds(245, 50, 170, 40);
        jcomp6.setBounds(425, 50, 165, 40);
        jcomp7.setBounds(605, 50, 150, 40);
        jcomp8.setBounds(165, 205, 435, 45);
        jcomp9.setBounds(670, 460, 100, 25);

        //Añadir acción al botón de idioma
        jcomp11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new IdiomaFront(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        //Añadir acción al botón de reseña
        jcomp9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new ReseñaFront(frame));
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    @Override
    public void doLayout() {
        super.doLayout();
        int labelWidth = 300;
        jcomp10.setBounds((getWidth() - labelWidth) / 2, 5, labelWidth, 40);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FrontPrincipal(frame));
        frame.pack();
        frame.setVisible(true);
    }
}