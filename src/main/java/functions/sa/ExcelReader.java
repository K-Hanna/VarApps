package functions.sa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelReader {

    private List<String> cells;
    private List<MyDoc> myDocList;

    ExcelReader(String path) throws IOException {
        setCells(path);
        setDocumentList();
    }

    void setCells(String path) throws IOException {
        File excelFile = new File(path);
        FileInputStream fis = new FileInputStream(excelFile);

        cells = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cells.add(cell.toString());
            }
        }

        workbook.close();
        fis.close();

    }

    void setDocumentList(){
        myDocList = new ArrayList<>();
        MyDoc myDoc;
        String name, path = "";

        for (String cell : cells) {
            if (cell.contains("dam")){
                path = cell;
            }
            if(cell.contains("png") || cell.contains("jpg") || cell.contains("svg")){
                name = cell;
                myDoc = new MyDoc(name, path);
                myDocList.add(myDoc);
            }
        }
    }

    List<MyDoc> getMyDocList(){
        return myDocList;
    }
}