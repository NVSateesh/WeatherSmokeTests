package weather;

import org.openqa.selenium.By;

public class Searchlocation extends Driver {

    public void search() throws Exception {
	Thread.sleep(500);

	md.findElement(By.name("More options")).click();
	md.findElement(
		By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"))
		.click();
	String login = md
		.findElement(
			By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"))
		.getText();

	System.out.println("Login button : " + login);

	if (login.contains("Log In")) {

	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"))
		    .click();
	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]"))
		    .click();

	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]"))
		    .sendKeys("monocept123@gmail.com");
	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[2]"))
		    .click();
	    md.findElement(
		    By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[2]"))
		    .sendKeys("password123");
	    md.navigate().back();
	    md.findElement(By.name("Twc Login Button")).click();
	    Thread.sleep(1000);
	    md.findElement(By.id("android:id/action_bar_title")).click();
	} else {
	    md.findElement(By.id("android:id/action_bar_title")).click();
	}

	md.findElement(By.id("com.weather.Weather:id/location_actionbar_row")).click();
	String City = md
		.findElement(
			By.xpath("// android.widget.FrameLayout[1]// android.widget.ListView[1]/ android.widget.LinearLayout[3]// android.widget.TextView[1]"))
		.getText();
	System.out.println(City);
	md.findElement(
		By.xpath("// android.widget.FrameLayout[1]// android.widget.ListView[1]/ android.widget.LinearLayout[3]// android.widget.TextView[1]"))
		.click();

	/*
	 * md.findElement(By.id("com.weather.Weather:id/search")).click();
	 * md.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	 * md.findElement
	 * (By.id("com.weather.Weather:id/search")).sendKeys("06457");
	 * md.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	 * 
	 * //WebElement xyz =
	 * driver.findElement(By.className("android.widget.LinearLayout[index=1"
	 * )); WebElement element =
	 * md.findElement(By.id("android:id/search_src_text")); Point point =
	 * element.getLocation(); Dimension size = element.getSize();
	 * System.out.println("Point is:" + point + "," +"Size is :"+ size);
	 * md.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS); int
	 * x=734; int y= 275; md.tap(1, x , y , 1000);
	 * md.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
	 */

	/* md.findElement(By.id("android:id/action_bar_title")).click(); */

	/*
	 * md.findElement(By.id("com.weather.Weather:id/search")).click();
	 * md.findElement(By.id("com.weather.Weather:id/search")).clear();
	 * md.findElement
	 * (By.id("com.weather.Weather:id/search")).sendKeys("10016");
	 * md.findElement(By.id("id/search_src_text")).click();
	 */

	// android:id/action_bar_title
    }

}
