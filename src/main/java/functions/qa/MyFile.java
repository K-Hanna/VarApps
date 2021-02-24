package functions.qa;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class MyFile {

    private String name;
    private int height, width;

    MyFile(File file) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = file.getName();
        this.height = image.getHeight();
        this.width = image.getWidth();
    }

    String getName() {
        return name;
    }

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return  name + ", " + height + "x" + width;
    }
}
