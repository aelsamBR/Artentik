package data;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestData {
	ExcelDataProvider dP =new ExcelDataProvider();
	String projPath =System.getProperty("user.dir");
	
	@DataProvider(name="FixedPricePurchase")
	  public Object[][] TC001Data() throws IOException {
		  String excelPath=projPath+"\\DataSheet\\Data.xlsx";
			 String sheetName="FixedPricePurchase";
		  Object data[][]=dP.testData(excelPath,sheetName);	  
		return data;
	  }
	
	@DataProvider(name="AuctionAssetPurchase")
	  public Object[][] TC002Data() throws IOException {
		  String excelPath=projPath+"\\DataSheet\\Data.xlsx";
			 String sheetName="AuctionAssetPurchase";
		  Object data[][]=dP.testData(excelPath,sheetName);	  
		return data;
	  }
}
