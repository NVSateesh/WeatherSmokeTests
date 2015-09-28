package weather.sikuli;

import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class ClearLogs {
    public Screen screen;

    public void clear_logs() throws Exception {
	screen = new Screen();
	Thread.sleep(500);
	screen.click("images/Closecustparam.png");
	screen.type(Key.ESC);
	Thread.sleep(1000);
	/*
	 * screen.click("images/CharlessMinimize.png"); Thread.sleep(500);
	 */

    }
}
