package weather.testcases;

import java.io.BufferedReader;
import java.io.FileReader;

import weather.excel.ExcelData;
import weather.excel.WriteResultintoExcel;

public class WeatherResult {

    public void result_weather(String param, int i, int j) throws Exception {
	String[][] data = new String[10][10];
	ExcelData er = new ExcelData();
	data = er.excelread();

	Thread.sleep(1000);
	String TestFile = "D:\\weather\\WeatherTest.txt";
	FileReader FR = new FileReader(TestFile);
	BufferedReader BR = new BufferedReader(FR);
	String Content = "";

	// Loop to read all lines one by one from file and print It.
	while ((Content = BR.readLine()) != null) {
	    System.out.println(Content);
	    System.out.println("Text lenth is: " + Content.charAt('&'));

	    // BR.close();
	    System.out.println("Index is :" + Content.indexOf(data[i][j] + "="));

	    // return mbrLastName;
	    String entriesTxt = Content;
	    String[] aEntriesText = entriesTxt.split("&");
	    String totalEntriesText = aEntriesText[aEntriesText.length - 1];
	    // return Integer.parseInt(totalEntriesText);
	    int totalLength = aEntriesText.length;

	    for (int x = 1; x <= totalLength; x++) {
		String FindText = aEntriesText[aEntriesText.length - x];
		// System.out.println("Lenth number is : "+(totalLength-i)+ ":"
		// + FindText);
		if (FindText.contains(data[i][j])) {
		    String[] Value = FindText.split("=");
		    String ExactValue = Value[Value.length - 1];
		    System.out.println("The value is :" + ExactValue);

		    // Enter Result
		    WriteResultintoExcel wResult = new WriteResultintoExcel();
		    int k = j + 1;
		    if (ExactValue.contains(param) || ExactValue.contains(data[i][j])) {

			System.out.println("NO Values found for :" + data[i][j]);

		    } else

		    {
			System.out.println("ord vales is :" + FindText.contains(data[i][j]));
			System.out.println(FindText);

		    }

		}
	    }

	}

    }

}
