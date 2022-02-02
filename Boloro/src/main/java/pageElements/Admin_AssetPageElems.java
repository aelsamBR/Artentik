package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class Admin_AssetPageElems {
		WebDriver PageElemsdriver;
		public  Admin_AssetPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
	//Create or edit elems	
		
		@FindBy(xpath="//button[contains(text(),\"+ Add asset\")]")
		public WebElement AddAssetBtn;
		
	//Create or edit elems	
		
		@FindBy(xpath="//input[@name=\"name\"]")
		public WebElement TitleFld;
		
		@FindBy(xpath="//div[@role=\"textbox\"]")
		public WebElement DescriptionFld;
		
		@FindBy(xpath="//h4[contains(text(),\"Price\")]/following-sibling::div/input")
		public WebElement PriceFld;
		
		@FindBy(xpath="//h4[contains(text(),\"Stock\")]/following-sibling::div/input")
		public WebElement StockFld;
		
		@FindBy(xpath="//input[@value=\"fixed\"]")
		public WebElement FixedSaleTypeOptn;
		
		@FindBy(xpath="//input[@value=\"Active\"]")
		public WebElement ActiveStatusOptn;
		
		@FindBy(xpath="//input[@name=\"shortDescription\"]")
		public WebElement ShortDescFld;
		
		@FindBy(xpath="//input[@value=\"1\"]")
		public WebElement ArtCategoryOptn;
		
		@FindBy(xpath="//img[@id=\"output\"]")
		public WebElement UploadImageOptn;
		
		@FindBy(xpath="//button[@type=\"submit\"and contains(text(),\"Save Asset\")]")
		public WebElement SaveAssetBtn;
		
		//List elems	
		
		@FindBy(xpath="//tr[1]//td[2]/div")
		public WebElement NameInList;
		
		@FindBy(xpath="//tr[1]//td[3]/div")
		public WebElement PriceInList;
		
		@FindBy(xpath="//tr[1]//td[4]/div")
		public WebElement SalesTypeInList;
		
		@FindBy(xpath="//tr[1]//td[5]/div")
		public WebElement CategoryInList;
	}