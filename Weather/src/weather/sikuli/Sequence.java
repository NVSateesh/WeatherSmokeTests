package weather.sikuli;

import org.sikuli.script.Screen;

public class Sequence {
    public Screen screen;

    public void select_Sequence() throws Exception {
	screen = new Screen();
	screen.click("images/Sequence.PNG");

	Thread.sleep(3000);

    }

}
