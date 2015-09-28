package weather.testcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import weather.excel.WriteResultintoExcel;

import com.google.common.base.Joiner;

/**
 * 
 * This class is used to validate the API :
 * 
 * @author naresh
 *
 */
public class LotameValidation {

    /**
     * 
     */
    public static String zipCode = null;

    /**
     * 
     */
    public static String ids = null;
    public static String id = null;
    public static List<String> container;
    public static List<String> datalist;

    /**
     * 
     * @param segmentJsonArray
     * @param container2
     * @return boolean
     */
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

    /**
     * 
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public void Lotame_validation() throws FileNotFoundException, IOException, ParseException {

	List<String> segmentList = new ArrayList<String>();
	// Data file
	String TestFile = "D:\\weather\\WeatherTest.txt";
	FileReader FR = new FileReader(TestFile);
	BufferedReader BR = new BufferedReader(FR);
	String Content = "";

	while ((Content = BR.readLine()) != null) {
	    System.out.println(Content);
	    // System.out.println("Text lenth is: "+Content.charAt('&'));

	    String str[] = Content.split("&");
	    for (String ssss : str) {
		String s[] = ssss.split("=");
		if (s[0].equals("sg")) {
		    ids = s[1].toString();
		    System.out.println("ids is :" + ids);
		    String[] items = ids.split(",");
		    container = Arrays.asList(items);
		    System.out.println("Container is:" + container);

		}

	    }

	    // Json file
	    JSONParser parser = new JSONParser();
	    Object obj = parser.parse(new FileReader("D:\\weather\\Lotame.json"));
	    JSONObject jsonObject = (JSONObject) obj;

	    JSONObject mainTag = (JSONObject) jsonObject.get("Profile");
	    JSONObject AudiencesTag = (JSONObject) mainTag.get("Audiences");
	    JSONArray Audience = (JSONArray) AudiencesTag.get("Audience");

	    if (Audience != null) {
		// Getting id
		Iterator<JSONObject> AudienceIterator = Audience.iterator();
		while (AudienceIterator.hasNext()) {
		    JSONObject AudienceObject = (JSONObject) AudienceIterator.next();
		    // System.out.println("zip object : " + zcszipObject);
		    id = AudienceObject.get("id").toString();
		    List<String> list = new ArrayList<String>();
		    for (String str1 : container) {
			if (ids.contains(str1)) {
			    list.add(str1);
			}

		    }

		    System.out.println("list is " + list);

		    System.out.println("segments :" + list);
		    System.out.println("Containe :" + container);

		    WriteResultintoExcel wResult = new WriteResultintoExcel();
		    boolean flag = equalLists(list, container);
		    String Res = String.valueOf(flag);
		    System.out.println("Lotame Result is :" + Res.toString());

		    if (Res.toString() == "true") {
			wResult.enterResult("Lotame", container.toString(), list.toString(), 4, 7, 8);
		    } else if (Res.toString() == "false") {
			wResult.enterResult("Lotame", container.toString(), list.toString(), 4, 7, 8);
		    }

		    System.out.println("Pass");
		    Assert.assertTrue(flag);
		    break;

		}

	    }
	}
    }
}
