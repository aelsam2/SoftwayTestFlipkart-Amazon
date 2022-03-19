package flipkartPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class ProductListingPageElems {
		WebDriver PageElemsdriver;
		public  ProductListingPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="(//div[@class=\"_4rR01T\"])[1]")
		public WebElement FirstProductInTheList;
		
		public WebElement ProductsPriceInList(String ProductName, WebDriver driver) throws InterruptedException {
			PageElemsdriver = driver;
			WebElement ReqProductsPriceInList=PageElemsdriver.findElement(By.xpath("(//div[contains(text(),\"APPLE iPhone 13 (Midnight, 128 GB)\")])//ancestor::div[2]//div[@class=\"_30jeq3 _1_WHN1\"]"));
			return ReqProductsPriceInList;	
			
		}
	}