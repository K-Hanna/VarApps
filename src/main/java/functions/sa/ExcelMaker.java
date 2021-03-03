package functions.sa;

import  java.io.*;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMaker {

    private List<MyDoc> myDocList;
    private String name;
    private MyCellStyle settings;

    private XSSFWorkbook workbook;
    private CellRangeAddress cellAddresses;
    private XSSFCellStyle defaultStyle, boldStyle, blueStyle, blueTwoStyle;
    private XSSFSheet sheet1;

    public ExcelMaker(PDFReader pdf, String name) throws IOException {
        this.name = name;

        myDocList = pdf.getMyDocList();
        saveFile();
    }

    public ExcelMaker(ExcelReader excel, String name) throws IOException {
        this.name = name;

        myDocList = excel.getMyDocList();
        saveFile();
    }

    public ExcelMaker(HTMLReader html, String name) throws IOException {
        this.name = name;

        myDocList = html.getMyDocList();
        saveFile();
    }

    public void saveFile() throws IOException {
        String filename = name;
        settings = new MyCellStyle();
        workbook = new XSSFWorkbook();
        cellAddresses = new CellRangeAddress(1,1,2,5);
        defaultStyle = settings.getFontDefault(workbook);
        boldStyle = settings.getFontBold(workbook);
        blueStyle = settings.getFontBoldBlue(workbook);
        blueTwoStyle = settings.getFontBoldBlueTwo(workbook);
        sheet1 = workbook.createSheet("SUM");
        sheet1.addMergedRegion(cellAddresses);

        createSheetOne();
        createSheets();

        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    private void createSheetOne(){
        Row head1 = sheet1.createRow((short) 1);
        Cell cell = CellUtil.createCell(head1,2,"Approved");
        CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);
        settings.setMergedBorders(cellAddresses, sheet1);

        Row head2 = sheet1.createRow((short) 2);
        String[] texts = {"Locales:", "Project", "Simple", "Complex", "Estimation 2", "Estimation 1"};

        for(int i = 0; i < texts.length; i++){
            CellUtil.createCell(head2, i, texts[i], defaultStyle);
        }
    }

    private void createSheets(){
        int rows = 2;
        String oldPath = " ";
        XSSFSheet sheet = null;
        Row head, row1, row2;

        int i = 0;

        for(MyDoc doc : myDocList){
            int slash = doc.getPath().indexOf('/');
            String newPath = doc.getPath().substring(0, slash);

            if(!newPath.equals(oldPath)) {
                rows++;
                head = sheet1.createRow((short) rows);
                CellUtil.createCell(head, 0, "0", boldStyle);
                CellUtil.createCell(head, 1, newPath, boldStyle);

                for(int j = 2; j < 6; j++){
                    CellUtil.createCell(head, j, "", defaultStyle);
                }

                sheet = workbook.createSheet(newPath);
                sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));

                row1 = sheet.createRow((short) 0);
                CellUtil.createCell(row1, 0, "APPROVED", blueStyle);

                row2 = sheet.createRow((short) 1);
                String[] texts = {"Page", "image name", "Query", "Source Analysis", "Comment"};

                for (int j = 0; j < texts.length; j++) {
                    CellUtil.createCell(row2, j, texts[j], blueTwoStyle);
                }

                oldPath = newPath;
                i = 1;
            }

            Row row = Objects.requireNonNull(sheet).createRow((short) ++i);
            row.createCell(0).setCellValue(doc.getPath());
            row.createCell(1).setCellValue(doc.getName());
        }
    }
}