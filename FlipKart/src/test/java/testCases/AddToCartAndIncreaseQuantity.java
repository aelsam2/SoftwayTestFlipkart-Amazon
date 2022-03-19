package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import data.TestData;
import flipkartPageElements.HomePageElems;
import flipkartPageElements.MyCartPage;
import flipkartPageElements.ProductDetailPageElems;
import flipkartPageElements.ProductListingPageElems;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import master.Main;
import master.UIActionUtils;

import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddToCartAndIncreaseQuantity {
	WebDriver driver;
	Main main =new Main();
	HomePageElems homePage;
	ProductListingPageElems productListingPage;
	ProductDetailPageElems productDetailPage;
	MyCartPage myCartPage;
	UIActionUtils wait = new UIActionUtils();
	UIActionUtils action = new UIActionUtils();
	
 @Test(dataProvider="AddToCartAndIncreaseQuantity",dataProviderClass = TestData.class, description ="Add a product and increase the quantity from the cart"
 		+ " and also fetch the price from detail page and from my cart page", enabled =true)
 
  public void FlipKartAddToCart(String ProductName) throws InterruptedException {
	 homePage= new HomePageElems(driver);
	 productListingPage=new ProductListingPageElems(driver);
	 productDetailPage=new ProductDetailPageElems(driver);
	 myCartPage = new MyCartPage(driver);
	 
	 action.SendKeys(driver, homePage.SearchFld, 20, ProductName);
	 homePage.SearchFld.sendKeys(Keys.ENTER);
	 action.Click(driver, productListingPage.FirstProductInTheList, 20);
	 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(newTab.get(1));
	 String PriceInDetailPage=action.GetText(driver, productDetailPage.ProductPrice, 20);
	 System.out.println(PriceInDetailPage);
	 action.Click(driver, productDetailPage.AddToCartBtn, 20);
	 action.Click(driver,myCartPage.QuantityAddBtn, 20);
	 Thread.sleep(500); //just for the price to get updated
	 String PriceInMyCartPage=action.GetText(driver, myCartPage.TotalPriceInMyCart, 20);
	 System.out.println(PriceInMyCartPage);

	
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
