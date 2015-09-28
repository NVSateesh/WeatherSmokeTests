package Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class ExcelReportTestNG {

	public void generateExcelReport(String destFileName)
			throws ParserConfigurationException, SAXException, IOException {

		String path = ExcelReportTestNG.class.getClassLoader()
				.getResource("./").getPath();
		path = path.replaceAll("bin", "src");
		System.out.println(path);

		File xmlFile = new File("test-output/testng-results.xml");
		System.out.println(xmlFile.isFile());

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();

		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		Document document = builder.parse(xmlFile);
		document.getDocumentElement().normalize();

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFCellStyle fail = workbook.createCellStyle();
		XSSFCellStyle pass = workbook.createCellStyle();
		
		XSSFSheet sheet = workbook.createSheet("TestCase_Report");
		XSSFRow row = sheet.createRow(0);
		
		XSSFCell cell = row.createCell(0);
		
		cell.setCellValue("Test Case Title");
		
		cell = row.createCell(1);
		
		cell.setCellValue("Status");
		
		cell = row.createCell(2);
		
		cell.setCellValue("Error/Exception Message");

		org.w3c.dom.NodeList test_list = document.getElementsByTagName("test");
		for (int i = 0; i < test_list.getLength(); i++) {
			Node test_node = test_list.item(i);

			int r = 0;
			String test_name = ((Element) (test_node)).getAttribute("name");
			
			//XSSFSheet sheet = workbook.createSheet(test_name);

			NodeList node_class = ((Element) (test_node))
					.getElementsByTagName("class");

			for (int j = 0; j < node_class.getLength(); j++) {
				Node class_node = node_class.item(j);

				String class_name = ((Element) (class_node))
						.getAttribute("name");
				NodeList test_method_list = ((Element) (class_node))
						.getElementsByTagName("test-method");

				for (int k = 0; k < test_method_list.getLength(); k++) {
					Node test_method_node = test_method_list.item(k);
					String test_method_name = ((Element) (test_method_node))
							.getAttribute("name");
					String test_method_status = ((Element) (test_method_node))
							.getAttribute("status");

				        sheet.createRow(r++);
					XSSFCell cell_name = row.createCell(0);
					cell_name.setCellValue(class_name + "." + test_method_name);

					XSSFCell cell_status = row.createCell(1);
					cell_status.setCellValue(test_method_status);

					XSSFCell cell_exp;
					String exp_desc;

					fail.setFillForegroundColor(HSSFColor.RED.index);
					pass.setFillForegroundColor(HSSFColor.GREEN.index);

					fail.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
					pass.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

					if ("fail".equalsIgnoreCase(test_method_status))
						cell_status.setCellStyle(fail);
					else
						cell_status.setCellStyle(pass);

					if ("fail".equalsIgnoreCase(test_method_status)) {

						cell_status.setCellStyle(fail);

						NodeList exp_list = ((Element) (test_method_node))
								.getElementsByTagName("exception");
						Node exp_node = exp_list.item(0);
						exp_desc = ((Element) (exp_node)).getAttribute("class");

						cell_exp = row.createCell(2);
						cell_exp.setCellValue(exp_desc);

					}

				}

			}
		}

		FileOutputStream outputStream = new FileOutputStream(new File(
				destFileName), true);
		workbook.write(outputStream);
		outputStream.close();
		System.out.println("Report generated");
	}

/*	@Test
	public static void test() {
*/

	public static void main(String[] args) {		
	
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String dateString = dateFormat.format(date);
		
		File file = new File("test-reports");
		if(!file.exists())
		 file.mkdirs();
		
		String fileName = "test-reports/report_"+dateString + ".xlsx";
		try {
			new ExcelReportTestNG().generateExcelReport(fileName);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}
}
