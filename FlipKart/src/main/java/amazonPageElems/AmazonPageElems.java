package amazonPageElems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class AmazonPageElems {
		WebDriver PageElemsdriver;
		public  AmazonPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
	
		@FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
		public WebElement ProductSearchFld;
		
		@FindBy(xpath="(//span[@class=\"a-price-whole\"])[1]")
		public WebElement FirstProductInTheList;
		
		
		
	
		
		public WebElement ProductsPriceInList(String ProductName, WebDriver driver) throws InterruptedException {
			PageElemsdriver = driver;
			WebElement ReqProductsPriceInList=PageElemsdriver.findElement(By.xpath("(//a/span[contains(text(),\""+ProductName+"\")])//ancestor::div[2]//span[@class=\"a-price-whole\"]"));
			return ReqProductsPriceInList;	
			
		}
			

		
		
	}