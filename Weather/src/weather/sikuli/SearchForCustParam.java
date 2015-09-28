package weather.sikuli;

import org.sikuli.script.App;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

public class SearchForCustParam {
    public Screen screen;

    public void search_api() throws Exception {
	screen = new Screen();
	Thread.sleep(1000);
	screen.type("images/Filter.PNG", "pub");

	Thread.sleep(500);
	screen.click("images/pubad.g.doubleclick.png");
	Thread.sleep(500);

	screen.click("images/Req.PNG");
	Thread.sleep(500);
	// scroll the page
	screen.type(Key.DOWN + Key.DOWN, KeyModifier.CTRL);
	screen.wheel(1, 3);

	screen.doubleClick("images/click_cond.PNG");
	Thread.sleep(500);
	// screen.doubleClick("images/click_cond.PNG");
	screen.click("images/Custparam.PNG");
	Thread.sleep(1000);

	// selecting adata

	screen.keyDown(Key.SHIFT);
	screen.type(Key.LEFT);
	screen.type(Key.DOWN);
	screen.type(Key.DOWN);
	screen.keyUp(Key.SHIFT);
	Thread.sleep(500);

	// Select the Data
	screen.type("a", KeyModifier.CTRL);
	Thread.sleep(500);

	// Copy the data
	screen.type("c", KeyModifier.CTRL);

	// open new Note pad file and past the data
	Thread.sleep(500);
	/*
	 * App.open("Notepad.exe"); Thread.sleep(3000);
	 * screen.find("images/Notepad.png"); screen.type("v",KeyModifier.CTRL);
	 */

	App.open("C:\\Program Files\\Microsoft Office 15\\root\\office15\\excel.exe");
	Thread.sleep(3000);
	screen.click("images/BlankExcel.PNG");
	screen.find("images/Cell.png");
	screen.type("v", KeyModifier.CTRL);
	Thread.sleep(1000);
    }
}
