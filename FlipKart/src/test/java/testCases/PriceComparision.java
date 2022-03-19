package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import amazonPageElems.AmazonPageElems;
import data.TestData;
import flipkartPageElements.HomePageElems;
import flipkartPageElements.MyCartPage;
import flipkartPageElements.ProductDetailPageElems;
import flipkartPageElements.ProductListingPageElems;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import master.Main;
import master.Support;
import master.UIActionUtils;

import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceComparision {
	WebDriver driver;
	Main main =new Main();
	HomePageElems homePage;
	ProductListingPageElems productListingPage;
	ProductDetailPageElems productDetailPage;
	MyCartPage myCartPage;
	AmazonPageElems amazonPage;
	UIActionUtils action = new UIActionUtils();
	Support support = new Support();
	
 @Test(dataProvider="PriceCompare",dataProviderClass = TestData.class, description ="Compare the price of a product from both flipkart and amazon", enabled =true)
  public void FlipKartAddToCart(String FlipkartProductListName, String AmazonProductListName) throws InterruptedException {
	 homePage= new HomePageElems(driver);
	 productListingPage=new ProductListingPageElems(driver);
	 productDetailPage=new ProductDetailPageElems(driver);
	 myCartPage = new MyCartPage(driver);
	 amazonPage=new AmazonPageElems(driver);
	 
	 action.SendKeys(driver, homePage.SearchFld, 20, AmazonProductListName);
	 homePage.SearchFld.sendKeys(Keys.ENTER);
	 action.WaitUntilElementVisible(20, productListingPage.FirstProductInTheList, driver);
	 WebElement PriceInListFlipKart = productListingPage.ProductsPriceInList(FlipkartProductListName, driver);
	 String PriceInFlipkartStr=action.GetText(driver, PriceInListFlipKart, 20);
	 int PriceInFlipkart=support.SpecialCharstringToNum(PriceInFlipkartStr);
	 
	 driver.navigate().to("https://www.amazon.in/");
	 action.SendKeys(driver, amazonPage.ProductSearchFld, 20, AmazonProductListName);
	 amazonPage.ProductSearchFld.sendKeys(Keys.ENTER);
	 action.WaitUntilElementVisible(20, amazonPage.FirstProductInTheList, driver);
	 WebElement PriceInListAmazon = amazonPage.ProductsPriceInList(AmazonProductListName, driver);
	 String PriceInAmazonStr=action.GetText(driver, PriceInListAmazon, 20);
	 int PriceInAmazon=support.SpecialCharstringToNum(PriceInAmazonStr);
	 
	 if(PriceInFlipkart==PriceInAmazon) {
		 System.out.println ("Price in Amazon: "+PriceInAmazon);
		 System.out.println ("Price in Flipkart: "+PriceInFlipkart);
		 System.out.println("Both prices are equal");
	 }
	 else if(PriceInFlipkart>PriceInAmazon)
	 {
		 System.out.println ("Price in Amazon: "+PriceInAmazon);
		 System.out.println ("Price in Flipkart: "+PriceInFlipkart);
		 System.out.println("Price in Flipkart is higher than Amazon");
	 }
	 else {
		 System.out.println ("Price in Amazon: "+PriceInAmazon);
		 System.out.println ("Price in Flipkart: "+PriceInFlipkart);
		 System.out.println("Price in Amazon is higher than Flipkart");
	 }
	
  }
 
 @BeforeMethod
 public void beforeMethod() {
	 homePage = new HomePageElems(driver);
	 action.Click(driver,homePage.PopUpCloseBtn, 20);
}
 
 @Parameters({"browser", "AppUrl"})
 @BeforeClass
 public void beforeClass(String browser, String url)throws IOException, InterruptedException {
		  driver= main.driver(browser, url);
  }
	
  @AfterClass
  public void afterClass() throws InterruptedException {
	driver.quit();
  }

  


}
