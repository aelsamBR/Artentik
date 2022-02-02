package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class Consumer_AssetDetailPageElems {
		WebDriver PageElemsdriver;
		public  Consumer_AssetDetailPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			
		}
		public WebDriver driver;
		
		@FindBy(xpath="//span[contains(text(),\"Buy Now\")]")
		public WebElement BuyNowBtn;
		
		@FindBy(xpath="//button[@class=\"button-small\"]")
		public WebElement CheckOutBtn;
		
		@FindBy(xpath="//button[contains(text(),\"Bid Now\")]")
		public WebElement BidNowBtn;
		
		@FindBy(xpath="//input[@name=\"bid\"]")
		public WebElement BidInptFld;
		
		@FindBy(xpath="//button[@type=\"submit\"]")
		public WebElement BidBtn;
		
		@FindBy(xpath="//div[contains(text(),\"Your bid successfully applied.\")]")
		public WebElement BidAppliedMessage;
		
		
		
		

		
		
		public WebElement AssetFromList(String AssetName, WebDriver driver) {
			PageElemsdriver = driver;
			WebElement AssetFromList=PageElemsdriver.findElement(By.xpath("//div[contains(text(),\""+AssetName+"\")]"));
			return AssetFromList;
	//	@FindBy(xpath="//input[@name=\"search\"]") WebElement AssetName;
		}
	
	}