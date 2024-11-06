import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class FrontPrincipal extends JPanel {

    // Componentes de la interfaz
    private JButton jcomp4;
    private JButton jcomp5;
    private JButton jcomp6;
    private JButton jcomp7;
    private JTextField jcomp8;
    private JButton jcomp9;
    private JLabel jcomp10;
    private JButton jcomp11;
    private JTextArea resultsArea;      // Área para mostrar los resultados de la búsqueda
    private JButton clearButton;        // Botón para limpiar la búsqueda
    private final String API_KEY = "TU_API_KEY"; // Reemplazar con la clave de la API de Google
    private final String CX = "TU_CX";           // Reemplazar con el ID del motor de búsqueda personalizado de Google

    public FrontPrincipal(JFrame frame) {

        // Crear componentes
        jcomp4 = new JButton(Idioma.getTexto(0)); //"RECOMENDACIONES MÉDICAS"
        jcomp5 = new JButton(Idioma.getTexto(1)); //"PÁGINAS CONFIABLES"
        jcomp6 = new JButton(Idioma.getTexto(2)); //"ASESORÍA VIRTUAL"
        jcomp7 = new JButton(Idioma.getTexto(3)); //"AGENDAR CITA"
        jcomp8 = new JTextField(20);              // Campo de búsqueda
        JButton searchButton = new JButton("Buscar"); // Botón de búsqueda
        clearButton = new JButton("Limpiar");     // Botón para limpiar búsqueda
        jcomp9 = new JButton(Idioma.getTexto(4)); //"RESEÑAS"
        jcomp10 = new JLabel(Idioma.getTexto(5), SwingConstants.CENTER); //"NOMBRE DE LA PÁGINA"
        jcomp11 = new JButton(Idioma.getTexto(6)); //"IDIOMA"
        resultsArea = new JTextArea(10, 50);      // Área de resultados de búsqueda
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);

        // Ajustar tamaño y establecer layout
        setPreferredSize(new Dimension(800, 600));
        setLayout(null);

        // Añadir componentes
        add(jcomp10);
        add(jcomp11);
        add(jcomp4);
        add(jcomp5);
        add(jcomp6);
        add(jcomp7);
        add(jcomp8);
        add(searchButton);
        add(clearButton);   // Añadir el botón de limpiar
        add(jcomp9);
        add(scrollPane);

        // Establecer los bounds de los componentes
        int labelWidth = 300;
        jcomp10.setBounds((getWidth() - labelWidth) / 2, 5, labelWidth, 40);
        jcomp11.setBounds(5, 560, 100, 25);
        jcomp4.setBounds(25, 50, 210, 40);
        jcomp5.setBounds(245, 50, 170, 40);
        jcomp6.setBounds(425, 50, 165, 40);
        jcomp7.setBounds(605, 50, 150, 40);
        jcomp8.setBounds(165, 150, 335, 30);         // Campo de búsqueda
        searchButton.setBounds(510, 150, 90, 30);    // Botón de búsqueda
        clearButton.setBounds(610, 150, 90, 30);     // Botón de limpiar
        scrollPane.setBounds(100, 200, 600, 300);    // Área de resultados de búsqueda
        jcomp9.setBounds(670, 560, 100, 25);

        // Acción del botón de búsqueda
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        // Acción del botón de limpiar
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSearch();
            }
        });

        // Acción del botón de idioma
        jcomp11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new IdiomaFront(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // Otros botones conservan su funcionalidad
        jcomp7.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new AgendarCitaFront(frame));
            frame.revalidate();
            frame.repaint();
        });
        jcomp6.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new AsesoriaFront(frame));
            frame.revalidate();
            frame.repaint();
        });
        jcomp5.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new PaginasConfiablesFront(frame));
            frame.revalidate();
            frame.repaint();
        });
        jcomp9.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new ReseñaFront(frame));
            frame.revalidate();
            frame.repaint();
        });
        jcomp4.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new RecomendacionFront(frame));
            frame.revalidate();
            frame.repaint();
        });
    }

    // Método para realizar la búsqueda en Google
    private void performSearch() {
        String query = jcomp8.getText().trim();
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un síntoma para buscar.");
            return;
        }

        try {
            String response = searchInGoogle(query);
            displayResults(response);
        } catch (Exception e) {
            resultsArea.setText("Error al realizar la búsqueda: " + e.getMessage());
        }
    }

    // Método para realizar la solicitud a la API de Google Custom Search
    private String searchInGoogle(String query) throws Exception {
        String urlString = "https://www.googleapis.com/customsearch/v1?key=" + API_KEY + "&cx=" + CX + "&q=" + query;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();

        return content.toString();
    }

    // Método para mostrar los resultados en la interfaz
    private void displayResults(String jsonResponse) {
        resultsArea.setText("Resultados de búsqueda:\n");
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray items = jsonObject.getJSONArray("items");

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            String title = item.getString("title");
            String link = item.getString("link");

            resultsArea.append((i + 1) + ". " + title + "\n" + link + "\n\n");
        }
    }

    // Método para limpiar la búsqueda y el área de resultados
    private void clearSearch() {
        jcomp8.setText("");
        resultsArea.setText("");
    }

    @Override
    public void doLayout() {
        super.doLayout();
        int labelWidth = 300;
        jcomp10.setBounds((getWidth() - labelWidth) / 2, 5, labelWidth, 40);
    }

    // Método principal para iniciar el programa
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FrontPrincipal(frame));
        frame.pack();
        frame.setVisible(true);
    }
}
