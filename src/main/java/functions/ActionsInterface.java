package functions;

import javax.swing.*;

public interface ActionsInterface {

    void fileCreate(JPanel panel, JTextField folderText, JTextField nameText, JTextField sizeText,
                    JComboBox sizeList, JButton chooseButton, JButton createButton);

    void folderCreate(JPanel panel, JTextField folderText, JLabel sourceLabel, JComboBox optionsText,
                      JButton folderButton, JButton createButton, JCheckBox localsOnly, JCheckBox[] options);

    void SACreate(JPanel panel, JButton folderButton, JButton createButton, JButton findButton,
                  JTextField fileText, JTextField folderText, JTextField nameText);

    void fileRename(JPanel panel, JButton folderButton, JButton renameButton, JButton resetButton,
                    JTextField folderText, JTextField oldNameText, JTextField newNameText);

    void qa(JPanel panel, JButton sourceButton, JButton testedButton, JButton checkButton,
            JButton resetButton, JButton helpButton, JTextField sourcePath, JTextField testedPath,
            JCheckBox ignoreSizeCheck, JCheckBox failsOnlyCheck);
}
