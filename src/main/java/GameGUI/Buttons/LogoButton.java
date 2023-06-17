package GameGUI.Buttons;

import GameGUI.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class LogoButton extends JButton {
    GameFrame gameFrame;
    public LogoButton() {
        super("");
        gameFrame = GameFrame.getInstance();
        setLogo("assets/pacman_logo.png");
        setBorder(null);
        setBackground(new Color(238, 238, 238));
    }

    private void setLogo(String logoFilePath) {
        try {
            File logoFile = new File(logoFilePath);
            Image logoImage = new ImageIcon(logoFile.getAbsolutePath()).getImage();
            setIcon(new ImageIcon(logoImage.getScaledInstance(logoImage.getWidth(this)/5, logoImage.getHeight(this)/5, Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}