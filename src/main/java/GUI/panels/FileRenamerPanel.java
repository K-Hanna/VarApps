package GUI.panels;

import functions.Actions;
import functions.ActionsInterface;

import javax.swing.*;
import java.awt.*;

class FileRenamerPanel extends JPanel {

    private JButton folderButton, renameButton, resetButton;
    private JLabel oldNameLabel, newNameLabel, a, b, c;
    private JTextField folderText, oldNameText, newNameText;

    private final MySettingsTwo settings = new MySettingsTwo();

    FileRenamerPanel(){

        setBackground(null);
        createComps();
        setSettings();
        addComps();

        ActionsInterface actions = new Actions();
        actions.fileRename(this, folderButton, renameButton, resetButton, folderText, oldNameText, newNameText);

    }

    private void createComps(){
        folderButton = new JButton("Folder");
        folderButton.setPreferredSize(new Dimension(100,30));
        
        folderText = new JTextField();
        folderText.setPreferredSize(new Dimension(400, 30));

        oldNameLabel = new JLabel("Find file:");
        oldNameLabel.setPreferredSize(new Dimension( 100,50));
        
        oldNameText = new JTextField();
        oldNameText.setPreferredSize(new Dimension(400,30));

        newNameLabel = new JLabel("Rename to:");
        newNameLabel.setPreferredSize(new Dimension(100,50));
        
        newNameText = new JTextField();
        newNameText.setPreferredSize(new Dimension(400,30));

        renameButton = new JButton("Rename files");
        renameButton.setPreferredSize(new Dimension(150,30));
        renameButton.setMnemonic('r');

        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(150,30));

        a = new JLabel();
        a.setPreferredSize(new Dimension(0,50));

        b = new JLabel();
        b.setPreferredSize(new Dimension(0,50));

        c = new JLabel();
        c.setPreferredSize(new Dimension(20,50));
    }

    private void addComps(){
        add(folderButton);
        add(folderText);
        add(a);
        add(oldNameLabel);
        add(oldNameText);
        add(b);
        add(newNameLabel);
        add(newNameText);
        add(renameButton);
        add(c);
        add(resetButton);
    }

    private void setSettings() {
        settings.myButtonOne(folderButton);
        settings.myFontText(folderText);
        settings.myFontLabel(oldNameLabel);
        settings.myFontText(oldNameText);
        settings.myFontLabel(newNameLabel);
        settings.myFontText(newNameText);
        settings.myButtonOne(renameButton);
        settings.myButtonTwo(resetButton);
    }
}
