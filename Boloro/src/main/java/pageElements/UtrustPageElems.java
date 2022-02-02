package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class UtrustPageElems {
		WebDriver PageElemsdriver;
		public  UtrustPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			
		}
		public WebDriver driver;
		
		@FindBy(xpath="//span[contains(text(),\"artentik-test\")]")
		public WebElement artentikNameInUtrust;
		
		@FindBy(xpath="//span[@data-test=\"rateButtonAmountValueETH\"]")
		public WebElement ETHValueOptn;
		
		@FindBy(xpath="//li[@id=\"react-tabs-2\"]")
		public WebElement ManualOptn;
		
		@FindBy(xpath="//button[@data-test=\"manualAmountValue\"]")
		public WebElement CopyAmount;
		
		@FindBy(xpath="//button[@id=\"copy-address\"]")
		public WebElement CopyAddress;
		
		@FindBy(xpath="//a[@data-test=\"redirectLink\"]")
		public WebElement redirectlinkHereBtn;
		
		

		
		
		public WebElement AssetFromList(String AssetName, WebDriver driver) {
			PageElemsdriver = driver;
			WebElement AssetFromList=PageElemsdriver.findElement(By.xpath("//div[contains(text(),\""+AssetName+"\")]"));
			return AssetFromList;
	//	@FindBy(xpath="//input[@name=\"search\"]") WebElement AssetName;
		}
	
	}