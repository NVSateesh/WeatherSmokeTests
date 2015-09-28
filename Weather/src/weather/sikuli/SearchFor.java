package weather.sikuli;

import org.sikuli.script.App;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

public class SearchFor {
    public Screen screen;

    public void searchapi() throws Exception {
	screen = new Screen();
	Thread.sleep(1000);
	screen.type("images/Filter.PNG", "pubads.g.doubleclick.net");
	Thread.sleep(300);

	/*
	 * screen.click("images/SortbyHost.png");
	 * screen.click("images/pubads5.PNG",3); screen.type(Key.SPACE);
	 * //screen.type(Key.ESC); Thread.sleep(500);
	 */

	if (screen.find("images/pubads5.PNG") != null) {
	    screen.click("images/pubads5.PNG", 3);
	    screen.type(Key.SPACE);
	    // screen.type(Key.ESC);
	    Thread.sleep(500);
	} else {

	    screen.click("images/pubads5.PNG", 3);
	    screen.wheel(5, 1);
	    screen.type(Key.SPACE);
	    // screen.type(Key.ESC);
	    Thread.sleep(500);
	}

	screen.click("images/Req.PNG");
	Thread.sleep(500);

	/*
	 * //scrol the page screen.click("images/scrollclick.png"); //
	 * screen.type(Key.DOWN + Key.DOWN, KeyModifier.CTRL); screen.wheel(1 ,
	 * 14); //screen.wheel(target, direction, steps)
	 */

	Thread.sleep(500);
	if (screen.find("images/click_t.PNG") != null) {
	    screen.doubleClick("images/click_t.PNG");
	} else {
	    screen.doubleClick("images/click_t2.PNG");
	}
	Thread.sleep(500);
	// screen.doubleClick("images/click_cond.PNG");

	/*
	 * if(screen.find("images/Custparam1.PNG")!=null) {
	 * 
	 * screen.click("images/Custparam1.PNG"); Thread.sleep(1000); }else{
	 * screen.click("images/Custparam2.PNG");
	 * 
	 * Thread.sleep(1000); } //selecting adata
	 * 
	 * screen.keyDown(Key.SHIFT); screen.type(Key.LEFT);
	 * screen.type(Key.DOWN); screen.type(Key.DOWN);
	 * screen.keyUp(Key.SHIFT); Thread.sleep(500);
	 */
	// Select the Data
	screen.type("a", KeyModifier.CTRL);
	Thread.sleep(500);

	// Copy the data
	screen.type("c", KeyModifier.CTRL);
	Thread.sleep(500);
	screen.type(Key.ESC);
	// open new Note pad file and past the data
	Thread.sleep(500);
	App.open("Notepad.exe");
	Thread.sleep(3000);
	screen.find("images/Notepad.png");
	// screen.type("Pubad -1");
	screen.type("v", KeyModifier.CTRL);

	/*
	 * App.open(
	 * "C:\\Program Files\\Microsoft Office 15\\root\\office15\\excel.exe");
	 * Thread.sleep(3000); screen.click("images/BlankExcel.PNG");
	 * screen.find("images/Cell.png"); screen.type("v",KeyModifier.CTRL);
	 * Thread.sleep(1000);
	 */

    }

}
