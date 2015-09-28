package weatherchannel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class testJson {
	public static String zipCode = null;
	public  static boolean equalLists(List<String> one, List<String> two){     
	    if (one == null && two == null){
	        return true;
	    }

	    if((one == null && two != null) 
	      || one != null && two == null
	      || one.size() != two.size()){
	        return false;
	    }

	    //to avoid messing the order of the lists we will use a copy
	    //as noted in comments by A. R. S.
	    one = new ArrayList<String>(one); 
	    two = new ArrayList<String>(two);   

	    Collections.sort(one);
	    Collections.sort(two);      
	    return one.equals(two);
	}
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ParseException {
		JSONParser parser = new JSONParser();
		/* try { */
		

		Object obj = parser.parse(new FileReader("D:\\weather\\wfx.json"));
		JSONObject jsonObject = (JSONObject) obj;
		 List<String> firstFileSegmentList = fisrtjson(jsonObject);
		 
		 
		 
		obj = parser.parse(new FileReader("D:\\weather\\Verify_wfx1.json"));
		jsonObject = (JSONObject) obj;
		List<String> secondFilSegmentList = fisrtjson(jsonObject);
		
		System.out.println("------------------------------------------------");
		 System.out.println("FistFileSegemtnList : "+firstFileSegmentList);
		System.out.println("secondFilSegmentList : "+secondFilSegmentList);
		
		boolean flag = equalLists(firstFileSegmentList,secondFilSegmentList);
		System.out.println("The Test result is : "+ flag);
	}

	public static  List<String> fisrtjson(JSONObject jsonObject) {
		 List<String> segmentList = new ArrayList<String>();

		JSONObject mainTag = (JSONObject) jsonObject.get("wfxtg");
		System.out.println("Main Tag is :"+ mainTag);
		JSONArray scatterSegs = (JSONArray) mainTag.get("scatterSegs");
		System.out.println("scatterSegs::" + scatterSegs);

		Iterator<JSONObject> iterator = scatterSegs.iterator();
		while (iterator.hasNext()) {

			JSONObject zipMainJsonObject = (JSONObject) iterator.next();
		//	System.out.println("zip main json : " + zipMainJsonObject);
			JSONArray zcszipJson = (JSONArray) zipMainJsonObject.get("zcs");
			System.out.println("zcszipJson is :: "+zcszipJson);
			/*
			 * JSONArray hzcszipJson = (JSONArray)
			 * zipMainJsonObject.get("hzcs"); JSONArray nzcszipJson =
			 * (JSONArray) zipMainJsonObject.get("nzcs");
			 */

			if (zcszipJson != null) {
				Iterator<JSONObject> zcszipIterator = zcszipJson.iterator();
				while (zcszipIterator.hasNext()) {
					JSONObject zcszipObject = (JSONObject) zcszipIterator
							.next();
					System.out.println("zip object : " + zcszipObject);
					if(zipCode == null){
						zipCode = zcszipObject.get("zip").toString(); 
						JSONArray segmentJsonArray = (JSONArray) zcszipObject
								.get("segments");
						System.out.println(zipCode + " zip code segemtn list : " + segmentJsonArray);
						segmentList.addAll(
								segmentJsonArray.subList(0, segmentJsonArray.size()));	
						break;
					}else 
					
					if(zipCode != null){
						System.out.println("zip codes count is :"+zcszipObject);
						System.out.println("look zipcodes ::::"+zcszipObject.get("zip").toString());
						if(zipCode.equals(zcszipObject.get("zip").toString())){
							//System.out.println("firstfile zip code : "+zipCode + "-----------------"+zcszipObject.get("zip").toString());
							JSONArray segmentJsonArray = (JSONArray) zcszipObject
									.get("segments");
							System.out.println("segemtn list : " + segmentJsonArray);
							System.out.println("firstfile zip code : "+zipCode + "-----------------"+zcszipObject.get("zip").toString());
							segmentList.addAll(
									segmentJsonArray.subList(0, segmentJsonArray.size()));	
							break;
						}
					}					
				}
			}
			
		}

		return segmentList;
	
	}
}



// long age = (Long) jsonObject.get("age");
// System.out.println(age);
//
// // loop array
// JSONArray msg = (JSONArray) jsonObject.get("messages");
// Iterator<String> iterator = msg.iterator();
// while (iterator.hasNext()) {
// System.out.println(iterator.next());
// }

/*
 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
 * e) { e.printStackTrace(); } catch (ParseException e) { e.printStackTrace();
 * }}}}
 */

