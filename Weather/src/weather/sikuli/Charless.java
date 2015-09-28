package weather.sikuli;

import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import weatherchannel.weather;

public class Charless {

    public Screen screen;

    @BeforeTest
    public void tesSikuli() throws Exception {
	// open note pad application
	screen = new Screen();

	App.open("C:\\Program Files\\Charles\\Charles.exe");
	// App.open("C:\\Program Files (x86)\\Fiddler2\\Fiddler.exe");
	Thread.sleep(15000);

    }

    @Test(priority = 1)
    public void test() throws Exception {

	Weather wc = new Weather();
	wc.weatherchannel();
	Thread.sleep(50000);

    }

    @AfterTest
    public void check() throws Exception {

	screen.click("images/Sequence.PNG");

	Thread.sleep(3000);

	// screen.click("images/Search");
	screen.type("images/Search.PNG", "Pub");

	Thread.sleep(3000);
	screen.click("images/pubad1.png");
	Thread.sleep(3000);

	screen.click("images/Responce.png");
	Thread.sleep(3000);
	/*
	 * //type text notepad screen.type("images/InputFiled.png",
	 * "Testing com.monocept.weather.sikuli with Test NG");
	 * Thread.sleep(2000);
	 * 
	 * //click on file menu screen.click("images/FileMenu.png", 20);
	 * Thread.sleep(2000);
	 * 
	 * //click on save submenu screen.click("images/SavesubMenu.png", 20);
	 * Thread.sleep(2000);
	 * 
	 * //select file input field and type path
	 * screen.click("images/FilePathInput.png", 20);
	 * screen.type("images/FilePathInput.png", "C:\\test.txt");
	 * Thread.sleep(2000);
	 * 
	 * //click save button screen.click("images/SaveButton.png", 20);
	 * Thread.sleep(2000);
	 */

    }

}
