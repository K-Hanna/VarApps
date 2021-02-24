package functions;

import javax.swing.*;
import java.io.File;

class FolderCreator {

    FolderCreator(JPanel panel, JTextField folderText, JLabel sourceLabel, JComboBox optionsText,
                  JButton folderButton, JButton createButton, JCheckBox localsOnly, JCheckBox[] options){

        action(panel, folderText, sourceLabel, optionsText, folderButton, createButton, localsOnly, options);
    }

    private void action(JPanel panel, JTextField folderText, JLabel sourceLabel, JComboBox optionsText,
                       JButton folderButton, JButton createButton, JCheckBox localsOnly, JCheckBox[] options){

        optionsText.addActionListener(e ->selectOptions(sourceLabel, optionsText, options));
        folderButton.addActionListener(e -> new FolderChooser(folderText));
        createButton.addActionListener(e -> createFolders(panel, folderText, optionsText, localsOnly, options));
    }

    private void create(JPanel panel, String name) {
        File files = new File(name);

        if (!files.exists()) {
            if (!files.mkdirs()) {
                JOptionPane.showMessageDialog(panel, "Folders have been created.");
            }
        }
    }

    private void selectOptions(JLabel sourceLabel, JComboBox optionsText, JCheckBox[] options){
        int[] locals = new int[0];

        switch (optionsText.getSelectedIndex()){
            case 0:
                locals = new int[0];
                sourceLabel.setText("");
                break;
            case 1:
                locals = new int[]{2, 4, 5, 8, 11, 12, 13, 17, 18, 19, 22, 25, 27, 29, 30};
                sourceLabel.setText("source: ar_AE, he_IL");
                break;
            case 2:
                locals = new int[]{2, 3, 4, 5, 8, 10, 11, 12, 17, 18, 19, 22, 25, 27, 28};
                sourceLabel.setText("source: ar_AE, he_IL");
                break;
            case 3:
                locals = new int[]{2, 3, 4, 5, 7, 8, 10, 11, 12, 16, 17, 18, 19, 22, 25, 27, 28};
                sourceLabel.setText("source: ar_AE, he_IL");
                break;
            case 4:
                locals = new int[]{4, 5, 8, 11, 12, 13, 19, 22, 29};
                sourceLabel.setText("");
                break;
            case 5:
            case 6:
                locals = new int[options.length];
                for(int i = 0; i < options.length; i++){
                    if(i == 20 || i == 26)
                        continue;
                    locals[i] = i;
                }
                sourceLabel.setText("");
                break;
            case 7:
                locals = new int[]{2, 3, 4, 5, 7, 8, 11, 12, 13, 16, 17, 18, 19, 22, 25, 27, 29, 30};
                sourceLabel.setText("source: ar_AE, he_IL, hu_HU, uk_UA");
                break;
            case 8:
            case 11:
                locals = new int[]{2, 3, 4, 5, 7, 8, 11, 12, 13, 16, 17, 18, 19, 22, 25, 27, 29, 30};
                sourceLabel.setText("");
                break;
            case 9:
                locals = new int[]{2, 3, 4, 5, 8, 11, 12, 13, 16, 17, 18, 19, 20, 22, 25, 26, 28};
                sourceLabel.setText("");
                break;
            case 10:
                locals = new int[]{2, 3, 4, 5, 8, 11, 12, 13, 16, 17, 18, 19, 20, 22, 25, 26, 27, 28, 29};
                sourceLabel.setText("");
                break;
        }

        for (int i = 0; i < options.length; i++) {
            if(check(locals, i))
                options[i].setSelected(true);
            else
                options[i].setSelected(false);
        }
    }

    private void createFolders(JPanel panel, JTextField folderText, JComboBox optionsText, JCheckBox localsOnly,
                               JCheckBox[] options){

        if(!folderText.getText().isEmpty() && optionsText.getSelectedIndex() != 0) {

            if(localsOnly.isSelected()){
                for (JCheckBox option : options){
                    if(option.isSelected()) {
                        String path = folderText.getText().concat(("\\").concat(option.getText()));
                        create(panel, path);
                    }
                }
            } else {
                String source = folderText.getText().concat("\\1. Source");
                create(panel, source);

                for (JCheckBox option : options) {
                    if (option.isSelected()) {
                        String store = folderText.getText().concat("\\2. Store\\").concat(option.getText());
                        create(panel, store);
                        String toUpload = folderText.getText().concat("\\3. To Upload\\").concat(option.getText());
                        create(panel, toUpload);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Folders have been created.");
        } else {
            JOptionPane.showMessageDialog(null, "Missing data.");
        }
    }

    private boolean check(int[] array, int value){

        boolean test = false;

        for (int element : array) {
            if (element == value) {
                test = true;
                break;
            }
        }
        return test;
    }

}
