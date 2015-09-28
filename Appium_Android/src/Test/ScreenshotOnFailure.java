package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ScreenshotOnFailure {
    
    
     WebDriver driver;
    
    
    @Test
    public void screenshotOnFailure()  throws Exception
    
    
    {
	driver = new FirefoxDriver();
	
	driver.get("http://www.medscape.com/");
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//driver.findElement(By.linkText("Register")).click();
	
        //TakeScreenshot.captureScreenshot(driver, "RegisterScreenshot");
	
	Thread.sleep(1000);
	
	driver.findElement(By.linkText("LogInvgvvb")).click();
	
	
    }

    @AfterMethod
    public void test (ITestResult result) throws Exception
    {
	
	System.out.println("getStatus : "+result.getStatus());
	
	System.out.println("getName : " + result.getName());
	
	if(ITestResult.FAILURE == result.getStatus())
	   
	{
	    
	    System.out.println("Unable to locate the element with provided attribute and taking screenshot for the same");
	    
	    System.out.println("------------------------");
	    
	    TakeScreenshot.captureScreenshot(driver, result.getName());
	    
	}
	driver.quit();
    }
}
