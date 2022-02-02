package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import master.Main;
import pageElements.CommonPageElems;
import pageElements.Consumer_HomePageElems;
import pageElements.MetaMaskPageElems;
import pageElements.UtrustPageElems;

public class Support {
	
	  WebDriver driver;
	  Main m =new Main();
	  Consumer_HomePageElems homePageElems;
	  MetaMaskPageElems metaMaskPageElems;
	  CommonPageElems commonPageElems;
	  UtrustPageElems utrustPageElems;
	  
	public void fileUpload(String path) throws AWTException {
		StringSelection strSelection = new StringSelection(path);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);
 
        Robot robot = new Robot();
  
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
 public WebDriver login(String browser, String metaMaskUrl, String url) throws IOException, InterruptedException {
	 // String url="https://boloro-frontend-dev.devtomaster.com/";
	 // String metaMaskUrl ="moz-extension://cf97d3de-12ef-4670-91e7-65be9a37e5bb/home.html#initialize/welcome";
	  driver= m.driver(browser, metaMaskUrl);
	  MetaMaskInstall MMI = new MetaMaskInstall();
	  MMI.MetaMaskInstalation(driver);
	  driver.get(url);
	  
	  homePageElems = new Consumer_HomePageElems(driver);
	  metaMaskPageElems =new MetaMaskPageElems(driver);
	  commonPageElems = new CommonPageElems(driver);
	  m.WaitUntilElementVisible(20, homePageElems.CookiesAcceptAllBtn, driver);
	  homePageElems.CookiesAcceptAllBtn.click();
	  homePageElems.ConnectWalletBtn.click();
	  m.WaitUntilElementVisible(20, homePageElems.MetaMaskOptn, driver);
	  homePageElems.MetaMaskOptn.click();
	  Thread.sleep(1000);
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();
	  Iterator<String> I1= s.iterator();
	  while(I1.hasNext())
	  {
	  String child_window=I1.next();
	  if(!parent.equals(child_window))
	  {
	  driver.switchTo().window(child_window);
	  m.WaitUntilElementVisible(20,  metaMaskPageElems.PopUpNextBtn, driver);
	  metaMaskPageElems.PopUpNextBtn.click();
      metaMaskPageElems.PopUpConnectBtn.click();
      m.WaitUntilElementVisible(20,  metaMaskPageElems.PopUpSignBtn, driver);
      metaMaskPageElems.PopUpSignBtn.click();
      driver.close();
      driver.switchTo().window(parent);
      m.WaitUntilElementVisible(20,  commonPageElems.OkBtn, driver);
      commonPageElems.OkBtn.click();
	  }
  }
	return driver;
 }
 
 public void FixedPricemetamaskPay() throws UnsupportedFlavorException, IOException, InterruptedException {
	 utrustPageElems= new UtrustPageElems(driver);
	 metaMaskPageElems =new MetaMaskPageElems(driver);
	 
	 m.WaitUntilElementClickable(20, utrustPageElems.artentikNameInUtrust, driver);
	  utrustPageElems.ETHValueOptn.click();
	  m.WaitUntilElementClickable(20, utrustPageElems.ManualOptn, driver);
	  utrustPageElems.ManualOptn.click();
	  m.WaitUntilElementClickable(20, utrustPageElems.CopyAddress, driver);
	  utrustPageElems.CopyAddress.click();
	  String CopiedAddress=m.GetCopiedText();
	  utrustPageElems.CopyAmount.click();
	  String CopiedAmount=m.GetCopiedText();
	  String parent=driver.getWindowHandle();
	  driver.switchTo().newWindow(WindowType.TAB);
	  driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html");
		 m.WaitUntilElementClickable(20, metaMaskPageElems.PopUpClose, driver);
		 metaMaskPageElems.PopUpClose.click();
		 metaMaskPageElems.NetWorkDrpDwn.click();
		 metaMaskPageElems.RopstenTestNetworkOptn.click();
		 metaMaskPageElems.SendBtn.click();
		 
		 m.WaitUntilElementVisible(20, metaMaskPageElems.AddressInputFld, driver);
		 Thread.sleep(3000);
		 metaMaskPageElems.AddressInputFld.sendKeys(CopiedAddress);
		 driver.navigate().refresh();
		 m.WaitUntilElementVisible(20, metaMaskPageElems.AddressInputFld, driver);
		 Thread.sleep(3000);
		 metaMaskPageElems.AddressInputFld.sendKeys(CopiedAddress);
		 Thread.sleep(3000);
		 m.WaitUntilElementVisible(20, metaMaskPageElems.AmountInputFld, driver);
		 metaMaskPageElems.AmountInputFld.sendKeys(CopiedAmount);
		 metaMaskPageElems.PaymentNxtBtn.click();
		 m.WaitUntilElementClickable(20, metaMaskPageElems.PaymentCnfmBtn, driver);
		 metaMaskPageElems.PaymentCnfmBtn.click();
		 Thread.sleep(1000);
		 m.WaitUntilElementVanish(60, metaMaskPageElems.PaymentPendingStatus, driver);
		 driver.close();
	
	
	 driver.switchTo().window(parent);
	 m.WaitUntilElementVisible(20, utrustPageElems.redirectlinkHereBtn, driver);
	 utrustPageElems.redirectlinkHereBtn.click();
	 
 }
 
 public WebDriver MumbaiTestNetworkSwitch() throws UnsupportedFlavorException, IOException, InterruptedException {
	 
	 
	 metaMaskPageElems =new MetaMaskPageElems(driver);
	 String NetworkName ="Mumbai Testnet";
	 String NewRPCURL ="https://polygon-mumbai.infura.io/v3/a90853f7812b49c3ba8ca3f57b5a0682";
	 String ChainID ="80001";
	 String CurrencySymbol ="MATIC";
	 String BlockExplorerURL ="https://mumbai.polygonscan.com";
	 
	  String parent=driver.getWindowHandle();
	  driver.switchTo().newWindow(WindowType.TAB);
	  driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html");
		 m.WaitUntilElementClickable(20, metaMaskPageElems.PopUpClose, driver);
		 metaMaskPageElems.PopUpClose.click();
		 metaMaskPageElems.AccntProfileBtn.click();
		 metaMaskPageElems.SettingsOptn.click();
		 metaMaskPageElems.NetWorksOptn.click();
		 metaMaskPageElems.AddNetworkBtn.click();
		 metaMaskPageElems.NetworkNameFld.sendKeys(NetworkName);
		 metaMaskPageElems.NewRPCURLFld.sendKeys(NewRPCURL);
		 metaMaskPageElems.ChainID.sendKeys(ChainID);
		 metaMaskPageElems.CurrencySymbolFld.sendKeys(CurrencySymbol);
		 metaMaskPageElems.BlockExplorerURLFld.sendKeys(BlockExplorerURL);
		 metaMaskPageElems.SaveNetworkBtn.click();
		 Thread.sleep(3000);
		 driver.close();
		 driver.switchTo().window(parent);
		 return driver;
	 
 }
 
 public void BidCofirmFromMetaMask() throws InterruptedException {
	 
	 metaMaskPageElems =new MetaMaskPageElems(driver);
	  commonPageElems = new CommonPageElems(driver);
	  
	  
	 String parent=driver.getWindowHandle();
	 System.out.println(parent);
	  Set<String>s=driver.getWindowHandles();
	  System.out.println(s);
	  Iterator<String> I1= s.iterator();
	  while(I1.hasNext())
	  {
	  String child_window=I1.next();
	  System.out.println("While");
	  if(!parent.equals(child_window))
	  {
		  System.out.println("insideIf");
	  driver.switchTo().window(child_window);
	  m.WaitUntilElementVisible(20,  metaMaskPageElems.BidConfirmBtnInMetaMask, driver);
	  metaMaskPageElems.BidConfirmBtnInMetaMask.click();
     m.WaitUntilElementClickable(20,  metaMaskPageElems.BidConfirmBtnInMetaMask, driver);
     metaMaskPageElems.BidConfirmBtnInMetaMask.click();
   //  driver.close();
     driver.switchTo().window(parent);
     m.WaitUntilElementVisible(20,  commonPageElems.OkBtn, driver);
     commonPageElems.OkBtn.click();
	  }
	  }
 }
 public String RandomName() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				int n = 6;
				StringBuilder sb = new StringBuilder(n);
				for (int i = 0; i < n; i++) {
					int index = (int) ((AlphaNumericString.length() * Math.random()));
					sb.append(AlphaNumericString.charAt(index));
				}
				String text = sb.toString();
				return text;
	}
 public String StartDateTime() {
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd" );  
	   LocalDateTime now = LocalDateTime.now();  
	   DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");  
	   LocalDateTime now1 = LocalDateTime.now();
	   String Date =dtf.format(now);
	   String Time =dtf1.format(now1);
	   String StartDate=Date+"T"+Time+".000Z";
	   System.out.println(StartDate);
				return StartDate;
	}
 public String EndDateTime(int hrs) {
	  DateTimeFormatter fdtf = DateTimeFormatter.ofPattern("yyyy-MM-dd" );  
	   LocalDateTime fnow = LocalDateTime.now().plusHours(1);  
	   DateTimeFormatter fdtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");  
	   LocalDateTime fnow1 = LocalDateTime.now().plusHours(1);;
	   String fDate =fdtf.format(fnow);
	   String fTime =fdtf1.format(fnow1);
	   String EndDate=fDate+"T"+fTime+".000Z";
	   System.out.println(EndDate);
				return EndDate;
	}
}
