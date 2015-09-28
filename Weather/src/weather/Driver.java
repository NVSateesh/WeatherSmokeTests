package weather;

import io.appium.java_client.MobileDriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

public class Driver {

    protected static MobileDriver md;

    public void Dr() {
	md = null;

    }

    public boolean isElementPresent(By by) {
	try {
	    md.findElement(by);
	    return true;
	} catch (NoSuchElementException e) {
	    return false;
	}
    }

}
