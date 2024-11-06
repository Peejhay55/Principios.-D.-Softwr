import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchApp extends JFrame {
    private JTextField searchField;
    private JTextArea resultsArea;
    private JButton searchButton;
    private JButton clearButton;
    private final String API_KEY = "TU_API_KEY";       // Reemplaza con tu clave de API de Google
    private final String CX = "TU_CX";                 // Reemplaza con tu ID del motor de búsqueda

    public SearchApp() {
        setTitle("Buscador de Síntomas en la Web");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con campo de búsqueda y botones
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        searchField = new JTextField(20);
        searchButton = new JButton("Buscar");
        clearButton = new JButton("Limpiar");

        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(clearButton);

        add(topPanel, BorderLayout.NORTH);

        // Área de resultados
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        add(scrollPane, BorderLayout.CENTER);

        // Acciones de botones
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSearch();
            }
        });
    }

    // Método para realizar la búsqueda en Google
    private void performSearch() {
        String query = searchField.getText().trim();
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

    // Método para limpiar la búsqueda
    private void clearSearch() {
        searchField.setText("");
        resultsArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SearchApp().setVisible(true));
    }
}

