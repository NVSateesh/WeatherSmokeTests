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

public class nzcs {
	public static String id ;
	public static String id1;
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
		Object obj = parser.parse(new FileReader("D:\\weather\\Lotame.json"));
		JSONObject jsonObject = (JSONObject) obj;
		List<String> AudienciesList = fisrtjson(jsonObject);
		//List<String> TestFileSegmentList = test(jsonObject);

	}
	public static  List<String> fisrtjson(JSONObject jsonObject) throws FileNotFoundException, IOException, ParseException {
		List<String> abbrList = new ArrayList<String>();

		List<String> abbrList1 = new ArrayList<String>();


		//main tags
		JSONObject ProfileTag = (JSONObject) jsonObject.get("Profile");

		System.out.println("Main Tag Size is :"+ ProfileTag.size());

		JSONObject AudiencesTag = (JSONObject) ProfileTag.get("Audiences");

		System.out.println("Main Tag is :"+ AudiencesTag);

		JSONArray Audiences = (JSONArray) AudiencesTag.get("Audience");

		System.out.println("Audiences Size :" + Audiences.size());

		Iterator<JSONObject> iterator = Audiences.iterator();
		while (iterator.hasNext()) {

			JSONObject AudienceJsonObject = (JSONObject) iterator.next();
			//	System.out.println("zip main json : " + zipMainJsonObject);
			JSONArray AudienceJson = (JSONArray) AudienceJsonObject.get("id");
			//System.out.println("zcszipJson is :: "+zcszipJson);
		
			if (AudienceJson != null) {
				Iterator<JSONObject> AudienceIterator = AudienceJson.iterator();
				while (AudienceIterator.hasNext()) {
					JSONObject AudienceObject = (JSONObject)AudienceIterator
							.next();
					//System.out.println("zip object : " + zcszipObject);
					id = AudienceObject.get("id").toString(); 
		
					if(id != null){
						JSONArray AudienceJsonArray = (JSONArray) AudienceObject
								.get("segments");
						//	System.out.println(zipCode + " zip code segemtn list : " + segmentJsonArray);
						abbrList.addAll(
								AudienceJsonArray.subList(0,AudienceJsonArray.size()));
		

		Object obj1 = parser.parse(new FileReader("D:\\weather\\Lotame_charles.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		JSONObject AudiencesTag1 = (JSONObject) jsonObject1.get("Audiences");
		//JSONArray Audiences1 = (JSONArray) AudiencesTag1.get("Audience");

		JSONArray Audiences1 = (JSONArray) AudiencesTag1.get("Audience");
		System.out.println("Audiences 1 :" +Audiences1 );
		System.out.println("Audiences1 Size :" + Audiences.size());
		
		Iterator<JSONObject> iterator1 = Audiences1.iterator();
		while (iterator1.hasNext()) {

			JSONObject AudienceJsonObject1 = (JSONObject) iterator1.next();
			//	System.out.println("zip main json : " + zipMainJsonObject);
			JSONArray AudienceJson1 = (JSONArray) AudienceJsonObject1.get("id");
			
			if (id1 != null) {
				Iterator<JSONObject> AudienceIterator1 = AudienceJson1.iterator();
				while (AudienceIterator1.hasNext()) {
					JSONObject AudienceObject1 = (JSONObject) AudienceIterator1
							.next();
					//System.out.println("zip1 object : " + zcszipObject1);
					id1 = AudienceObject1.get("id").toString();
					//System.out.println("zipCode1 is :" + zipCode1);  


					if(id1.equals(id))
					{
						JSONArray AudienceJsonArray1 = (JSONArray) AudienceObject1
								.get("arrb");
						//System.out.println(zipCode1 + " zip code segemtn list : " + segmentJsonArray1);
						abbrList1.addAll(
								AudienceJsonArray1.subList(0, AudienceJsonArray1.size()));

						//System.out.println("first zipcode is :" + zipCode + "Second zip is :" + zipCode1);
						AudienceJsonArray1.equals(abbrList);
		
						System.out.println("------------------------------------------------");
						System.out.println("FistFileSegemtnList : "+id   +"----"+ AudienceJsonArray);
						System.out.println("secondFilSegmentList : "+id1 +"----"+ AudienceJsonArray1);

						boolean flag = equalLists(AudienceJsonArray,AudienceJsonArray1);
						System.out.println("The Test result is : "+ flag);
						Assert.assertTrue(flag);
						System.out.println("Passed");
						break;

					}	
				}
			}
		}					
	}

}
}
}
return Audiences;
		
	}
		
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for(int j=0;j< Audiences1.size();j++)
		{

			Object Aud1 = Audiences1.get(j);
			//System.out.println("Aud1 :" + Aud1 );
			abbrList1.addAll(Audiences1.subList(j, Audiences1.size()));
			//System.out.println("abbrList1 :"+abbrList1);
			for(int i =0;i<Audiences.size();i++)
			{

				Object Aud = Audiences.get(i);
				//System.out.println("Audiences is : "+ Aud);
				abbrList.addAll(Audiences.subList(i, Audiences.size()));
				//System.out.println("abbrList :"+abbrList);
				
			
			if(Aud1.equals(Aud))
			{
				System.out.println("------------------------------------------------");
				System.out.println("First Audiences : "+Aud1.toString());
				System.out.println("Second Audiences: "+ Aud.toString());

				boolean flag = equalLists(Aud.toString(),Aud1.toString());
				//System.out.println(abbrList +" ---"+abbrList1);
				System.out.println("The Test result is : "+ flag);
				Assert.assertTrue(flag);
				System.out.println("Passed");
				
			}
		}


		}
		return Audiences;
*/

	


	









