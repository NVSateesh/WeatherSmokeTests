package Test;

import java.io.File;
import java.io.FileOutputStream;

import org.browsermob.core.har.Har;
import org.browsermob.proxy.ProxyServer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserMob {

    public static void main(String[] args) throws Exception {

	
	ProxyServer server = new ProxyServer(8899);
	server.start();
	server.setCaptureHeaders(true);
	server.setCaptureContent(true);
	// get the Selenium proxy object
	org.openqa.selenium.Proxy proxy = server.seleniumProxy();
	// configure it as a desired capability
	
	DesiredCapabilities capabilities = new DesiredCapabilities();

    // capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

	capabilities.setCapability(CapabilityType.PROXY, proxy);
	

	// start the browser up
	WebDriver driver = new FirefoxDriver(capabilities);

	server.newHar("bankrate");

	driver.get("http://www.bankrate.com"); //http://www.medscape.com/
	//driver.get("www.medscape.com");
	//http://www.weather.com/
	//driver.get("http://assertselenium.com/2012/10/30/transformation-from-manual-tester-to-a-selenium-webdriver-automation-specialist/");

	// get the HAR data
	Har har = server.getHar();
	String strFilePath = "D:\\Har\\gmf.har";
	FileOutputStream fos = new FileOutputStream(new File(strFilePath));
	har.writeTo(fos);
	server.stop();		
/*
	ProxyServer server = new ProxyServer(8281);
	server.start();
	server.setCaptureHeaders(true);
	server.setCaptureContent(true);

	org.openqa.selenium.Proxy proxy = server.seleniumProxy();
	String PROXY_HOST = "127.0.0.1";
	String proxyString = PROXY_HOST + ":" + 8281;
	proxy.setHttpProxy(proxyString);
	proxy.setSslProxy(proxyString);
	// configure it as a desired capability
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.PROXY, proxy);

	// start the browser up
	//WebDriver driver = new FirefoxDriver(capabilities);
	//WebDriver driver = null;
	System.out.println("mobile strted");


	server.newHar("Weather");

	Weather.cap();


	// get the HAR data
	Har har = server.getHar();
	String strFilePath = "D:\\Har\\weather.har";
	FileOutputStream fos = new FileOutputStream(new File(strFilePath));
	har.writeTo(fos);
	server.stop();		
*/

    }

}
