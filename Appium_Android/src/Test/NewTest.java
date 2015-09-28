package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
    
    WebDriver wd = new FirefoxDriver();
    
    @BeforeTest
    public void beforeTest() throws InterruptedException {
              wd.get("http://www.weather.com/");
              wd.manage().window().maximize();
              Thread.sleep(1000);
              System.out.println("Before Test is executed");
    }
    
    @BeforeMethod
    public void home() throws InterruptedException {
              String expected = "National and Local Weather Forecast, Hurricane, Radar and Report";
              String actual = wd.getTitle();  
              //System.out.println(actual);
              Thread.sleep(1000);
              Assert.assertEquals(actual, expected);
              System.out.println("BeforeMethod is executed");
              Thread.sleep(1000);
    }
    
    @Test(priority = 1)
    public void login() throws Exception {
	
	Thread.sleep(1000);
     //  wd.findElement(By.xpath("//div[@id='mini-panel-main_menu_mini_panel_resp']/div/div/div/div/div/div/nav/ul/li[2]/div/span")).click();
	wd.findElement(By.xpath("//a[@id='Live TV ']")).click(); ////a[@id='News']   
        System.out.println("Login link is clicked");
        Thread.sleep(1000);
    }
    
    @Test(priority = 2)
    public void register() throws Exception {
	Thread.sleep(1000);
        //wd.findElement(By.xpath("//div[@id='mini-panel-main_menu_mini_panel_resp']/div/div/div/div/div/div/nav/ul/li[2]/div/span[3]")).click();
	wd.findElement(By.xpath("//a[@id='News']")).click(); ////a[@id='News']
	System.out.println("Register link is clicked");
        Thread.sleep(1000);
    }
    
    @AfterMethod
    public void gohome() throws InterruptedException {
            wd.navigate().to("http://www.weather.com/");
            System.out.println("AfterMethod is executed");
            
    }

    @AfterTest
    public void afterTest() throws Exception {
        Thread.sleep(1000);
        wd.close();
        System.out.println("After Test is executed");
        
        
    }

}
