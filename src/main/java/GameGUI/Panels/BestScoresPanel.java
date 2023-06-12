package GameGUI.Panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BestScoresPanel extends JPanel {
    private JTable scoresTable;
    private DefaultTableModel tableModel;

    public BestScoresPanel() {
        setLayout(new BorderLayout());

        // Create table model with 3 columns
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Username");
        tableModel.addColumn("Points");
        tableModel.addColumn("Time");

        // Create scores table using the table model
        scoresTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(scoresTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load scores from file
        loadScoresFromFile();
    }

    private void loadScoresFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("scores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] scoreData = line.split(",");
                if (scoreData.length >= 3) {
                    String username = scoreData[0];
                    String points = scoreData[1];
                    String time = scoreData[2];
                    tableModel.addRow(new Object[]{username, points, time});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
