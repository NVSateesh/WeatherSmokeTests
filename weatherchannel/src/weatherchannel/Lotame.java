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

public class Lotame {
	public static String id = null;
	public static String id1 = null;
	public static String abbr = null;
	public static String abbr1 = null;

	public static JSONParser parser = new JSONParser();

	public  static boolean equalLists(Object one, Object two){     
		if (one.equals(two)){
			return true;
		}

		if((one == null && two != null) 
				|| one != null && two == null
				){
			return false;
		}


		one = new Object(); 
		two = new Object();   


		return one.equals(two);
	}

	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException, ParseException {

		//JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("D:\\weather\\Lotame.json"));
		JSONObject jsonObject = (JSONObject) obj;
		List<String> firstFileSegmentList = fisrtjson(jsonObject);
		//List<String> TestFileSegmentList = test(jsonObject);

	}
	public static  List<String> fisrtjson(JSONObject jsonObject) throws FileNotFoundException, IOException, ParseException {
		List<String> segmentList = new ArrayList<String>();

		List<String> segmentList1 = new ArrayList<String>();


		//main tags
		//Object obj = parser.parse(new FileReader("D:\\weather\\Lotame_charles.json"));
		JSONObject mainTag = (JSONObject) jsonObject.get("Profile");
		JSONObject AudiencesTag = (JSONObject) mainTag.get("Audiences");
		JSONArray Audience = (JSONArray) AudiencesTag.get("Audience");

		//System.out.println("Audience" + Audience);
		
		
		//Iterator<JSONObject> AudienceIterator1 = Audience1.iterator();

		if (Audience != null) {
			//Getting id
			Iterator<JSONObject> AudienceIterator = Audience.iterator();
			while (AudienceIterator.hasNext()) {
				JSONObject AudienceObject = (JSONObject) AudienceIterator
						.next();
				//System.out.println("zip object : " + zcszipObject);
				id = AudienceObject.get("id").toString(); 
				//System.out.println("id is :"+id);

				//Getting abbr

				if(id != null){
                                         System.out.println("id is :"+id);
                                         
					//JSONObject abbrJSON = (JSONObject) AudienceObject.get("abbr");
					abbr = AudienceObject.get("abbr").toString(); 
				//	System.out.println("abbr is :"+abbr);
					
					
					
					//Compare Lotame
					Object obj1 = parser.parse(new FileReader("D:\\weather\\Lotame_charles.json"));
					JSONObject jsonObject1 = (JSONObject) obj1;
					JSONObject mainTag1 = (JSONObject) jsonObject1.get("Profile");
					JSONObject AudiencesTag1 = (JSONObject) mainTag1.get("Audiences");
					JSONArray Audience1 = (JSONArray) AudiencesTag1.get("Audience");
					//System.out.println("Audience1" + Audience1);
					
					//Iterator<JSONObject> AudienceIterator1 = Audience1.iterator();
					
					
					if (Audience1 != null) {
						//Getting id
						Iterator<JSONObject> AudienceIterator1 = Audience1.iterator();
						while (AudienceIterator1.hasNext()) {
							JSONObject AudienceObject1 = (JSONObject) AudienceIterator1
									.next();
							//System.out.println("zip object : " + zcszipObject);
							id1 = AudienceObject1.get("id").toString(); 
							//System.out.println("id1 is :"+id1);

							//Getting abbr
							
							if(id1.equals(id))
							{
								//JSONObject abbrJSON = (JSONObject) AudienceObject.get("abbr");
								abbr1 = AudienceObject1.get("abbr").toString(); 
								

								System.out.println("First   id " + id + "-----" + "First   abbr :" + abbr);
								System.out.println("compare id " + id1 + "-----" + "Compare abbr :" + abbr1);

								boolean flag = equalLists(abbr,abbr1);
								System.out.println("The Test result is : "+ flag);
								
								System.out.println(flag);
								Assert.assertTrue(flag);
								break;
								
							}

							}
						}
					}
				}

			}
		
		return Audience;

	}
}
