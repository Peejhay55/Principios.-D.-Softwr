import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AgendarCitaFront extends JPanel {

    // Objetos
    private JButton jcomp1; // Botón Atrás
    private JLabel jcomp2; // Etiqueta del título
    private JLabel labelFecha, labelHora, labelDetalle; // Etiquetas para los campos
    private JTextField campoFecha, campoHora, campoDetalle; // Campos para la cita
    private JButton btnGuardar, btnVerCitas; // Botones de guardar y ver citas
    private static ArrayList<AgendarCita> citas = new ArrayList<>(); // Lista de citas

    public AgendarCitaFront(JFrame frame) {
        // Crear componentes
        jcomp1 = new JButton(Idioma.getTexto(7)); // "ATRÁS" o "BACK"
        jcomp2 = new JLabel(Idioma.getTexto(3), SwingConstants.CENTER); // "AGENDAR CITA"
        labelFecha = new JLabel(Idioma.getTexto(13)); //"FECHA" o "DATE"
        labelHora = new JLabel(Idioma.getTexto(14)); //"HORA" o "TIME"
        labelDetalle = new JLabel(Idioma.getTexto(15)); //"DETALLES" o "DETAILS"
        campoFecha = new JTextField(20); // Campo para la fecha
        campoHora = new JTextField(20); // Campo para la hora
        campoDetalle = new JTextField(20); // Campo para detalles
        btnGuardar = new JButton(Idioma.getTexto(16)); //"GUARDAR CITA" o "SAVE APPOINTMENT"
        btnVerCitas = new JButton(Idioma.getTexto(17)); //"VER CITAS" o "SEE APPOINTMENT"

        // Ajustar tamaño y establecer layout
        setPreferredSize(new Dimension(750, 531));
        setLayout(null);

        // Establecer los bounds de los componentes
        int labelWidth = 150;
        int fieldWidth = 200;
        int centerX = (750 - fieldWidth) / 2; // Cálculo para centrar horizontalmente

        // Cambiar el tamaño de la fuente del título
        jcomp2.setFont(new Font("Arial", Font.BOLD, 24)); // Cambia el tamaño y el estilo de la fuente aquí

        // Añadir componentes
        jcomp2.setBounds(0, 20, 750, 40); // Título
        labelFecha.setBounds(centerX - labelWidth, 80, labelWidth, 30); // Etiqueta de fecha
        campoFecha.setBounds(centerX, 80, fieldWidth, 30); // Campo de fecha
        labelHora.setBounds(centerX - labelWidth, 120, labelWidth, 30); // Etiqueta de hora
        campoHora.setBounds(centerX, 120, fieldWidth, 30); // Campo de hora
        labelDetalle.setBounds(centerX - labelWidth, 160, labelWidth, 30); // Etiqueta de detalle
        campoDetalle.setBounds(centerX, 160, fieldWidth, 30); // Campo de detalle
        btnGuardar.setBounds(centerX, 200, fieldWidth, 30); // Botón Guardar Cita
        btnVerCitas.setBounds(centerX, 240, fieldWidth, 30); // Botón Ver Citas
        jcomp1.setBounds(5, 460, 100, 25); // Botón "ATRÁS"

        add(jcomp2);
        add(labelFecha);
        add(campoFecha);
        add(labelHora);
        add(campoHora);
        add(labelDetalle);
        add(campoDetalle);
        add(btnGuardar);
        add(btnVerCitas);
        add(jcomp1); // Asegúrate de añadir el botón "ATRÁS" al final

        // Añadir acción al botón "ATRÁS"
        jcomp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new FrontPrincipal(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // Acción para guardar la cita
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = campoFecha.getText(); // Obtener solo la fecha
                String hora = campoHora.getText(); // Obtener solo la hora
                String detalle = campoDetalle.getText();
                citas.add(new AgendarCita(fecha, hora, detalle)); // Crear instancia con fecha, hora y detalle
                JOptionPane.showMessageDialog(null, "Cita guardada.");
            }
        });

        // Acción para ver las citas agendadas
        btnVerCitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder listaCitas = new StringBuilder("Citas agendadas:\n");
                for (AgendarCita cita : citas) {
                    listaCitas.append(cita).append("\n"); // Añadir cada cita a la lista
                }
                JOptionPane.showMessageDialog(null, listaCitas.toString());
            }
        });
    }

}
