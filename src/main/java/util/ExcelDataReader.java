package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

    private String filePath;
    private int sheetIndex;

    public ExcelDataReader(String filePath,int sheetIndex){
        this.filePath = filePath;
        this.sheetIndex = sheetIndex;
    }

    private XSSFSheet getSheet() {
        FileInputStream fis;
        XSSFWorkbook workbook;
        XSSFSheet sheet = null;
        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(sheetIndex);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sheet;
    }


    public Map<String, Map<String,String>> getExcelAsMap() {

        Map<String, Map<String,String>> completeSheetData=null;

        try {
            XSSFSheet sheet = getSheet();
            completeSheetData = new HashMap<String, Map<String,String>>();
            List<String> columnHeader = new ArrayList<String>();

            Row row = sheet.getRow(0);
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()) {
                columnHeader.add(cellIterator.next().getStringCellValue());
            }

            int rowCount = sheet.getLastRowNum();
            int columnCount = row.getLastCellNum();

            for(int i=1;i<=rowCount;i++) {
                Map<String,String> singleRowData = new HashMap<String,String>();
                Row row1 = sheet.getRow(i);
                for(int j=0;j<columnCount;j++) {
                    Cell cell = row1.getCell(j);
                    singleRowData.put(columnHeader.get(j),getCellValueAsString(cell));
                }

                completeSheetData.put(String.valueOf(i), singleRowData);
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return completeSheetData;

    }

    public String getCellValueAsString(Cell cell) {
        String cellValue = null;

        switch(cell.getCellType()){
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = cell.getCellFormula();
            case BLANK:
                cellValue = "BLANK";
                break;
            default:
                cellValue = "DEFAULT";

        }

        return cellValue;

    }

    public String getSheetName(int index) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        String sheet = workbook.getSheetName(index);
        return sheet;
    }
    public int getSheetCount() throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        int sheetCount = workbook.getNumberOfSheets();
        return sheetCount;
    }
    public int totolColumnCount() throws IOException {
        XSSFSheet sheet = getSheet();
        Row row = sheet.getRow(0);
        int lastColumnNum = row.getLastCellNum();
        return lastColumnNum;
    }

}
