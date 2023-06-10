package GameGUI.Buttons;


import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {
    public MenuButton(String content){
        super(content);
        setProperties();
        
    }
    public void setProperties(){
        setPreferredSize(new Dimension(400, 100));
        setFont(new Font("Arial", Font.BOLD, 35));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}
