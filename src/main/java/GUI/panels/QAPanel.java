package GUI.panels;

import functions.Actions;
import functions.ActionsInterface;

import javax.swing.*;
import java.awt.*;

class QAPanel extends JPanel{

    private JButton sourceButton, testedButton, checkButton, resetButton, helpButton;
    private JTextField sourcePath, testedPath;
    private JCheckBox ignoreSizeCheck, failsOnlyCheck;
    private JLabel a, b, c;

    private final MySettingsTwo settings = new MySettingsTwo();

    QAPanel(){

        setBackground(null);
        createComps();
        setSettings();
        addComps();

        ActionsInterface actions = new Actions();
        actions.qa(this, sourceButton, testedButton, checkButton, resetButton, helpButton, sourcePath, testedPath,
                ignoreSizeCheck, failsOnlyCheck);

    }

    private void createComps(){
        sourceButton = new JButton("Source");
        sourceButton.setPreferredSize(new Dimension(100,30));

        sourcePath = new JTextField();
        sourcePath.setPreferredSize(new Dimension(400, 30));

        testedButton = new JButton("Tested");
        testedButton.setPreferredSize(new Dimension(100,30));

        testedPath = new JTextField();
        testedPath.setPreferredSize(new Dimension(400, 30));

        ignoreSizeCheck = new JCheckBox("Ignore size");
        ignoreSizeCheck.setPreferredSize(new Dimension( 225,50));
        ignoreSizeCheck.setMnemonic('i');

        failsOnlyCheck = new JCheckBox("Show fails only");
        failsOnlyCheck.setPreferredSize(new Dimension(225, 50));
        failsOnlyCheck.setSelected(true);
        failsOnlyCheck.setMnemonic('s');

        helpButton = new JButton("?");
        helpButton.setPreferredSize(new Dimension(50, 30));
        helpButton.setToolTipText("help");
        helpButton.setHorizontalAlignment(SwingConstants.RIGHT);

        checkButton = new JButton("Check");
        checkButton.setPreferredSize(new Dimension(150,30));

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
        add(sourceButton);
        add(sourcePath);
        add(a);
        add(testedButton);
        add(testedPath);
        add(b);
        add(ignoreSizeCheck);
        add(failsOnlyCheck);
        add(helpButton);
        add(checkButton);
        add(c);
        add(resetButton);
    }

    private void setSettings(){
        settings.myButtonOne(sourceButton);
        settings.myFontText(sourcePath);
        settings.myButtonOne(testedButton);
        settings.myFontText(testedPath);
        settings.myCheckBox(ignoreSizeCheck);
        settings.myCheckBox(failsOnlyCheck);
        settings.myButtonTwo(helpButton);
        settings.myButtonOne(checkButton);
        settings.myButtonTwo(resetButton);
    }
}
