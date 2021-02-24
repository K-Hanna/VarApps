package functions.qa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class ReportPrinter {

    private File lastOpened;

    ReportPrinter(File lastOpened) {
        this.lastOpened = lastOpened;
    }

    void printReportToFile(String results, String window) {

        // saving report into file
        File file = new File(window + ".txt");
        this.lastOpened = new File(file.getParent());

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(results);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}