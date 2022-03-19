package data;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestData {
	ExcelDataProvider dP =new ExcelDataProvider();
	String projPath =System.getProperty("user.dir");
	
@DataProvider(name="AddToCartAndIncreaseQuantity")
	  public Object[][] TC001Data() throws IOException {
		  String excelPath=projPath+"\\DataSheet\\Data.xlsx";
		  String sheetName="FlipKartAddToCart";
		  Object data[][]=dP.testData(excelPath,sheetName);	  
		  return data;
	  }

@DataProvider(name="PriceCompare")
public Object[][] TC002Data() throws IOException {
	  String excelPath=projPath+"\\DataSheet\\Data.xlsx";
	  String sheetName="PriceCompare";
	  Object data[][]=dP.testData(excelPath,sheetName);	  
	  return data;
}

}
