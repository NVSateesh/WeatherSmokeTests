package weather.testcases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import weather.excel.WriteResultintoExcel;

public class WfxRead {

    public static boolean equalLists(List<String> segmentJsonArray, List<String> container2) {

	if (segmentJsonArray == null && container2 == null) {
	    return true;
	}

	if ((segmentJsonArray == null && container2 != null) || segmentJsonArray != null && container2 == null
		|| segmentJsonArray.size() != container2.size()) {
	    return false;
	}

	return segmentJsonArray.equals(container2);

    }

    public static String zipCode = null;
    public static String zip = null;
    public static String seg = null;
    public static List<String> container;

    public static void wfxValidation(String type) throws Exception {

	// Data file
	String TestFile = "D:\\weather\\WeatherTest.txt";
	FileReader FR = new FileReader(TestFile);
	BufferedReader BR = new BufferedReader(FR);
	String Content = "";

	// Json file
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(new FileReader("D:\\weather\\wfx.json"));
	JSONObject jsonObject = (JSONObject) obj;

	List<String> segmentList = new ArrayList<String>();
	JSONObject mainTag = (JSONObject) jsonObject.get("wfxtg");

	JSONArray scatterSegs = (JSONArray) mainTag.get("scatterSegs");

	// Loop to read all lines one by one from file and print It.
	while ((Content = BR.readLine()) != null) {
	    System.out.println(Content);
	    // System.out.println("Text lenth is: "+Content.charAt('&'));

	    String str[] = Content.split("&");
	    for (String ssss : str) {
		String s[] = ssss.split("=");
		if (s[0].equals("zip")) {
		    zip = s[1].toString();
		    System.out.println("zip is :" + zip);

		}

		if (s[0].equals(type)) {

		    seg = s[1].toString();
		    String[] items = seg.split(",");
		    container = Arrays.asList(items);
		    System.out.println("Container is:" + container);
		}
	    }

	    // reading json

	    System.out.println("Seg " + seg);

	    Iterator<JSONObject> iterator = scatterSegs.iterator();
	    while (iterator.hasNext()) {

		JSONObject zipMainJsonObject = (JSONObject) iterator.next();

		JSONArray zcszipJson = (JSONArray) zipMainJsonObject.get(type);

		if (zcszipJson != null) {
		    Iterator<JSONObject> zcszipIterator = zcszipJson.iterator();
		    while (zcszipIterator.hasNext()) {
			JSONObject zcszipObject = (JSONObject) zcszipIterator.next();

			zipCode = zcszipObject.get("zip").toString();
			if (zipCode.contains(zip)) {
			    System.out.println("zip is :" + zip);
			    JSONArray segmentJsonArray = (JSONArray) zcszipObject.get("segments");
			    System.out.println(zipCode + " zip code segemtn list : " + segmentJsonArray);

			    segmentList.addAll(segmentJsonArray.subList(0, segmentJsonArray.size()));
			    List<String> firstList = new ArrayList<String>();
			    List<String> secondList = new ArrayList<String>();
			    for (Object firstString : segmentList) {
				System.out.println("firstString: " + firstString);
				firstList.add(firstString.toString().trim());
			    }

			    for (Object secondString : container) {
				System.out.println("secondString : " + secondString);
				secondList.add(secondString.toString().trim());
			    }
			    System.out.println("segments :" + segmentList);
			    System.out.println("Containe :" + container);

			    WriteResultintoExcel wResult = new WriteResultintoExcel();
			    boolean flag = equalLists(firstList, secondList);
			    String Res = String.valueOf(flag);
			    System.out.println("Lotame Result is :" + Res.toString());

			    if (type == "zcs") {
				wResult.enterResult("wfx", secondList.toString(), firstList.toString(), 4, 7, 8);
			    } else if (type == "nzcs") {
				wResult.enterResult("wfx", secondList.toString(), firstList.toString(), 5, 7, 8);
			    }

			    System.out.println(flag);
			    Assert.assertTrue(flag);
			    break;

			}

		    }
		}

	    }

	}

    }
}
