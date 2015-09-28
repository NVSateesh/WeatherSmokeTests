package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTestNG1 {
    
  
    @Test(priority = 1)
    public void VerfyingTestCaseID_001() {
    System.out.println("1-Test");

    }

    @Test(priority = 2)
    public void VerfyingTestCaseID_002() {
	 System.out.println("2-Test");
    
    }

    @Test(priority = 3)
    public void VerfyingTestCaseID_003() {
	System.out.println("3-Test"); 
	}

    @Test(priority = 4)
    public void VerfyingTestCaseID_004() {
	System.out.println("4-Test");
    }

        
    
/*    @Test
    public void test() throws InterruptedException{
    WebDriver d = new FirefoxDriver();
    Thread.sleep(1000);
    d.get("http://medscape.com/");
    String x =d.getTitle();
    System.out.println(x);
    }
    

//    public static final String xlsx = null;


    
    
    WebDriver d = new FirefoxDriver();
    
  @BeforeTest
  public void beforeTest() throws InterruptedException {
            d.get("http://medscape.com/");
            d.manage().window().maximize();
            Thread.sleep(1000);
            System.out.println("Before Test is executed");
  }
  
  @BeforeMethod
  public void home() throws InterruptedException {
            //String expected = "Latest Medical News, Clinical Trials, Guidelines – Today on Medscape";
            String actual = d.getTitle();  
            System.out.println(actual);
            Thread.sleep(1000);
           // Assert.assertEquals(actual, expected);
            System.out.println("BeforeMethod is executed");
  }
  
  @Test(priority = 1)
  public void login() throws Exception {
      d.findElement(By.linkText("Log In")).click();
      System.out.println("Login link is clicked");
      Thread.sleep(1000);
  }
  
  @Test(priority = 2)
  public void register() throws Exception {
      d.findElement(By.linkText("Register")).click();
      System.out.println("Register link is clicked");
      Thread.sleep(1000);
  }
  
  @AfterMethod
  public void gohome() throws InterruptedException {
           d.findElement(By.xpath("//a[@id='ms_splogo']")).click();
  }

  @AfterTest
  public void afterTest() throws Exception {
      Thread.sleep(1000);
      d.close();
      System.out.println("After Test is executed");
      
      
  }*/

}
