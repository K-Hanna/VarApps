package functions.sa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

class PDFReader {

    private String readText;
    private String[] readLines;
    private List<MyDoc> myDocList;
    private String[] projects;

    PDFReader(String filePath) throws IOException {
        projects = projects();
        readText = getReadText(filePath);
        readLines = getReadLines();
        int i = 0;

        setDocumentList();

        for(String line : readLines){
            System.out.print(++i + ". ");
            System.out.println(line);
        }
    }

    String getReadText(String filePath) throws IOException {

        File file = new File(filePath);
        PDDocument document;

        document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        readText = pdfStripper.getText(document);
        document.close();

        return readText;
    }

    String[] getReadLines(){

        return readLines = readText.split("\n");
    }

    void setDocumentList(){
        myDocList = new ArrayList<>();
        MyDoc myDoc;
        String name, path;

        for (int i = 4; i < readLines.length; i++) {
            if (readLines[i].equalsIgnoreCase("approved")) {
                name = readLines[i - 1];
                path = trimPath(readLines[i - 2]);

                for (String project : projects) {
                    if (trimPathTwo(path).contains(project)) {
                        myDoc = new MyDoc(name, path);
                        myDocList.add(myDoc);
                    }
                }
            }
        }
    }

    String[] projects(){
        return new String[]{"project 1", "project 2", "project 3", "project 4", "project 5", "project 6",
                "project 7", "project 8", "project 9", "project 10"};
    }

    List<MyDoc> getMyDocList(){
        return myDocList;
    }

    String trimPath(String p){
        String front = "/help/en/";
        String pone = p.replaceAll(front, "");
        String back = ".html";

        return pone.replaceAll(back, "");
    }

    String trimPathTwo(String p){
        String[] splitText = p.split("/");
        return splitText[0];
    }
}
