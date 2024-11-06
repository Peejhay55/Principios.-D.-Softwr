import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AsesoriaFront extends JPanel {

    // Objetos
    private JButton botonAtras;
    private JLabel etiquetaTitulo;
    private JTextArea areaChat; // Área de chat que muestra el historial de consultas y respuestas
    private JTextField campoConsulta; // Campo donde el usuario escribe su consulta
    private JButton botonEnviar; // Botón para enviar la consulta

    private Asesoria asesoria = new Asesoria(); // Instancia de la clase Asesoria

    public AsesoriaFront(JFrame frame) {

        // Crear componentes
        botonAtras = new JButton(Idioma.getTexto(7)); // "ATRÁS" o "BACK"
        etiquetaTitulo = new JLabel(Idioma.getTexto(2), SwingConstants.CENTER); 
        areaChat = new JTextArea(15, 30); // Área de chat con historial
        campoConsulta = new JTextField(25); // Campo de texto para la consulta
        botonEnviar = new JButton(Idioma.getTexto(18)); //"ENVIAR" o "SEND"

        // Ajustar tamaño y establecer layout
        setPreferredSize(new Dimension(750, 531));
        setLayout(null); // Layout absoluto para ubicar componentes en posiciones fijas

        // Configurar el título
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 24)); 
        etiquetaTitulo.setBounds(125, 10, 500, 30);

        // Configurar el área de chat
        areaChat.setEditable(false);
        areaChat.setLineWrap(true);
        areaChat.setWrapStyleWord(true);

        // Añadir scroll para el área de chat
        JScrollPane scrollChat = new JScrollPane(areaChat);
        scrollChat.setBounds(125, 60, 500, 300);
        scrollChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Configurar campo de consulta y botón de enviar
        campoConsulta.setBounds(125, 380, 400, 30);
        botonEnviar.setBounds(535, 380, 90, 30);

        // Configurar botón "ATRÁS" con posición fija
        botonAtras.setBounds(5, 460, 100, 25);

        // Añadir componentes al panel
        add(etiquetaTitulo);
        add(scrollChat);
        add(campoConsulta);
        add(botonEnviar);
        add(botonAtras);

        // Acción para el botón "ATRÁS"
        botonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new FrontPrincipal(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // Acción para el botón "Enviar"
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = campoConsulta.getText().trim();
                if (!consulta.isEmpty()) {
                    areaChat.append(Idioma.getTexto(19) + " " + consulta + "\n");
                    String respuesta = asesoria.procesarConsulta(consulta);
                    areaChat.append(Idioma.getTexto(20) + " " + respuesta + "\n\n");
                    campoConsulta.setText("");
                }
            }
        });
    }
}

