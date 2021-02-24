package GUI;

import javax.swing.*;
import java.awt.*;

class MainPanel extends JPanel {

    private JButton fileCreator, fileRenamer, folderCreator, quickQA, SACreator;
    private MySettings settings = new MySettings();

    MainPanel(){

        setBackground(null);

        createComps();

    }

    private void createComps(){

        JLabel space = new JLabel();
        space.setPreferredSize(new Dimension(300,20));

        fileCreator = new JButton("Create a file");
        fileCreator.setPreferredSize(new Dimension(300,30));
        fileCreator.setMnemonic('f');
        settings.myButtonOne(fileCreator);

        folderCreator = new JButton("Create folders");
        folderCreator.setPreferredSize(new Dimension(300,30));
        folderCreator.setMnemonic('c');
        settings.myButtonOne(folderCreator);

        SACreator = new JButton("Create SA");
        SACreator.setPreferredSize(new Dimension(300,30));
        SACreator.setMnemonic('s');
        settings.myButtonOne(SACreator);

        fileRenamer = new JButton("Rename files");
        fileRenamer.setPreferredSize(new Dimension(300,30));
        fileRenamer.setMnemonic('r');
        settings.myButtonOne(fileRenamer);

        quickQA = new JButton("Quality assurance");
        quickQA.setPreferredSize(new Dimension(300,30));
        quickQA.setMnemonic('q');
        settings.myButtonOne(quickQA);

        add(space);
        add(fileCreator);
        add(folderCreator);
        add(SACreator);
        add(fileRenamer);
        add(quickQA);
    }

    JButton getFileCreator() {
        return fileCreator;
    }

    JButton getFolderCreator() {
        return folderCreator;
    }

    JButton getSACreator() {
        return SACreator;
    }

    JButton getFileRenamer() {
        return fileRenamer;
    }

    JButton getQuickQA() {
        return quickQA;
    }

}
