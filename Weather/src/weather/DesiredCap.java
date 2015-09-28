package weather;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCap extends Driver {

    public void dcap() throws MalformedURLException {

	// MobileDriver driver;

	// Desired Capabilities
	DesiredCapabilities capabilities = new DesiredCapabilities();
	System.out.println("Strted");
	// capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
	capabilities.setCapability("appium-version", "1.0");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("platformVersion", "5.0");
	capabilities.setCapability("deviceName", "Samsung");
	capabilities.setCapability("app", "D:\\APK\\TWC.apk");
	capabilities.setCapability("appPackage", "com.weather.Weather");
	capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
	capabilities.setCapability("newCommandTimeout", 100000);
	Proxy proxy = new Proxy();
	proxy.setHttpProxy("192.168.1.91:8888");
	capabilities.setCapability(CapabilityType.PROXY, proxy);
	System.out.println("found");

	md = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	md.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

	/*
	 * md.findElement(By.id("com.weather.Weather:id/search")).click();
	 * md.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	 * md.findElement
	 * (By.id("com.weather.Weather:id/search")).sendKeys("55409");
	 * md.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	 * //WebElement xyz =
	 * driver.findElement(By.className("android.widget.LinearLayout[index=1"
	 * )); WebElement element =
	 * md.findElement(By.id("android:id/search_src_text")); Point point =
	 * element.getLocation(); Dimension size = element.getSize();
	 * System.out.println("Point is:" + point + "," +"Size is :"+ size);
	 * 
	 * int x=380; int y= 265; md.tap(1, x , y , 1000);
	 */

	// md.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

    }

}
