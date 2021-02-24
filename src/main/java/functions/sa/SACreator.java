package functions.sa;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

class SACreator {

    private File lastOpened = new File("C:\\");

    SACreator(JPanel panel, JButton folderButton, JButton createButton, JButton findButton, 
              JTextField fileText, JTextField folderText, JTextField nameText){

        actions(panel, folderButton, createButton, findButton, fileText, folderText, nameText);
    }

    private void actions(JPanel panel, JButton folderButton, JButton createButton, JButton findButton,
                         JTextField fileText, JTextField folderText, JTextField nameText){

        findButton.addActionListener(e -> findFile(fileText));
        folderButton.addActionListener(e -> findFolder(folderText));
        createButton.addActionListener(e -> {

            if(check(folderText, fileText, nameText)){
                try {
                    if(fileText.getText().contains("html")){
                        HTMLReader html = new HTMLReader(fileText.getText());
                        String filePlace = folderText.getText() + "\\" + nameText.getText() + ".xlsx";
                        new ExcelMaker(html, filePlace);
                    } else if(fileText.getText().contains("xlsx")) {
                        ExcelReader excel = new ExcelReader(fileText.getText());
                        String filePlace = folderText.getText() + "\\" + nameText.getText() + ".xlsx";
                        new ExcelMaker(excel, filePlace);
                    } else {
                        PDFReader pdf = new PDFReader(fileText.getText());
                        String filePlace = folderText.getText() + "\\" + nameText.getText() + ".xlsx";
                        new ExcelMaker(pdf, filePlace);
                    }
                    JOptionPane.showMessageDialog(panel, "Your excel file has been generated!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "Something went wrong.");
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Missing data.");
            }
        });
    }

    private void findFile(JTextField fileText){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(lastOpened);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDf files", "pdf", "html", "xlsx");
        chooser.setFileFilter(filter);

        File testPath = null;

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            testPath = chooser.getSelectedFile();
            lastOpened = testPath.getParentFile();
        }

        try {
            assert testPath != null;
            fileText.setText(testPath.getAbsolutePath());
        } catch (NullPointerException e) {
            fileText.setText("{null}");
        }

    }

    private void findFolder(JTextField folderText){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(lastOpened);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        File testPath = null;

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            testPath = chooser.getSelectedFile();
        }

        try {
            assert testPath != null;
            folderText.setText(testPath.getAbsolutePath());
        } catch (NullPointerException e) {
            folderText.setText("{null}");
        }
    }

    private boolean check(JTextField folderText, JTextField fileText, JTextField nameText){
        return !folderText.getText().isEmpty() && !nameText.getText().isEmpty() && !fileText.getText().isEmpty();
    }
}
