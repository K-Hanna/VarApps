package GUI.panels;

import javax.swing.*;
import java.awt.*;

class MySettingsTwo {

    void myFontLabel(JLabel label){
        label.setFont(new Font("System Italic", Font.PLAIN, 18));
        label.setForeground(Color.white);
    }

    void myFontText(JTextField textField){
        textField.setFont(new Font("System Italic", Font.PLAIN, 18));
        textField.setForeground(Color.white);
        textField.setBackground(Color.black);
    }

    void myFontLabelTwo(JLabel label){
        label.setFont(new Font("System Italic", Font.PLAIN, 11));
        label.setForeground(Color.white);
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

    void myCheckBox(JCheckBox checkBox){
        checkBox.setFont(new Font("System Italic", Font.PLAIN, 18));
        checkBox.setForeground(Color.white);
        checkBox.setBackground(Color.black);
    }

    void myCheckBoxTwo(JCheckBox checkBox){
        checkBox.setFont(new Font("System Italic", Font.PLAIN, 11));
        checkBox.setForeground(Color.white);
        checkBox.setBackground(Color.black);
    }

    void myComboBox(JComboBox comboBox){
        comboBox.setFont(new Font("System Italic", Font.PLAIN, 18));
        comboBox.setForeground(Color.white);
        comboBox.setBackground(Color.black);
    }
}
