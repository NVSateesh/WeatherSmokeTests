package weatherchannel;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class readfactual {
	public static String zipCode = null;
	public static String zipCode1 = null;
	public static JSONParser parser = new JSONParser();

	public  static boolean equalLists(List<String> one, List<String> two){     
		if (one == null && two == null){
			return true;
		}

		if((one == null && two != null) 
				|| one != null && two == null
				|| one.size() != two.size()){
			return false;
		}


		one = new ArrayList<String>(one); 
		two = new ArrayList<String>(two);   

		Collections.sort(one);
		Collections.sort(two);      
		return one.equals(two);
	}

	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException, ParseException {

		//JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("D:\\weather\\wfx.json"));
		JSONObject jsonObject = (JSONObject) obj;
		List<String> firstFileSegmentList = fisrtjson(jsonObject);
		
		
	}
	public static  List<String> fisrtjson(JSONObject jsonObject) throws FileNotFoundException, IOException, ParseException {
		List<String> segmentList = new ArrayList<String>();

		List<String> segmentList1 = new ArrayList<String>();


		//main tags
		JSONObject mainTag = (JSONObject) jsonObject.get("wfxtg");
		//System.out.println("Main Tag is :"+ mainTag);
		//System.out.println("Main Tag Size is :"+ mainTag.size());
		//scatterSegs
		JSONArray scatterSegs = (JSONArray) mainTag.get("scatterSegs");
		//System.out.println("scatterSegs::" + scatterSegs);

		Iterator<JSONObject> iterator = scatterSegs.iterator();
		while (iterator.hasNext()) {

			JSONObject zipMainJsonObject = (JSONObject) iterator.next();
			//	System.out.println("zip main json : " + zipMainJsonObject);
			JSONArray zcszipJson = (JSONArray) zipMainJsonObject.get("zcs");
			//System.out.println("zcszipJson is :: "+zcszipJson);



			if (zcszipJson != null) {
				Iterator<JSONObject> zcszipIterator = zcszipJson.iterator();
				while (zcszipIterator.hasNext()) {
					JSONObject zcszipObject = (JSONObject) zcszipIterator
							.next();
					//System.out.println("zip object : " + zcszipObject);
					zipCode = zcszipObject.get("zip").toString(); 
					//System.out.println("zipCode is :" + zipCode);  
					//System.out.println("Sie is"+	scatterSegs.size());

					//System.out.println("Zipcode is "+zipCode);



					if(zipCode != null){
						JSONArray segmentJsonArray = (JSONArray) zcszipObject
								.get("segments");
						//	System.out.println(zipCode + " zip code segemtn list : " + segmentJsonArray);
						segmentList.addAll(
								segmentJsonArray.subList(0, segmentJsonArray.size()));



						//Second
						Object obj1 = parser.parse(new FileReader("D:\\weather\\Verify_wfx.json"));
						JSONObject jsonObject1 = (JSONObject) obj1;
						JSONObject mainTag1 = (JSONObject) jsonObject1.get("wfxtg");
						//System.out.println("Main Tag 1 is :"+ mainTag1);

						JSONArray scatterSegs1 = (JSONArray) mainTag1.get("scatterSegs");
						//System.out.println("scatterSegs 1::" + scatterSegs1);
						Iterator<JSONObject> iterator1 = scatterSegs1.iterator();
						while (iterator1.hasNext()) {

							JSONObject zipMainJsonObject1 = (JSONObject) iterator1.next();
							//	System.out.println("zip main json : " + zipMainJsonObject);
							JSONArray zcszipJson1 = (JSONArray) zipMainJsonObject1.get("zcs");
							//System.out.println("zcszipJson is :: "+zcszipJson);

							if (zcszipJson1 != null) {
								Iterator<JSONObject> zcszipIterator1 = zcszipJson1.iterator();
								while (zcszipIterator1.hasNext()) {
									JSONObject zcszipObject1 = (JSONObject) zcszipIterator1
											.next();
									//System.out.println("zip1 object : " + zcszipObject1);
									zipCode1 = zcszipObject1.get("zip").toString();
									//System.out.println("zipCode1 is :" + zipCode1);  


									if(zipCode1.equals(zipCode))
									{
										JSONArray segmentJsonArray1 = (JSONArray) zcszipObject1
												.get("segments");
										//System.out.println(zipCode1 + " zip code segemtn list : " + segmentJsonArray1);
										segmentList1.addAll(
												segmentJsonArray1.subList(0, segmentJsonArray1.size()));

										//System.out.println("first zipcode is :" + zipCode + "Second zip is :" + zipCode1);
										segmentJsonArray1.equals(segmentList);

										//System.out.println("first sigments is :" + segmentJsonArray + "Second zip is :" +segmentJsonArray1);


										System.out.println("------------------------------------------------");
										System.out.println("FistFileSegemtnList : "+zipCode   +"----"+ segmentJsonArray);
										System.out.println("secondFilSegmentList : "+zipCode1 +"----"+ segmentJsonArray1);
                                       
										boolean flag = equalLists(segmentJsonArray,segmentJsonArray1);
										System.out.println("The Test result is : "+ flag);
										Assert.assertTrue(flag);
										
										break;

									}
									
								}
							}
						}					
					}

				}
			}
		}
		return scatterSegs;
		
	}


}









