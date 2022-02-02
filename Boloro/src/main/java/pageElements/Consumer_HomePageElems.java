package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class Consumer_HomePageElems {
		WebDriver PageElemsdriver;
		public  Consumer_HomePageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="//button[contains(text(),\"Accept All\")]")
		public WebElement CookiesAcceptAllBtn;
		
		@FindBy(xpath="//button[contains(text(),\"Connect Wallet\")]")
		public WebElement ConnectWalletBtn;
		
		@FindBy(xpath="//button[contains(text(),\"Install\")]")
		public WebElement MetaMaskInstallBtn;
		
		@FindBy(xpath="//img[@alt=\"MetaMask\"]")
		public WebElement MetaMaskOptn;
		
		@FindBy(xpath="//span[contains(text(),\"Categories\")]")
		public WebElement CategoriesOptn;
		
		@FindBy(xpath="//a/div[contains(text(),\"All\")]")
		public WebElement AllCategories;
		
		@FindBy(xpath="//a[contains(text(),\"About Artentik\")]")
		public WebElement AboutArtentikOptn;
		
		@FindBy(xpath="//div[@class=\"container\"]/h2")
		public WebElement AboutArtentikTxt;
		
		@FindBy(xpath="//a[contains(text(),\"About Santa Casa da Misericórdia de Lisboa\")]")
		public WebElement AboutSCMLOptn;
		
		@FindBy(xpath="//a[contains(text(),\"FAQs\")]")
		public WebElement FAQsOptn;
		
		@FindBy(xpath="//a[contains(text(),\"FAQs\")]")
		public WebElement TermsAndConditionOptn;
		
		@FindBy(xpath="//a[contains(text(),\"FAQs\")]")
		public WebElement PrivacyPolicyOptn;
		
		@FindBy(xpath="//a[contains(text(),\"Support\")]")
		public WebElement SupportOptn;
	}