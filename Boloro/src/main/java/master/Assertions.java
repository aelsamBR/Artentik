package master;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class Assertions {
	WebDriver driver;
public WebDriver PageSourcetextContainCheck(WebDriver driver, String Text) {
	
	String pageText=driver.getPageSource();
	  assertTrue(pageText.contains(Text));
	  return driver;
}
}
