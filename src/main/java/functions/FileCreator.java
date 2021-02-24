package functions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

class FileCreator {

    FileCreator(JPanel panel, JTextField folderText, JTextField nameText, JTextField sizeText,
                JComboBox sizeList, JButton folderButton, JButton createButton) {

        action(panel, folderText, nameText, sizeText, sizeList, folderButton, createButton);

    }

    private void action(JPanel panel, JTextField folderText, JTextField nameText, JTextField sizeText,
                        JComboBox sizeList, JButton folderButton, JButton createButton){

        folderButton.addActionListener(e -> new FolderChooser(folderText));

        createButton.addActionListener(e -> {
            if (check(folderText, nameText, sizeText)) {
                createFile(panel, folderText, nameText, sizeText, sizeList);
            } else {
                JOptionPane.showMessageDialog(panel, "Missing or incorrect data.");
            }
        });
    }

    private void create(String name, long size) throws IOException {

        int width = 250;
        int height = 250;
        Random rand = new Random();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();

        File file = new File(name);
        ImageIO.write(bufferedImage, "png", file);

        RandomAccessFile f = new RandomAccessFile(file, "rw");
        f.setLength(size);
    }

    private long recount(int itemId){
        if(itemId == 0){
            return 1024;
        } else if(itemId == 1){
            return 1048576;
        } else {
            return 1073741824;
        }
    }

    private void createFile(JPanel panel, JTextField folderText, JTextField nameText, JTextField sizeText,
                            JComboBox sizeList){
        String name = folderText.getText().concat("\\").concat(nameText.getText()).concat(".png");
        int itemId = sizeList.getSelectedIndex();

        try {
            long size = Long.parseLong(sizeText.getText()) * recount(itemId);

            try {
                create(name, size);
                JOptionPane.showMessageDialog(panel, "File has been created.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(panel, "Oops, something went wrong.");
            }
        } catch (NumberFormatException ee){
            JOptionPane.showMessageDialog(panel, "Given size is too big.");
        }
    }

    private boolean check(JTextField folderText, JTextField nameText, JTextField sizeText){
        return nameText.getText().matches("[A-Za-z0-9]+") && sizeText.getText().matches("[0-9]+")
                && !folderText.getText().isEmpty();
    }
}
