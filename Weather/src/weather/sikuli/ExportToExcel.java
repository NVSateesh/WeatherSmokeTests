package weather.sikuli;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

public class ExportToExcel {
    public Screen screen;

    public void export() throws Exception {
	screen = new Screen();
	screen.click("images/Tab_DataTab.png");
	Thread.sleep(1000);

	screen.click("images/TextToColumn.png");
	Thread.sleep(1000);
	screen.click("images/NextButton.png");
	Thread.sleep(1000);
	screen.click("images/OtherCheck.png");
	screen.type("images/EnterOthertype.png", "&");
	screen.click("images/NextButton.png");
	Thread.sleep(1000);
	screen.click("images/Finish.png");
	Thread.sleep(1000);
	screen.click("images/1.PNG");
	Thread.sleep(1000);
	screen.type("c", KeyModifier.CTRL);

	screen.rightClick("images/A2.PNG");
	screen.click("images/PasteSpecial.PNG");
	Thread.sleep(1000);
	screen.click("images/Transpose.PNG");
	screen.click("images/OK.PNG");
	Thread.sleep(2000);

	// Delete Line one
	screen.click("images/1.PNG");
	screen.rightClick("images/1.PNG");
	Thread.sleep(1000);
	screen.click("images/Delete.PNG");
	Thread.sleep(1000);
	// set all values
	screen.click("images/Row1.PNG");

	screen.click("images/Tab_DataTab.png");
	Thread.sleep(1000);

	screen.click("images/TextToColumn.png");
	Thread.sleep(1000);
	screen.click("images/NextButton.png");
	Thread.sleep(1000);
	// screen.click("images/OtherCheck.png");
	screen.click("images/Checkother.png");
	screen.type(Key.DELETE);
	Thread.sleep(500);
	screen.type("images/Checkother.png", "=");
	screen.click("images/NextButton.png");
	Thread.sleep(1000);
	screen.click("images/Finish.png");
	Thread.sleep(2000);

	String fileName = new SimpleDateFormat("yyyyMMdd(hh_mm)").format(new Date());
	System.out.println("FileName is: " + fileName);

	screen.type("s", KeyModifier.CTRL);
	Thread.sleep(1000);
	screen.click("images/SaveAs.png");
	Thread.sleep(1000);
	screen.click("images/BrowseButton.png");
	Thread.sleep(1000);
	screen.click("images/ClickForEnterLocation.png");
	Thread.sleep(500);
	// screen.click("images/EnterLocation.png");
	screen.type(Key.DELETE);
	Thread.sleep(1000);
	screen.type("images/EnterLocation.png", "D:\\com.monocept.weather");
	screen.click("images/ClickEnter.png");
	Thread.sleep(1000);
	screen.type("images/EnterFileName.Png", fileName);
	screen.click("images/SaveButton.PNG");
    }

}
