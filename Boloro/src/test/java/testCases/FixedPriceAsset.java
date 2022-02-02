package testCases;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.ExcelDataProvider;
import data.TestData;
import master.Main;
import pageElements.Consumer_AssetDetailPageElems;
import pageElements.Consumer_AssetListPageElems;
import pageElements.Consumer_HomePageElems;
import pageElements.UtrustPageElems;
import utils.APICollections;
import utils.Support;


public class FixedPriceAsset {
	WebDriver driver;
	Support sup = new Support();
    Main m =new Main();
	Consumer_HomePageElems homePageElems;
	Consumer_AssetListPageElems assetListPageElems;
	Consumer_AssetDetailPageElems assetDetailsPageElems;
	UtrustPageElems utrustPageElems;
    APICollections API =new APICollections();
		
		
//dataProvider="FixedPricePurchase",dataProviderClass = TestData.class
	  @Test()
	  public void f() throws IOException, InterruptedException, UnsupportedFlavorException {
	
		  assetListPageElems = new Consumer_AssetListPageElems(driver);
		  assetDetailsPageElems=new Consumer_AssetDetailPageElems(driver);
		  String AssetName=sup.RandomName();
		  
		  API.AssetCreation(AssetName);
		  assetListPageElems.SearchFld.sendKeys(AssetName);
		  WebElement assetFromList=assetListPageElems.AssetFromList(AssetName, driver);
		  m.WaitUntilElementClickable(20, assetFromList, driver);
		  assetFromList.click();
		  driver.navigate().refresh();
		  m.WaitUntilElementClickable(20, assetDetailsPageElems.BuyNowBtn, driver);
		  assetDetailsPageElems.BuyNowBtn.click();
		  m.WaitUntilElementClickable(20, assetDetailsPageElems.CheckOutBtn, driver);
		  assetDetailsPageElems.CheckOutBtn.click();
		  sup.FixedPricemetamaskPay();
		 

	  }

	 

	  @Parameters({"browser","metaMaskUrl","AppUrl"})
	  @BeforeClass
	  public void beforeTest(String browser, String metaMaskUrl, String AppUrl  )throws IOException, InterruptedException {
		  driver=sup.login(browser,metaMaskUrl,AppUrl );
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		  homePageElems = new Consumer_HomePageElems(driver);
		  homePageElems.CategoriesOptn.click();
		  homePageElems.AllCategories.click();	
		  
	  }
	  
	 
}
