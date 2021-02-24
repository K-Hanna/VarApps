package functions;

import javax.swing.*;
import java.io.File;

class FileRenamer {

    private File[] testedFolders;
    private String oldName, newName;

    private int count = 0;

    FileRenamer(JPanel panel, JButton folderButton, JButton renameButton, JButton resetButton,
                JTextField folderText, JTextField oldNameText, JTextField newNameText){

        actions(panel, folderButton, renameButton, resetButton, folderText, oldNameText, newNameText);
    }

    private void actions(JPanel panel, JButton folderButton, JButton renameButton, JButton resetButton,
                         JTextField folderText, JTextField oldNameText, JTextField newNameText){

        folderButton.addActionListener(e -> new FolderChooser(folderText));

        renameButton.addActionListener(e -> {

            loadFiles(folderText);

            oldName = oldNameText.getText();
            newName = newNameText.getText();

            if(check(folderText)){
                rename();
                JOptionPane.showMessageDialog(panel, "Renamed " + count + " files.");
            } else {
                JOptionPane.showMessageDialog(panel, "Missing data.");
            }

            System.out.println();
        });

        resetButton.addActionListener(e -> {
            folderText.setText("");
            oldNameText.setText("");
            newNameText.setText("");
            count = 0;
        });
    }

    // load names of folders for all locales
    private void loadFiles(JTextField folderText) {

        File testPath = new File(folderText.getText());

        try {
            testedFolders = testPath.listFiles();
        } catch (NullPointerException e) {
            folderText.setText("{null}");
        }
    }

    private void rename() {

        for (File testedFolder : testedFolders) {
            File oldFile = new File(testedFolder + "\\" + oldName);
            File newFile = new File(testedFolder + "\\" + newName);

            if(oldFile.exists()) {
                oldFile.renameTo(newFile);
                count++;
            }
        }
    }

    private boolean check(JTextField folderText){

        return !folderText.getText().isEmpty() && !oldName.isEmpty() && !newName.isEmpty();
    }

}
