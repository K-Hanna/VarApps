package functions;

import functions.qa.QAImp;
import functions.qa.QAInterface;

import functions.sa.SAImpl;
import functions.sa.SAInterface;

import javax.swing.*;

public class Actions implements ActionsInterface {

    @Override
    public void fileCreate(JPanel panel, JTextField folderText, JTextField nameText, JTextField sizeText,
                           JComboBox sizeList, JButton folderButton, JButton createButton) {

        new FileCreator(panel, folderText, nameText, sizeText, sizeList, folderButton, createButton);
    }

    @Override
    public void folderCreate(JPanel panel, JTextField folderText, JLabel sourceLabel, JComboBox optionsText,
                             JButton folderButton, JButton createButton, JCheckBox localsOnly, JCheckBox[] options) {

        new FolderCreator(panel, folderText, sourceLabel, optionsText, folderButton, createButton,
                localsOnly, options);
    }

    @Override
    public void SACreate(JPanel panel, JButton folderButton, JButton createButton, JButton findButton,
                JTextField fileText, JTextField folderText, JTextField nameText) {

        SAInterface saInterface = new SAImpl();
        saInterface.sa(panel, folderButton, createButton, findButton, fileText, folderText, nameText);

    }

    @Override
    public void fileRename(JPanel panel, JButton folderButton, JButton renameButton, JButton resetButton,
                           JTextField folderText, JTextField oldNameText, JTextField newNameText){

        new FileRenamer(panel, folderButton, renameButton, resetButton, folderText, oldNameText, newNameText);

    }

    @Override
    public void qa(JPanel panel, JButton sourceButton, JButton testedButton, JButton checkButton,
                                     JButton resetButton, JButton helpButton, JTextField sourcePath, JTextField testedPath,
                                     JCheckBox ignoreSizeCheck, JCheckBox failsOnlyCheck){

        QAInterface qaInterface = new QAImp();
        qaInterface.qa(panel, sourceButton, testedButton, checkButton, resetButton, helpButton, sourcePath, testedPath,
                ignoreSizeCheck, failsOnlyCheck);
    }
}
