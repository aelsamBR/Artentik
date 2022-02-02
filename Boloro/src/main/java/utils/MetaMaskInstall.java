package utils;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;


import master.Main;
import pageElements.MetaMaskPageElems;



public class MetaMaskInstall {
	Main main =new Main();
MetaMaskPageElems metamaskElems;
String projPath =System.getProperty("user.dir");

	public void MetaMaskInstalation(WebDriver driver) throws InterruptedException {
		
		metamaskElems =  new MetaMaskPageElems(driver);
	  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(newTab.get(0));
	  Thread.sleep(1000);
	  main.WaitUntilElementClickable(20, metamaskElems.GetStartedBtn, driver);
	  metamaskElems.GetStartedBtn.click();
	  main.WaitUntilElementClickable(20, metamaskElems.ImportWalletBtn, driver);
	  metamaskElems.ImportWalletBtn.click();
	  main.WaitUntilElementClickable(20, metamaskElems.IAgreeBtn, driver);
	  metamaskElems.IAgreeBtn.click();
	  main.WaitUntilElementClickable(20, metamaskElems.SecretRecoveryPhraseFromClipboard, driver);
	  metamaskElems.SecretRecoveryPhraseFromClipboard.sendKeys("violin anchor stage fun view park interest banner hen bless accident comfort");
	  metamaskElems.PasswordField.sendKeys("SamAel123");
	  metamaskElems.ConfirmPasswordFld.sendKeys("SamAel123");
	  metamaskElems.TermsAndCondCheckBox.click();
	  metamaskElems.ImportBtn.click();
	  main.WaitUntilElementClickable(20, metamaskElems.AllDoneBtn, driver);
	  metamaskElems.AllDoneBtn.click();
	  main.WaitUntilElementClickable(20, metamaskElems.PopUpClose, driver);
	  metamaskElems.PopUpClose.click(); 
	  driver.close();
	  driver.switchTo().window(newTab.get(1));
	  
	}
}
