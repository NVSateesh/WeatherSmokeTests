package weather.testcases;

import java.io.BufferedReader;
import java.io.FileReader;

import weather.excel.ExcelData;
import weather.excel.WriteResultintoExcel;

public class VerifyDMA {

    public void verifyDMA() throws Exception {
	String[][] data = new String[10][10];
	ExcelData er = new ExcelData();
	data = er.excelread();

	String TestFile = "D:\\weather\\WeatherTest.txt";
	FileReader FR = new FileReader(TestFile);
	BufferedReader BR = new BufferedReader(FR);
	String Content = "";

	// Loop to read all lines one by one from file and print It.
	while ((Content = BR.readLine()) != null) {
	    System.out.println(Content);
	    System.out.println("Text lenth is: " + Content.charAt('&'));

	    // BR.close();
	    System.out.println("Index is :" + Content.indexOf("dma="));

	    // return mbrLastName;
	    String entriesTxt = Content;
	    String[] aEntriesText = entriesTxt.split("&");
	    String totalEntriesText = aEntriesText[aEntriesText.length - 1];
	    // return Integer.parseInt(totalEntriesText);
	    int totalLength = aEntriesText.length;

	    for (int i = 1; i <= totalLength; i++) {
		String FindText = aEntriesText[aEntriesText.length - i];
		// System.out.println("Lenth number is : "+(totalLength-i)+ ":"
		// + FindText);
		if (FindText.contains("dma")) {
		    String[] Value = FindText.split("=");
		    String ExactValue = Value[Value.length - 1];
		    System.out.println("The value is :" + ExactValue);
		    WriteResultintoExcel wResult = new WriteResultintoExcel();

		    if (ExactValue.contains(" ") || ExactValue.contains(data[4][7])) {
			System.out.println("NO Values found for dma");
			wResult.enterResult("TC", "Fail", ExactValue, 4, 7, 8);
		    } else

		    {
			System.out.println("dma vales is :" + FindText.contains(data[4][7]));
			System.out.println(FindText);
			wResult.enterResult("TC", "Pass", ExactValue, 4, 7, 8);
		    }
		    break;
		}
	    }

	    // System.out.println("Total Entries is :" +totalLength);

	}

	// System.out.println("Total Entries is :" +totalLength);

    }

}
