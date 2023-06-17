package GameGUI.Panels;

import GameGUI.Buttons.MenuButton;
import GameGUI.GameFrame;
import GameGUI.MenuWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class BestScoresPanel extends JPanel {
     JTable scoresTable;
     MenuButton mainMenuButton;

     DefaultTableModel tableModel;
    ArrayList<Object[]> scoreList;
    GameFrame gameFrame;

    public BestScoresPanel() {
        gameFrame = GameFrame.getInstance();
        setLayout(new GridBagLayout());
        scoreList = new ArrayList<>();
        initializeBestScoresPanel();
    }
    void initializeBestScoresPanel(){
        initializeTableModel();
        initializeScoresTable();
        initializeMainMenuButton();
        initializeScoresTable();
        initializeTableHeader();
        setLayout();
        initializeMsg();
        loadScoresFromFile();
    }
    void initializeTableModel(){
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Place");
        tableModel.addColumn("Username");
        tableModel.addColumn("Points");
        tableModel.addColumn("Time");
    }
    void setLayout(){
        JScrollPane scrollPane = new JScrollPane(scoresTable);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.CENTER;
        add(scrollPane, gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        add(mainMenuButton,gbc);
    }
    void initializeScoresTable(){
        scoresTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                return new CustomTableCellRenderer();
            }
        };
        scoresTable.setFont(scoresTable.getFont().deriveFont(20f));
        scoresTable.setRowHeight(26);
    }
    void initializeTableHeader(){
        JTableHeader tableHeader = scoresTable.getTableHeader();
        tableHeader.setFont(tableHeader.getFont().deriveFont(24f));
        tableHeader.setDefaultRenderer(new HeaderCellRenderer());
    }
    void initializeMainMenuButton(){
        mainMenuButton = new MenuButton("Main Menu");
        mainMenuButton.addActionListener(e -> {
            gameFrame.getContentPane().removeAll();
            gameFrame.repaint();
            new MenuWindow();
        });
    }
    void initializeMsg(){
        JLabel gameOverLabel = new JLabel("Best Scores");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 70));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.CENTER;
        add(gameOverLabel, gbc);
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
                    int number = 0;
                    scoreList.add(new Object[]{number,username, points, time});
                }
            }
            scoreList.sort(Comparator
                    .comparing((Object[] o) -> Double.parseDouble((String) o[2]))
                    .reversed()
                    .thenComparing((Object[] o) -> Double.parseDouble((String) o[3]))
            );
            int ordinalNumber = 1;
            for (Object[] item : scoreList) {
                item[0] = ordinalNumber;

                tableModel.addRow(item);
                ordinalNumber++;
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
            rendererComponent.setFont(rendererComponent.getFont().deriveFont(20f));
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
            component.setFont(component.getFont().deriveFont(Font.BOLD, 24f));
            return component;
        }
    }
}
