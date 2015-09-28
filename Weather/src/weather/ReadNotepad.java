package weather;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadNotepad {

    public void read() throws Exception {

	String TestFile = "D:\\custparam.txt";
	FileReader FR = new FileReader(TestFile);
	BufferedReader BR = new BufferedReader(FR);
	String Content = "";

	// Loop to read all lines one by one from file and print It.
	while ((Content = BR.readLine()) != null) {
	    System.out.println(Content);
	    System.out.println("Text lenth is: " + Content.charAt('&'));

	    // BR.close();
	    System.out.println("Index is :" + Content.indexOf("ord="));

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
		if (FindText.contains("ord")) {
		    String[] Value = FindText.split("=");
		    String ExactValue = Value[Value.length - 1];
		    System.out.println("The value is :" + ExactValue);
		    if (ExactValue.contains("nl") || ExactValue.contains("ord")) {
			System.out.println("NO Values found for ord");

		    } else

		    {
			System.out.println("ord vales is :" + FindText.contains("ord"));
			System.out.println(FindText);
		    }

		}
	    }

	    // System.out.println("Total Entries is :" +totalLength);

	}

    }
}
