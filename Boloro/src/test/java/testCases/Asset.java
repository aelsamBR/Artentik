package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import data.ExcelDataProvider;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import master.Main;
import pageElements.Admin_AssetPageElems;
import pageElements.Admin_LoginPageElems;
import pageElements.CommonPageElems;
import utils.Support;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Asset {
	WebDriver driver;
	Main main =new Main();
	Admin_LoginPageElems ad_loginPageElems;
	Admin_AssetPageElems ad_assetPageElems;
	CommonPageElems commonPageElems;
	ExcelDataProvider dP =new ExcelDataProvider();
	Support support = new Support();
	String projPath =System.getProperty("user.dir");
	
 @Test( dataProvider="tD1" )
  public void f(String TitleName, String Desc, String Price, String Stock, String ShortDesc) throws InterruptedException, AWTException {
	  ad_loginPageElems = new Admin_LoginPageElems(driver);
	  ad_assetPageElems = new Admin_AssetPageElems(driver);
	  commonPageElems = new CommonPageElems(driver);
	  ad_loginPageElems.EmailFld.sendKeys("admin@example.com");
	  ad_loginPageElems.PasswordFld.sendKeys("123456");
	  ad_loginPageElems.SignInBtn.click();
	  Thread.sleep(30000);
	//  driver.switchTo().alert().accept();
	  ad_assetPageElems.AddAssetBtn.click();
	  ad_assetPageElems.TitleFld.sendKeys(TitleName);
	  ad_assetPageElems.DescriptionFld.sendKeys(Desc);
	  ad_assetPageElems.FixedSaleTypeOptn.click();
	  ad_assetPageElems.PriceFld.sendKeys(Price);
	  ad_assetPageElems.ActiveStatusOptn.click();
	  ad_assetPageElems.StockFld.sendKeys(Stock);
	  ad_assetPageElems.ShortDescFld.sendKeys(ShortDesc);
	  ad_assetPageElems.ArtCategoryOptn.click();
	  ad_assetPageElems.UploadImageOptn.click();
	  support.fileUpload(projPath+"\\Files\\Logo.png");
	  ad_assetPageElems.SaveAssetBtn.click();
  }

 

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	 
  }

  @AfterMethod
  public void afterMethod() {
	  
  }


  @DataProvider(name="tD1")
  public Object[][] dp() throws IOException {
	  String excelPath="C:\\Users\\aelsa\\eclipse-workspace\\Boloro\\DataSheet\\Data.xlsx";
		 String sheetName="Sheet1";
	  Object data[][]=dP.testData(excelPath,sheetName);	  
	return data;
   
  }
  @BeforeClass
  public void beforeClass() {
	
	 
  }

  @AfterClass
  public void afterClass() {
//	 driver.quit();
  }
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browser)throws IOException, InterruptedException {
	  String url="https://boloro-frontend-admin-dev.devtomaster.com/";
	  driver= main.driver(browser, url);
	  Thread.sleep(12000);
  }

  @AfterTest
  public void afterTest() {
  }


}
