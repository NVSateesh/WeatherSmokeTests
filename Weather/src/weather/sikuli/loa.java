package weather.sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;

public class loa {
    
    public static Screen screen;
    
    public static void main(String[] args) {
	screen = new Screen();
	
	WebDriver driver = new FirefoxDriver();
	
	driver.get("http://loa.stage.a17.io/");
	//driver.manage().window().maximize();
	
	screen.type("images/Username.PNG", "Loa");
	

    }

}
