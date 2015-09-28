package weather;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstScroll extends Driver {

    public void fScroll() throws Exception {
	WebElement Scroll_1 = md.findElement(By.id("com.weather.Weather:id/now_circle_include"));
	int topY = Scroll_1.getLocation().getY();
	int bottomY = topY + Scroll_1.getSize().getHeight();
	int centerX = Scroll_1.getLocation().getX() + (Scroll_1.getSize().getWidth() / 2);
	System.out.println("TopY :" + topY + "Bottom :" + bottomY + "center :" + centerX);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
	md.swipe(centerX, bottomY, centerX, topY, 10000);
    }
}
