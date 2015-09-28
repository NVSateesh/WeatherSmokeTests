package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class TakeScreenshot {
    
  @Test
  public static void captureScreenshot(WebDriver driver, String screenshotName) throws Exception {
  
      //To give the suffix of the screenshot as Date and Time format [dd_MM_yyyy_hh_mm_ss]
        Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	String dateString = dateFormat.format(date);
	String suffix = "_"+dateString + ".PNG";
	
	File file = new File("Screenshots");
	if(!file.exists())
	{
	 file.mkdirs();
	}
      File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      
      FileUtils.copyFile(screenshot, new File("Screenshots/"+screenshotName+suffix));      
      
      System.out.println("Screenshot is taken");
      
      

      
  
  
  
  }
}
