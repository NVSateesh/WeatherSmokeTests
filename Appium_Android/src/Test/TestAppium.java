
package Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

//import io.appium.java_client.android.AndroidDriver;

public class TestAppium {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Stopping the Appium Server");
		
		//Process r = Runtime.getRuntime().exec("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in (`netstat -nao ^| findstr /R /C:\"4723\"`) do (FOR /F \"usebackq\" %b in (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
		
		Process r = Runtime.getRuntime().exec("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in (`netstat -nao ^| findstr /R /C:\"4723\"`) do (FOR /F \"usebackq\" %b in (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
		
		System.out.println("Appium Server is stopped");
		
		Thread.sleep(20000);

		//Process p = Runtime.getRuntime().exec("\"C:/Appium/node.exe\" \"C:/Appium/node_modules/appium/bin/Appium.js\" --no-reset --local-timezone");

		System.out.println("Starting the Appium Server through code");
		
		//Process p = Runtime.getRuntime().exec("\"C:/Program Files (x86)/Appium/node.exe\" \"C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js\" --no-reset --local-timezone");
		
		Process p = Runtime.getRuntime().exec("\"C:/Program Files (x86)/Appium/node.exe\" \"C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js\" --no-reset --local-timezone");
						
		System.out.println("AppiumServer is Started");
		
		Thread.sleep(40000);
	
		AndroidDriver driver;

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("deviceName", "Samsung"); //Samsung
		capabilities.setCapability("app", "D:\\APK\\TWC.apk");
		capabilities.setCapability("appPackage", "com.weather.Weather");
		capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		capabilities.setCapability("newCommandTimeout", 100000);
				
		//c.setCapability("deviceName", "Samsung");
		//c.setCapability("deviceName", "SamsungGalaxyS5-4.4.4-API19-1080X1920");
		// c.setCapability("deviceName", "google_sdk"); //Android Emulator
		//c.setCapability("platformVersion", "4.2.2");
		/*
		 * c.setCapability("deviceName", "SM-G9201"); //SM-G9201 //Galaxy S6
		 * c.setCapability("platformVersion", "5.0.2");
		 */
		//c.setCapability("platformName", "Android");
		/*
		 * c.setCapability("appPackage", "com.flipkart.android");
		 * c.setCapability("appActivity", ".SplashActivity");
		 * c.setCapability("appWaitActivity", ".SplashActivity");
		 */// File f = new
			// File("C:\\Users\\Sateesh NV\\workspace4\\APPIUM\\FK_APK\\com.flipkart.android-3.4.0.5-APK4Fun.com.apk");
		//File f = new File("D:\\com.flipkart.android-3.4.0.4-APK4Fun.com.apk");
		//c.setCapability("app", f.getAbsolutePath());
		//c.setCapability("app","D:\\com.flipkart.android-3.4.0.4-APK4Fun.com.apk");

		//driver = new AndroidDriver(new URL("http://172.16.0.5:4723/wd/hub"), c);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

		Thread.sleep(1258);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(10000);

		System.out.println("The weather channel app is installed and runnning");
		
		Thread.sleep(40000);
		
		
		WebElement Scroll_1 = driver.findElement(By.id("com.weather.Weather:id/now_circle_include"));
		int topY = Scroll_1.getLocation().getY();
		int bottomY = topY + Scroll_1.getSize().getHeight();
		int centerX = Scroll_1.getLocation().getX() + (Scroll_1.getSize().getWidth() / 2);
		System.out.println("TopY :" + topY + "Bottom :" + bottomY + "center :" + centerX);
		driver.swipe(centerX, bottomY, centerX, topY, 10000);
		driver.swipe(centerX, bottomY, centerX, topY, 10000);
		
		
		// driver.findElement(By.xpath("//*[@class='android.widget.Button' and @index='4']")).click();

//		driver.findElement(By.id("com.flipkart.android:id/btn_skip")).click();

	//driver.close();

		System.out.println("Stopping the Appium Server");
		
		Process q = Runtime.getRuntime().exec("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in (`netstat -nao ^| findstr /R /C:\"4723\"`) do (FOR /F \"usebackq\" %b in (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
		
		System.out.println("Appium Server is stopped");
	}

}

