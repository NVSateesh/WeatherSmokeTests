package weather.sikuli;

import org.sikuli.script.App;
import org.sikuli.script.Screen;

public class StartCharles {
    public Screen screen;

    public void charles() throws Exception {

	// open note pad application
	screen = new Screen();

	App.open("C:\\Program Files\\Charles\\Charles.exe");
	// App.open("C:\\Program Files (x86)\\Fiddler2\\Fiddler.exe");
	Thread.sleep(15000);
    }

}
