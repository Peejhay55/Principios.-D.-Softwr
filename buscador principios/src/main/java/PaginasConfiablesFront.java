import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Desktop;
import java.net.URI;

public class PaginasConfiablesFront extends JPanel {
    
    // Objetos
    private JButton jcomp1;
    private JLabel jcomp2;

    public PaginasConfiablesFront(JFrame frame) {

        // Crear componentes
        jcomp1 = new JButton(Idioma.getTexto(7)); // "ATRÁS" o "BACK"
        jcomp2 = new JLabel(Idioma.getTexto(1), SwingConstants.CENTER); 

        // Ajustar tamaño y establecer layout
        setPreferredSize(new Dimension(750, 531));
        setLayout(null);

        // Cambiar el tamaño de la fuente
        jcomp2.setFont(new Font("Arial", Font.BOLD, 24)); 

        // Añadir etiquetas para los enlaces
        JLabel link1 = new JLabel("<html><a href=''>https://www.who.int</a></html>");
        JLabel link2 = new JLabel("<html><a href=''>https://medlineplus.gov</a></html>");
        JLabel link3 = new JLabel("<html><a href=''>https://www.cdc.gov</a></html>");
        JLabel link4 = new JLabel("<html><a href=''>https://www.nih.gov</a></html>");

        // Ajustar el color y la fuente de los enlaces
        link1.setForeground(Color.BLUE);
        link1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link2.setForeground(Color.BLUE);
        link2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link3.setForeground(Color.BLUE);
        link3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link4.setForeground(Color.BLUE);
        link4.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Aumentar el tamaño de la fuente de los enlaces
        Font linkFont = new Font("Arial", Font.PLAIN, 18);
        link1.setFont(linkFont);
        link2.setFont(linkFont);
        link3.setFont(linkFont);
        link4.setFont(linkFont);

        // Añadir acción a los enlaces
        link1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebpage("https://www.who.int");
            }
        });
        link2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebpage("https://medlineplus.gov");
            }
        });
        link3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebpage("https://www.cdc.gov");
            }
        });
        link4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebpage("https://www.nih.gov");
            }
        });

        // Establecer bounds y añadir los enlaces
        jcomp1.setBounds(5, 460, 100, 25);
        jcomp2.setBounds(125, 10, 500, 30); 
        int linkWidth = 300; // Ancho para centrar los enlaces
        int centerX = (750 - linkWidth) / 2; // Cálculo para centrar horizontalmente
        int linkHeight = 30; // Altura de los enlaces

        link1.setBounds(centerX, 100, linkWidth, linkHeight);
        link2.setBounds(centerX, 140, linkWidth, linkHeight);
        link3.setBounds(centerX, 180, linkWidth, linkHeight);
        link4.setBounds(centerX, 220, linkWidth, linkHeight);

        add(jcomp1);
        add(jcomp2);
        add(link1);
        add(link2);
        add(link3);
        add(link4);

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

    private void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
