package weatherchannel;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;

public class readNotead {

	public static void main(String[] args) throws Exception {

		String TestFile = "D:\\weather\\WeatherTest.txt" ;
		FileReader FR = new FileReader(TestFile);
		BufferedReader BR = new BufferedReader(FR);
		String Content = "";
		
		
		//Loop to read all lines one by one from file and print It.
		while((Content = BR.readLine())!= null){
			System.out.println(Content);
			System.out.println("Text lenth is: "+Content.charAt('&'));
			
			String str[] = Content.split("&");
			for(String ssss: str){
				String s[] = ssss.split("=");
				if(s[0].equals("zip")){
					System.out.println(s[1]);
				}
			}
			
			//BR.close();
			System.out.println("Index is :"+Content.indexOf("zip="));
			
			

		     //return mbrLastName;
			String entriesTxt = Content;
			String[] aEntriesText = entriesTxt.split("&");
			String totalEntriesText = aEntriesText[aEntriesText.length-1];
			//return Integer.parseInt(totalEntriesText);
			int totalLength = aEntriesText.length;
			
			for(int i=1;i<=totalLength;i++)
			{
			String FindText = aEntriesText[aEntriesText.length-i];
			//System.out.println("Lenth number is : "+(totalLength-i)+ ":" + FindText);
			 if (FindText.contains("zip"))
			 {
			     String[] Value = FindText.split("=");
			     String ExactValue = Value[Value.length-1];
			     System.out.println("The value is :"+ ExactValue);
			     if(ExactValue.contains(" ")||ExactValue.contains("zip"))
			     {
			    	 System.out.println("NO Values found for ord");
			    	
			     }else
			    	 
			     {
			    	 System.out.println("ord vales is :"+FindText.contains("zip"));
						System.out.println(FindText);
			     }
			     break;
			 }
			}
			
			//System.out.println("Total Entries is :" +totalLength);
			

		}

	}
}
