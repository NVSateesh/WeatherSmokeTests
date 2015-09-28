package weather.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class WriteResultintoExcel {

    public void enterResult(String sheetName, String Result, String Val, int rowIndex, int resultColIndex, int valueColIndex) {

	try {

	    FileInputStream file = new FileInputStream(new File("D:\\weather\\TestResults.xls"));
	    HSSFWorkbook workbook = new HSSFWorkbook(file);

	    HSSFSheet sheet = workbook.getSheet(sheetName);

	    Cell searchText3 = sheet.getRow(rowIndex).getCell(resultColIndex);
	    searchText3.setCellValue(Result);

	    Cell searchText4 = sheet.getRow(rowIndex).getCell(valueColIndex);
	    searchText4.setCellValue(Val);

	    file.close();

	    FileOutputStream outFile = new FileOutputStream(new File("D:\\weather\\TestResults.xls"));
	    workbook.write(outFile);
	    outFile.close();

	} catch (FileNotFoundException fnfe) {
	    fnfe.printStackTrace();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}
    }
}
