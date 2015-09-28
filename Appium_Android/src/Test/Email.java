package Test;

import java.util.concurrent.TimeUnit;

import junit.framework.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Email {

    
    public static void main(String[] args) throws Exception {
	
	 FirefoxProfile firefoxProfile = new FirefoxProfile();
         firefoxProfile.setPreference("reader.parse-on-load.enabled",false);
         WebDriver driver = new FirefoxDriver(firefoxProfile);
	
	/*System.setProperty("", "");
	
	WebDriver driver = new ChromeDriver();*/
	
	driver.manage().window().maximize();
	
	driver.get("https://mail.google.com");//https://accounts.google.com/
	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	Thread.sleep(1000);	
	
	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("sateesh.kumar.contractor@weather.com");
	
	driver.findElement(By.xpath("//input[@id='next']")).click();
	
	Thread.sleep(5000);	
	
	/*String altText = driver.findElement(By.xpath("//input[@id='next']")).getAttribute("alt");
	
	System.out.println(altText);*/
	//String expected = "The Weather Channel";
	
	//Assert.assertEquals(expected, altText);
	
	
	driver.findElement(By.xpath("//input[@id='user-signin']")).sendKeys("sateesh.kumar.contractor@weather.com");
		
	driver.findElement(By.xpath("//input[@id='pass-signin']")).sendKeys("10Welcome");
	
	driver.findElement(By.xpath("//input[@id='signin-button']")).click();
		
	Thread.sleep(10000);		
	
	String text = driver.findElement(By.xpath("//div[@id='gbq1']/div/a/span")).getText();
	
	System.out.println("Logo text" + text);
	
	//div[@class='T-I J-J5-Ji T-I-KE L3']  --  //div[@id=':d7']/div/div
	
	driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
	
	Thread.sleep(10000);
	
	String newMessageText = driver.findElement(By.xpath("//div[@id=':f6']/h2/div[2]")).getText();
	
	System.out.println("New MessageText is : " + newMessageText);	
	
	driver.findElement(By.name("subjectbox")).sendKeys("Subject");	//name=subjectbox ////div[@id=':ho']/input
	
	driver.findElement(By.xpath("//div[@id=':iv']/div")).sendKeys("Body message");
	
	
    }

}

