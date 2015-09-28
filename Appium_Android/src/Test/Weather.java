package Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Weather {

    
    public static void main(String[] args) throws InterruptedException, IOException
    {
	Weather.cap();
	
    }
    

public static void cap() throws InterruptedException, IOException {
	
	
	//Process p = Runtime.getRuntime().exec("\"C:/Program Files (x86)/Appium/node.exe\" \"C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js\" --no-reset --local-timezone");
	
	System.out.println("Starting the Appium Server through code");
	
	Process p = Runtime.getRuntime().exec("\"C:/Program Files (x86)/Appium/node.exe\" \"C:/Program Files (x86)/Appium/node_modules/appium/lib/appium.js\" --no-reset --local-timezone");

	System.out.println("AppiumServer is Started");
	
	Thread.sleep(1000);
	
	MobileDriver md;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	System.out.println("Strted");
	//capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
	capabilities.setCapability("appium-version", "1.0");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("platformVersion", "4.2.2");
	capabilities.setCapability("deviceName", "Samsung"); //Samsung
	capabilities.setCapability("app", "D:\\APK\\TWC.apk");
	capabilities.setCapability("appPackage", "com.weather.Weather");
	capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
	capabilities.setCapability("newCommandTimeout", 100000);
	/*Proxy proxy = new Proxy();
	proxy.setHttpProxy("192.168.1.166:8281");
	capabilities.setCapability(CapabilityType.PROXY, proxy);*/
	
	System.out.println("found");

	md = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	md.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
  //  md.findElement(By.id("android:id/button2")).click();

	
	Thread.sleep(10000);
	
	//Scroll
	WebElement Scroll_1 = md.findElement(By.id("com.weather.Weather:id/now_circle_include"));
	int topY = Scroll_1.getLocation().getY();
	int bottomY = topY + Scroll_1.getSize().getHeight();
	int centerX = Scroll_1.getLocation().getX() + (Scroll_1.getSize().getWidth() / 2);
	System.out.println("TopY :" + topY + "Bottom :" + bottomY + "center :" + centerX);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
    
    //Search Location
   /* 
    md.findElement(By.name("More options")).click();
	md.findElement(
		By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"))
		.click();
	String login = md
		.findElement(
			By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"))
		.getText();

	System.out.println("Login button : " + login);

	if (login.contains("Log In")) {

	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"))
		    .click();
	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]"))
		    .click();

	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]"))
		    .sendKeys("monocept123@gmail.com");
	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[2]"))
		    .click();
	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[2]"))
		    .sendKeys("password123");
	    md.navigate().back();
	    md.findElement(By.name("Twc Login Button")).click();
	    Thread.sleep(1000);
	    md.findElement(By.id("android:id/action_bar_title")).click();
	} else {
	    md.findElement(By.id("android:id/action_bar_title")).click();
	}

	md.findElement(By.id("com.weather.Weather:id/location_actionbar_row")).click();
	String City = md
		.findElement(
			By.xpath("// android.widget.FrameLayout[1]// android.widget.ListView[1]/ android.widget.LinearLayout[3]// android.widget.TextView[1]"))
		.getText();
	System.out.println(City);
	md.findElement(
		By.xpath("// android.widget.FrameLayout[1]// android.widget.ListView[1]/ android.widget.LinearLayout[3]// android.widget.TextView[1]"))
		.click();
*/
	
	
}


}
