package GUI;

import javax.swing.*;
import java.awt.*;

class MySettings {

    JLabel setMyBackground(){

        JLabel background = new JLabel();
        ImageIcon image = null;

        try {
            image = new ImageIcon(getClass().getResource("/background2.png"));
        } catch (Exception e) {
            System.out.println("Problem with picture.");
        }

        background.setIcon(image);
        background.setVisible(true);
        background.setOpaque(true);

        return background;
    }

    void myButtonOne(JButton button){
        button.setFont(new Font("System Italic", Font.PLAIN, 18));
        button.setForeground(Color.white);
        button.setBackground(new Color(18,82,186));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    void myButtonTwo(JButton button){
        button.setFont(new Font("System Italic", Font.PLAIN, 18));
        button.setForeground(new Color(18,82,186));
        button.setBackground(Color.black);
        button.setBorder(null);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
