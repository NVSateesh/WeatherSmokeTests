package weather;

import weather.excel.ExcelData;

public class DataFromExcel {

    public void getExcelData() throws Exception {

	ExcelData ed = new ExcelData();
	ed.excelread();
    }

}
