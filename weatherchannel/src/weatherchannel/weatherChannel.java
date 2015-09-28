package weatherchannel;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class weatherChannel {
	
	public static <ScrollView> void main(String[] args) throws Exception{
		
		MobileDriver md ;
		
		//Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		System.out.println("Strted");
		//capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0");
		capabilities.setCapability("deviceName", "Nexus4");
		capabilities.setCapability("app", "D:\\APK\\TWC.apk");
		capabilities.setCapability("appPackage", "com.weather.Weather");
		capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		capabilities.setCapability("newCommandTimeout", 100000);
		
		/*
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("192.168.1.91:8888");
		capabilities.setCapability(CapabilityType.PROXY, proxy);*/
		
		md = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		md.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		System.out.println("found");
		
		//Thread.sleep(1000);
		 md.findElement(By.name("More options")).click();
			md.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();
			String login= md.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).getText();
			
			 System.out.println("Login button : " + login);
			 
			if (login.contains("Log In")){
				
			md.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();
			md.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")).click();
			
			md.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")).sendKeys("monocept123@gmail.com");
			md.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[2]")).click();
			md.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[2]")).sendKeys("password123");
			md.navigate().back();
			md.findElement(By.name("Twc Login Button")).click();
			Thread.sleep(1000);
			md.findElement(By.id("android:id/action_bar_title")).click();
			}else
			{
				md.findElement(By.id("android:id/action_bar_title")).click();
			}
		
			md.findElement(By.id("com.weather.Weather:id/location_actionbar_row")).click();
			String City =md.findElement(By.xpath("// android.widget.FrameLayout[1]// android.widget.ListView[1]/ android.widget.LinearLayout[3]// android.widget.TextView[1]")).getText();
			System.out.println(City);
			md.findElement(By.xpath("// android.widget.FrameLayout[1]// android.widget.ListView[1]/ android.widget.LinearLayout[3]// android.widget.TextView[1]")).click();
			
		
		
		
		
	/*	
		
		driver.findElement(By.id("com.weather.Weather:id/search")).click();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.findElement(By.id("com.weather.Weather:id/search")).sendKeys("55409");
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//SearchAutoComplete[@id='search_src_text']")).click();
		String searchCityTextBox = driver.findElement(By.xpath("//SearchAutoComplete[@id='search_src_text']")).getText();
		System.out.println("City :" + searchCityTextBox);
		
		
		//WebElement Scroll_1=driver.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]"));
		WebElement Scroll_1=driver.findElement(By.id("com.weather.Weather:id/now_circle_include"));
		        int topY = Scroll_1.getLocation().getY();
			    int bottomY = topY + Scroll_1.getSize().getHeight();
			    int centerX = Scroll_1.getLocation().getX() + (Scroll_1.getSize().getWidth()/2);
			    System.out.println("TopY :"+topY+ "Bottom :"+ bottomY + "center :"+centerX);
			    driver.swipe(centerX, bottomY, centerX, topY, 10000);
			    driver.swipe(centerX, bottomY, centerX, topY, 10000);
			    driver.swipe(centerX, bottomY, centerX, topY, 10000);*/
		
		
		
		
		
		
		
		
		/*String Scroll_1=driver.findElement(By.id("com.weather.Weather:id/hilo")).getText();
		driver.scrollTo(Scroll_1);
		
		String element1 = driver.findElement(By.id("com.weather.Weather:id/tenday_title")).getText();
		if(element1.contains(" ")){
			System.out.println("Element is Present");
			}else{
			driver.scrollToExact(element1);
			driver.close();
			//driver.quit();
			}*/
	
			
	
			
		
	    
		
		
	
		
		
		/*.wait(5000);
		driver.close();

		String element1 = driver.findElement(By.id("com.weather.Weather:id/tenday_title")).getText();
		driver.scrollToExact(element1);
		driver.close();*/
		/*driver.tap(739, 500,0,0);
		 *
		driver.swipe(1011, 600, 400, 400,1000);*/
		
		
		
		
		
		/*driver.findElement(By.id("com.weather.Weather:id/search")).click();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.findElement(By.id("com.weather.Weather:id/search")).sendKeys("10016");
		driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
		
		//WebElement xyz = driver.findElement(By.className("android.widget.LinearLayout[index=1"));
		WebElement element = driver.findElement(By.id("android:id/search_src_text"));
		Point point = element.getLocation();
		Dimension size = element.getSize();
		System.out.println("Point is:" + point + "," +"Size is :"+ size);
		int x=380;
		int y= 265;
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

		driver.tap(1, x , y , 1000);
		
		
		System.out.println("Finished");
		 List<WebElement> s=driver.findElements(By.id("android:id/search_src_text"));
		 //android.widget.SearchView
		 for (WebElement webElement : s) {
			 System.out.println("List of elements" +webElement.getText() );
		}*/
		
		/*String Scroll_1=driver.findElement(By.id("com.weather.Weather:id/hilo")).getText();
				System.out.println("Scroll poin is : " +Scroll_1);*/
				//driver.scrollTo(Scroll_1);
				//driver.scrollToExact("com.weather.Weather:id/wind");
		//String Scroll_1=driver.findElement(By.id("com.weather.Weather:id/tenday_title")).getText();
		/*driver.scrollTo("com.weather.Weather:id/tenday_title");
		driver.close();*/
	 /*  Thread.sleep(500);
		WebElement scroll = driver.findElement(By.id("com.weather.Weather:id/now_circle_include"));
		
	     scroll.sendKeys(Keys.PAGE_DOWN);*/
		//System.out.println("Swipe completed");
		//Actions act = new Actions(driver);
		//act.

		 

		//driver.findElement(By.id("android:id/search_src_text[1]")).click();
		
		//Thread.sleep(3000);
		
		/*driver.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.view.View[1]/android.widget.LinearLayout[2]/android.widget.Spinner[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();
		driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();*/
		
		
		//driver.close();
		//md.quit();
		
		
		
		
		
		
		
		
	}

	
	
}
