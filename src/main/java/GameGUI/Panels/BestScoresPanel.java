package GameGUI.Panels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
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
        scoresTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Blokuj edycję wszystkich komórek w tabeli
            }

            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                return new CustomTableCellRenderer();
            }
        };

        scoresTable.setFont(scoresTable.getFont().deriveFont(20f)); // Ustaw rozmiar czcionki dla tabeli
        scoresTable.setRowHeight(26); // Ustaw większą wysokość komórek

        // Set header renderer to increase header font size
        JTableHeader tableHeader = scoresTable.getTableHeader();
        tableHeader.setFont(tableHeader.getFont().deriveFont(24f)); // Ustaw rozmiar czcionki dla nagłówków kolumn
        tableHeader.setDefaultRenderer(new HeaderCellRenderer());

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

    private class CustomTableCellRenderer extends DefaultTableCellRenderer {
        public CustomTableCellRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            rendererComponent.setFont(rendererComponent.getFont().deriveFont(20f)); // Ustaw rozmiar czcionki dla komórek
            return rendererComponent;
        }
    }

    private class HeaderCellRenderer implements TableCellRenderer {
        private final DefaultTableCellRenderer renderer;

        public HeaderCellRenderer() {
            renderer = (DefaultTableCellRenderer) scoresTable.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            component.setFont(component.getFont().deriveFont(Font.BOLD, 24f)); // Ustaw rozmiar czcionki dla nagłówków kolumn
            return component;
        }
    }
}
