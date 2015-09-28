package weather.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class CellToString {

    public static String ctos(HSSFCell cell) throws Exception {
	int Type;
	Object re;
	Type = cell.getCellType();

	switch (Type) {
	case 0:
	    re = cell.getNumericCellValue();
	    break;
	case 1:
	    re = cell.getStringCellValue();
	    break;
	default:
	    throw new RuntimeException("This is not supported value");

	}
	return re.toString();

    }
}
