package master;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Main<V> {
	WebDriver driver;
	Properties prop =new Properties();
	String projPath =System.getProperty("user.dir");
	WebDriverWait wait ;
	
  
	@SuppressWarnings("deprecation")
	public WebDriver driver(String browser, String url)throws IOException {
	  
	  if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", projPath+"/Drivers/geckodriver.exe");
		driver=new FirefoxDriver();
    	driver.get(url);
    	driver.manage().window().maximize();
	  }
	  else if(browser.equalsIgnoreCase("chrome")){
		  
			System.setProperty("webdriver.chrome.driver", projPath+"/ChromeDriver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();	
		    options.addExtensions(new File(projPath+"/MetaMask.crx"));
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				 driver = new ChromeDriver(capabilities);
		     	driver.get(url);
	    	driver.manage().window().maximize();
		  }
	  else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", projPath+"/Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
	    	driver.get(url);
	    	driver.manage().window().maximize();
		  }
    	return driver;
	}
	
	public WebDriver implicitWait (int n) {
		driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
		return driver;
	}
	  

	@SuppressWarnings("deprecation")
	public WebDriver WaitUntilElementClickable (int N, WebElement WE, WebDriver driver) {
		wait = new WebDriverWait(driver, N);
		wait.until(ExpectedConditions.elementToBeClickable(WE));
		return driver;
	}
	@SuppressWarnings("deprecation")
	public WebDriver WaitUntilElementVisible (int N, WebElement WE, WebDriver driver) {
		wait = new WebDriverWait(driver, N);
		wait.until( ExpectedConditions.visibilityOf(WE));
		return driver;
	}
	@SuppressWarnings("deprecation")
	public WebDriver WaitUntilElementVanish (int N, WebElement WE, WebDriver driver) {
		wait = new WebDriverWait(driver, N);
		wait.until( ExpectedConditions.invisibilityOf(WE));
		return driver;
	}
	public String GetCopiedText () throws UnsupportedFlavorException, IOException  {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		return result;
	
	}
}
