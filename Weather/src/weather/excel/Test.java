package weather.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class Test {

    public static void main(String[] args) {
	try {

	    FileInputStream file = new FileInputStream(new File("D:\\weather\\TC.xls"));
	    HSSFWorkbook workbook = new HSSFWorkbook(file);

	    HSSFSheet sheet = workbook.getSheet("TC");
	    int i = 1;
	    int j = 7;
	    int k = j + 1;
	    Cell searchText3 = sheet.getRow(i).getCell(j);
	    searchText3.setCellValue("Passed");

	    Cell searchText4 = sheet.getRow(i).getCell(k);
	    searchText4.setCellValue("nl");

	    file.close();

	    FileOutputStream outFile = new FileOutputStream(new File("D:\\weather\\TC.xls"));
	    workbook.write(outFile);
	    outFile.close();

	} catch (FileNotFoundException fnfe) {
	    fnfe.printStackTrace();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}
    }

}
