package functions.sa;

import  java.io.*;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelMaker {

    private List<MyDoc> myDocList;
    private String name;

    ExcelMaker(PDFReader pdf, String name) throws IOException {
        this.name = name;

        myDocList = pdf.getMyDocList();
        saveFile();

    }

    ExcelMaker(ExcelReader excel, String name) throws IOException {
        this.name = name;

        myDocList = excel.getMyDocList();
        saveFile();
    }

    ExcelMaker(HTMLReader html, String name) throws IOException {
        this.name = name;

        myDocList = html.getMyDocList();
        saveFile();

    }

    void saveFile() throws IOException {
        String filename = name;
        XSSFWorkbook workbook = new XSSFWorkbook();

        //sheet 1
        XSSFSheet sheet1 = workbook.createSheet("sth");
        Row head1 = sheet1.createRow((short) 1);
        head1.createCell(2).setCellValue("Approved");
        Row head2 = sheet1.createRow((short) 2);
        head2.createCell(0).setCellValue("Locales");

        //other sheets

        int rows = 3;
        int s = myDocList.get(0).getPath().indexOf('/');
        String oldPath = myDocList.get(0).getPath().substring(0, s);

        Row head = sheet1.createRow((short) rows);
        head.createCell(0).setCellValue(oldPath);

        XSSFSheet sheet = workbook.createSheet(oldPath);

        Row row1 = sheet.createRow((short) 0);
        row1.createCell(0).setCellValue("Approved");
        Row row2 = sheet.createRow((short) 1);
        row2.createCell(0).setCellValue("Locales");

        int i = 1;

        for(MyDoc doc : myDocList){
            int slash = doc.getPath().indexOf('/');
            String newPath = doc.getPath().substring(0, slash);

            if(!newPath.equals(oldPath)) {
                rows++;
                head = sheet1.createRow((short) rows);
                head.createCell(0).setCellValue(newPath);
                head.createCell(1).setCellValue(newPath);

                sheet = workbook.createSheet(newPath);
                row1 = sheet.createRow((short) 0);
                row1.createCell(0).setCellValue("Approved");
                row2 = sheet.createRow((short) 1);
                row2.createCell(0).setCellValue("Locales");
                oldPath = newPath;
                i = 1;
            }

            Row row = sheet.createRow((short) ++i);
            row.createCell(0).setCellValue(doc.getPath());
            row.createCell(1).setCellValue(doc.getName());
        }

        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
