package GUI.panels;

import functions.Actions;
import functions.ActionsInterface;

import javax.swing.*;
import java.awt.*;

class SACreatorPanel extends JPanel {

    private JButton folderButton, createButton, findButton;
    private JLabel nameLabel, a, b, c;
    private JTextField fileText, folderText, nameText;
    
    private final MySettingsTwo settings = new MySettingsTwo();

    SACreatorPanel(){

        setBackground(null);
        createComps();
        setSettings();
        addComps();

        ActionsInterface action = new Actions();
        action.SACreate(this, folderButton, createButton, findButton, fileText, folderText, nameText);
    }

    private void createComps(){

        findButton = new JButton("Catalog");
        findButton.setPreferredSize(new Dimension( 100,30));
        
        fileText = new JTextField();
        fileText.setPreferredSize(new Dimension(400,30));

        folderButton = new JButton("Folder");
        folderButton.setPreferredSize(new Dimension(100,30));
        
        folderText = new JTextField();
        folderText.setPreferredSize(new Dimension(400, 30));

        nameLabel = new JLabel("Excel name:");
        nameLabel.setPreferredSize(new Dimension(100,50));
        
        nameText = new JTextField();
        nameText.setPreferredSize(new Dimension(400,30));

        createButton = new JButton("Create file");

        a = new JLabel();
        a.setPreferredSize(new Dimension(0,50));

        b = new JLabel();
        b.setPreferredSize(new Dimension(0,50));

        c = new JLabel();
        c.setPreferredSize(new Dimension(0,50));
    }

    private void addComps(){
        add(findButton);
        add(fileText);
        add(a);
        add(folderButton);
        add(folderText);
        add(b);
        add(nameLabel);
        add(nameText);
        add(c);
        add(createButton);
    }

    private void setSettings(){
        settings.myButtonOne(findButton);
        settings.myFontText(fileText);
        settings.myButtonOne(folderButton);
        settings.myFontText(folderText);
        settings.myFontLabel(nameLabel);
        settings.myFontText(nameText);
        settings.myButtonOne(createButton);
    }
}
