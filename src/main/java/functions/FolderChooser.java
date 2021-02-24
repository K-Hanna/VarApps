package functions;

import javax.swing.*;
import java.io.File;

class FolderChooser {

    FolderChooser(JTextField folder){
        JFileChooser chooser = new JFileChooser();
        File lastOpened = new File("C:\\");
        chooser.setCurrentDirectory(lastOpened);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            folder.setText(String.valueOf(chooser.getSelectedFile()));
        }
    }
}
