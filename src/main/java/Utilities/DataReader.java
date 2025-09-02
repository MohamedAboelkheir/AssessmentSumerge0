package Utilities;

import com.github.javafaker.service.FakeValuesGrouping;
import domain.SearchData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

public class DataReader {

    private static final String LOC= "src/main/resources/SearchData.xlsx";
   // public static List<SearchData> read() throws IOException {
   public static String read() throws IOException {

        /*
        FileInputStream excelFile = new FileInputStream(new File(LOC));
        XSSFWorkbook wb = new XSSFWorkbook(LOC);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rowCount; // number of rows of newly form excel files 
        rowCount = sheet.getPhysicalNumberOfRows();
        out.println(rowCount);

        //trying to iterate the excel file
        int i = 1;
        Iterator<Row> rowIterator = sheet.iterator();
        List<SearchData>ans= new LinkedList<>();
        do {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            List<String>column= new LinkedList<>();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 // to read the first column
                    DataFormatter df = new DataFormatter();
                    String str2 = df.formatCellValue(cell);
                    column.add(str2);

            }
            SearchData searchData = new SearchData();
            searchData.setLocation(column.get(0));
            searchData.setCheckInDate(column.get(1));
            searchData.setCheckOutDate(column.get(2));
            ans.add(searchData);

            ++i;
            if (i > rowCount) break;
            //break;
        } while (rowIterator.hasNext());
        wb.close();
        return ans;
        */
        XSSFWorkbook workBook;
        XSSFSheet sheet;

        String cellData;
        try {
            workBook = new XSSFWorkbook(LOC );

            sheet = workBook.getSheet("Sheet1");
            cellData = sheet.getRow(2).getCell(1).getStringCellValue();
            return cellData;
        } catch (Exception e) {
          //  LogsManager.error("Error reading excel file:", excelFilename, e.getMessage());
            return "";
        }

    }
}

