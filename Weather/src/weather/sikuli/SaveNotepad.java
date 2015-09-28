package weather.sikuli;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

public class SaveNotepad {
    public Screen screen;

    public void notepad_save() throws Exception {
	screen = new Screen();
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

	screen.type("images/Savenotepad.png", "WeatherTest");
	Thread.sleep(500);
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
