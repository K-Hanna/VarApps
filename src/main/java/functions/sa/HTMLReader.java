package functions.sa;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class HTMLReader {

    private String[] readLines;
    private Elements readText;
    private List<MyDoc> myDocList;
    private String[] projects;

    HTMLReader(String path) throws IOException {

        String newPath = path.replaceAll("\\\\", "\\/");
        projects = projects();
        readText = getReadText(newPath);
        readLines = getReadLines();

        setDocumentList();
    }

    Elements getReadText(String path) throws IOException {

        File input = new File(path);
        Document doc = Jsoup.parse(input, "UTF-8", "");

        return doc.select("td");
    }

    String[] getReadLines(){
        return readText.toString().split("<td>");
    }

    void setDocumentList(){
        myDocList = new ArrayList<>();
        MyDoc myDoc;
        String name, path;

        for (int i = 4; i < readLines.length; i++) {
            if (readLines[i].contains("approved")) {
                name = trimName(readLines[i - 1]);
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

    String trimName(String p){
        return p.replaceAll("</td>", "");
    }

    String trimPath(String p){
        String[] splitText = p.split("[<>]");

        String front = "/help/en/";
        String pone = splitText[2].replaceAll(front, "");
        String back = ".html";

        return pone.replaceAll(back, "");
    }

    String trimPathTwo(String p){
        String[] splitText = p.split("/");
        return splitText[0];
    }

}
