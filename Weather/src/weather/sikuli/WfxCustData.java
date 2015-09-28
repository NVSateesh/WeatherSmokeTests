package weather.sikuli;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sikuli.script.App;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

public class WfxCustData {
    public Screen screen;

    public void wfxdata() throws Exception {
	screen = new Screen();
	screen.doubleClick("images/Filter_Factual.png");
	screen.type(Key.DELETE);
	Thread.sleep(500);
	screen.type("images/Enter_Filter.png", "triggers.wfxtriggers.com/json");
	Thread.sleep(500);
	screen.click("images/TriggerParam1.png");
	Thread.sleep(500);

	/*// Taking Ref Url
	screen.click("images/CharlesOverview.png");
	Thread.sleep(500);
	screen.doubleClick("images/ClickTriggerurl.png");
	screen.type("a", KeyModifier.CTRL);
	Thread.sleep(500);

	screen.type("c", KeyModifier.CTRL);

	// open new Note pad file and past the data
	Thread.sleep(300);
	screen.type(Key.ESC);
	Thread.sleep(300);
	App.open("Notepad.exe");
	Thread.sleep(3000);
	screen.find("images/Notepad.png");
	// screen.type("Pubad -1");
	screen.type("v", KeyModifier.CTRL);
	Thread.sleep(500);

	// Save data into notepad
	screen.type("s", KeyModifier.CTRL);
	if (screen.find("images/DirectoryFound.png") != null) {
	    Thread.sleep(500);
	    screen.doubleClick("images/Savenotepad.png");
	    screen.type(Key.DELETE);
	    Thread.sleep(500);
	} else {

	    screen.click("images/Backnav.png");
	    screen.click("images/Directory.png");

	    screen.type(Key.DELETE);
	    Thread.sleep(500);
	    screen.type("images/EnterLocationDir.png", "D:\\com.monocept.weather");
	    screen.click("images/TapEnter.png");
	    Thread.sleep(500);
	    screen.click("images/Savenotepad.png");
	    screen.type(Key.DELETE);
	    Thread.sleep(500);
	}

	String fileName = new SimpleDateFormat("yyyyMMdd(hh_mm)").format(new Date());
	System.out.println("FileName is: " + fileName);

	screen.type("images/Savenotepad.png", "triggerUrl.text");
	Thread.sleep(500);
	screen.click("images/DocType.png");
	Thread.sleep(500);
	screen.type(Key.DOWN);
	screen.type(Key.ENTER);
	Thread.sleep(300);
	// screen.click("images/filetype_All.png");

	screen.click("images/Save.png");
	screen.type(Key.END);
	screen.type(Key.ENTER);
	Thread.sleep(500);
	screen.click("images/NotepadIcon.png");
	Thread.sleep(500);
	screen.click("images/MinimizeNotepad.png");
	Thread.sleep(500);

	Thread.sleep(500);*/

	screen.click("images/Response_Tab.png");
	Thread.sleep(500);
	screen.click("images/Click_Responseplace.png");

	// past the data

	Thread.sleep(1000);

	// selecting data

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
	App.open("Notepad.exe");
	Thread.sleep(3000);
	screen.find("images/Notepad.png");
	// screen.type("Pubad -1");
	screen.type("v", KeyModifier.CTRL);
	Thread.sleep(500);

	// Save data into notepad
	screen.type("s", KeyModifier.CTRL);
	if (screen.find("images/DirectoryFound.png") != null) {
	    Thread.sleep(500);
	    screen.doubleClick("images/Savenotepad.png");
	    screen.type(Key.DELETE);
	    Thread.sleep(500);
	} else {

	    screen.click("images/Backnav.png");
	    screen.click("images/Directory.png");

	    screen.type(Key.DELETE);
	    Thread.sleep(500);
	    screen.type("images/EnterLocationDir.png", "D:\\com.monocept.weather");
	    screen.click("images/TapEnter.png");
	    Thread.sleep(500);
	    screen.click("images/Savenotepad.png");
	    screen.type(Key.DELETE);
	    Thread.sleep(500);
	}

	/*
	 * String fileName = new SimpleDateFormat("yyyyMMdd(hh_mm)").format(new
	 * Date()); System.out.println("FileName is: "+fileName);
	 */

	screen.type("images/Savenotepad.png", "wfx.json");
	Thread.sleep(500);
	screen.click("images/DocType.png");
	Thread.sleep(500);
	screen.type(Key.DOWN);
	screen.type(Key.ENTER);
	Thread.sleep(300);
	// screen.click("images/filetype_All.png");

	screen.click("images/Save.png");
	screen.type(Key.END);
	screen.type(Key.ENTER);
	Thread.sleep(500);
	screen.click("images/NotepadIcon.png");
	Thread.sleep(500);
	screen.click("images/MinimizeNotepad.png");
	Thread.sleep(500);

    }

}
