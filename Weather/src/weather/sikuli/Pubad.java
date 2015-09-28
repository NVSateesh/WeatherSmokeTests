package weather.sikuli;

import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

public class Pubad {
    public Screen screen;

    public void pubad2() throws Exception {
	screen = new Screen();
	Thread.sleep(1000);
	/*
	 * screen.doubleClick("images/Filter.PNG"); screen.type(Key.DELETE);
	 * 
	 * 
	 * screen.type("images/Filter.PNG","pub");
	 */

	Thread.sleep(500);
	screen.click("images/pubad.g.doubleclick.png");
	Thread.sleep(500);

	screen.click("images/Req.PNG");
	Thread.sleep(500);

	/*
	 * //scrol the page screen.click("images/scrollclick.png"); //
	 * screen.type(Key.DOWN + Key.DOWN, KeyModifier.CTRL); screen.wheel(1 ,
	 * 14); //screen.wheel(target, direction, steps)
	 */

	Thread.sleep(2000);
	screen.doubleClick("images/click_t.PNG");
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
	screen.click("images/MaxNotepad.png");
	Thread.sleep(3000);
	screen.find("images/NotepadFind.png.png");
	// screen.type("Pubad -1");
	screen.type("v", KeyModifier.CTRL);

    }

}
