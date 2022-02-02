package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class Consumer_AssetListPageElems {
		WebDriver PageElemsdriver;
		public  Consumer_AssetListPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			
		}
		public WebDriver driver;
		
		@FindBy(xpath="//div[contains(text(),\"Sort By\")]/following-sibling::div/div")
		public WebElement SortByDrpDwn;
		
		@FindBy(xpath="//div[contains(text(),\"Sale Type\")]/following-sibling::div/div")
		public WebElement SaleTypeDrpDwn;
		
		@FindBy(xpath="//div[contains(text(),\"Fixed Price\")]")
		public WebElement FxdPriceOptn;
		
		@FindBy(xpath="//input[@name=\"search\"]")
		public WebElement SearchFld;

		
		
		public WebElement AssetFromList(String AssetName, WebDriver driver) throws InterruptedException {
			PageElemsdriver = driver;
			Thread.sleep(1000);
			WebElement AssetFromList=PageElemsdriver.findElement(By.xpath("//div[contains(text(),\""+AssetName+"\")]"));
			return AssetFromList;

		}
	
	}