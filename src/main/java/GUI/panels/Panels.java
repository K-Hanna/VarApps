package GUI.panels;

import javax.swing.*;

public class Panels implements PanelsInterface {

    @Override
    public FileCreatorPanel getFileCreatorPanel() {
        return new FileCreatorPanel();
    }

    @Override
    public JPanel getFolderCreatorPanel() {
        return new FolderCreatorPanel();
    }

    @Override
    public JPanel getFileRenamerPanel() {
        return new FileRenamerPanel();
    }

    @Override
    public JPanel getQAPanel() {
        return new QAPanel();
    }

    @Override
    public JPanel getSACreatorPanel() {
        return new SACreatorPanel();
    }

}
