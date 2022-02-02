package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class Admin_LoginPageElems {
		WebDriver PageElemsdriver;
		public  Admin_LoginPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="//input[@name=\"email\"]")
		public WebElement EmailFld;
		
		@FindBy(xpath="//input[@name=\"password\"]")
		public WebElement PasswordFld;
		
		@FindBy(xpath="//button[@type=\"submit\"]")
		public WebElement SignInBtn;
	}