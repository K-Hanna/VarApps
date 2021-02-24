package functions.sa;

import javax.swing.*;

public class SAImpl implements SAInterface{

    @Override
    public void sa(JPanel panel, JButton folderButton, JButton createButton, JButton findButton,
                   JTextField fileText, JTextField folderText, JTextField nameText) {

        new SACreator(panel, folderButton, createButton, findButton, fileText, folderText, nameText);
    }
}
