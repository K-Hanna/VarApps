package GUI.panels;

import functions.Actions;
import functions.ActionsInterface;

import javax.swing.*;
import java.awt.*;

class FileCreatorPanel extends JPanel{

    private JLabel nameLabel, sizeLabel, a, b, c;
    private JTextField folderText, nameText, sizeText;
    private JButton folderButton, createButton;
    private JComboBox<String> sizeList;
    
    private final MySettingsTwo settings = new MySettingsTwo();

    FileCreatorPanel(){

        setBackground(null);
        createComps();
        setSettings();
        addComps();

        ActionsInterface actions = new Actions();
        actions.fileCreate(this, folderText, nameText, sizeText, sizeList, folderButton, createButton);
    }

    private void createComps(){

        folderButton = new JButton("Folder");
        folderButton.setPreferredSize(new Dimension(100,30));

        folderText = new JTextField();
        folderText.setPreferredSize(new Dimension(400,30));

        nameLabel = new JLabel("Name:");
        nameLabel.setPreferredSize(new Dimension(100,50));

        nameText = new JTextField();
        nameText.setPreferredSize(new Dimension(400,30));
        nameText.setToolTipText("Only letters and numbers.");

        sizeLabel = new JLabel("Size:");
        sizeLabel.setPreferredSize(new Dimension(100,50));

        sizeText = new JTextField();
        sizeText.setPreferredSize(new Dimension(200,30));
        sizeText.setToolTipText("Only numbers.");

        String[] sizes = {"kB", "MB", "GB"};
        sizeList = new JComboBox<>(sizes);
        sizeList.setPreferredSize(new Dimension(200,30));

        createButton = new JButton("create");
        createButton.setPreferredSize(new Dimension(150,30));

        a = new JLabel();
        a.setPreferredSize(new Dimension(0,50));

        b = new JLabel();
        b.setPreferredSize(new Dimension(0,50));

        c = new JLabel();
        c.setPreferredSize(new Dimension(0,50));
    }

    private void addComps(){
        add(folderButton);
        add(folderText);
        add(a);
        add(nameLabel);
        add(nameText);
        add(b);
        add(sizeLabel);
        add(sizeText);
        add(sizeList);
        add(c);
        add(createButton);
    }

    private void setSettings(){
        settings.myButtonOne(folderButton);
        settings.myFontText(folderText);
        settings.myFontLabel(nameLabel);
        settings.myFontText(nameText);
        settings.myFontLabel(sizeLabel);
        settings.myFontText(sizeText);
        settings.myComboBox(sizeList);
        settings.myButtonOne(createButton);
    }
}
