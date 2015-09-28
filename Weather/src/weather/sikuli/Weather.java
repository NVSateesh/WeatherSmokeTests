package weather.sikuli;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Weather {

    public void weatherchannel() throws Exception {

	MobileDriver driver;

	// Desired Capabilities
	DesiredCapabilities capabilities = new DesiredCapabilities();
	System.out.println("Strted");
	// capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
	capabilities.setCapability("appium-version", "1.0");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("platformVersion", "5.0");
	capabilities.setCapability("deviceName", "Micromax");
	capabilities.setCapability("app", "D:\\sdk\\build-tools\\android-4.4\\TheWeatherChannel.apk");
	capabilities.setCapability("appPackage", "com.weather.Weather");
	capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
	System.out.println("found");

	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);

	driver.findElement(By.id("com.weather.Weather:id/splashImage")).click();

	driver.findElement(By.id("android:id/action_bar_title")).click();

	driver.findElement(By.id("com.weather.Weather:id/search")).click();

	// driver.close();
	// md.quit();

    }
}
