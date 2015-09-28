package weatherchannel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class zcs_wfx {

	public static boolean equalLists(List<String> segmentJsonArray,
			List<String> container2) {

		if (segmentJsonArray == null && container2 == null) {
			return true;
		}

		if ((segmentJsonArray == null && container2 != null)
				|| segmentJsonArray != null && container2 == null
				|| segmentJsonArray.size() != container2.size()) {
			return false;
		}

		return segmentJsonArray.equals(container2);

	}

	public static String zipCode = null;
	public static String zip = null;
	public static String seg = null;
	public static List<String> container;

	public static void main(String[] args) throws Exception {

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

				if (s[0].equals("nzcs")) {

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

				JSONArray zcszipJson = (JSONArray) zipMainJsonObject
						.get("nzcs");

				if (zcszipJson != null) {
					Iterator<JSONObject> zcszipIterator = zcszipJson.iterator();
					while (zcszipIterator.hasNext()) {
						JSONObject zcszipObject = (JSONObject) zcszipIterator
								.next();

						zipCode = zcszipObject.get("zip").toString();
						if (zipCode.contains(zip)) {
							System.out.println("zip is :" + zip);
							JSONArray segmentJsonArray = (JSONArray) zcszipObject
									.get("segments");
							System.out.println(zipCode
									+ " zip code segemtn list : "
									+ segmentJsonArray);
							
							

							segmentList.addAll(segmentJsonArray.subList(0,segmentJsonArray.size()));
							List<String> firstList = new ArrayList<String>();
							List<String> secondList = new ArrayList<String>();
							for (Object firstString : segmentList) {
								System.out.println("firstString: "
										+ firstString);
								firstList.add(firstString.toString().trim());
							}

							for (Object secondString : container) {
								System.out.println("secondString : "
										+ secondString);
								secondList.add(secondString.toString().trim());
							}
							System.out.println("segments :" + segmentList);
							System.out.println("Containe :" + container);

							boolean flag = equalLists(firstList, secondList);
							System.out.println("The Test result is : " + flag);

							break;
						}

					}
				}

			}

		}

	}
}
