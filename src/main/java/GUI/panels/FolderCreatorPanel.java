package GUI.panels;

import functions.Actions;
import functions.ActionsInterface;

import javax.swing.*;
import java.awt.*;

class FolderCreatorPanel extends JPanel {

    private JLabel optionsLabel, sourceLabel, a, b;
    private JTextField folderText;
    private JComboBox<String> optionsBox;
    private final JCheckBox[] options = new JCheckBox[31];
    private JButton folderButton, createButton;
    private JCheckBox localsOnlyCheck;

    private final MySettingsTwo settings = new MySettingsTwo();

    FolderCreatorPanel(){

        setBackground(null);
        createComps();
        setSettings();
        addComps();

        ActionsInterface actions = new Actions();
        actions.folderCreate(this, folderText, sourceLabel, optionsBox, folderButton, createButton,
                localsOnlyCheck, options);

    }

    private void createComps(){

        folderButton = new JButton("Folder: ");
        folderButton.setPreferredSize(new Dimension(100,30));

        folderText = new JTextField();
        folderText.setEditable(false);
        folderText.setPreferredSize(new Dimension(400,30));

        a = new JLabel();
        a.setPreferredSize(new Dimension(0,50));

        optionsLabel = new JLabel("Project: ");
        optionsLabel.setPreferredSize(new Dimension(100,50));

        String[] projects = {"--select--", "project 1",  "project 2",  "project 3",  "project 4",  "project 5",
                "project 6",  "project 7",  "project 8",  "project 9",  "project 10"};

        optionsBox = new JComboBox<>(projects);
        optionsBox.setPreferredSize(new Dimension(200,30));

        localsOnlyCheck = new JCheckBox("Locals only");
        localsOnlyCheck.setPreferredSize(new Dimension(120,30));

        createButton= new JButton("Create");
        createButton.setPreferredSize(new Dimension(100,30));

        String[] names = options();

        for(int i = 0; i < options.length; i++){
            options[i] = new JCheckBox(names[i]);
            options[i].setPreferredSize(new Dimension(62,20));
        }

        b = new JLabel();
        b.setPreferredSize(new Dimension(62,20));

        sourceLabel = new JLabel();
        sourceLabel.setPreferredSize(new Dimension(200,20));
    }

    private void addComps(){

        add(folderButton);
        add(folderText);
        add(a);
        add(optionsLabel);
        add(optionsBox);
        add(localsOnlyCheck);
        add(createButton);

        for (JCheckBox jCheckBox : options) {
            add(jCheckBox);
        }

        add(b);
        add(sourceLabel);
    }

    private void setSettings(){
        settings.myButtonOne(folderButton);
        settings.myFontText(folderText);
        settings.myFontLabel(optionsLabel);
        settings.myComboBox(optionsBox);
        settings.myCheckBox(localsOnlyCheck);
        settings.myButtonOne(createButton);
        settings.myFontLabelTwo(sourceLabel);

        for (JCheckBox jCheckBox : options) {
            settings.myCheckBoxTwo(jCheckBox);
        }
    }

    private String[] options(){
        return new String[]{ /*0*/ "ar_AE", /*1*/"bg_BG", /*2*/"cs_CZ", /*3*/"da_DK", /*4*/"de_DE", /*5*/"es_ES",
                /*6*/"et_EE", /*7*/"fi_FI", /*8*/"fr_FR", /*9*/"he_IL", /*10*/"hu_HU", /*11*/"it_IT", /*12*/"ja_JP",
                /*13*/"ko_KR", /*14*/"lt_LT", /*15*/"lv_LV", /*16*/"nb_NO", /*17*/"nl_NL", /*18*/"pl_PL", /*19*/"pt_BR",
                /*20*/"pt_PT", /*21*/"ro_RO", /*22*/"ru_RU", /*23*/"sk_SK", /*24*/"sl_SI",/*25*/ "sv_SE", /*26*/"th_TH",
                /*27*/"tr_TR", /*28*/"uk_UA", /*29*/"zh_CN", /*30*/"zh_TW"};
    }

}


