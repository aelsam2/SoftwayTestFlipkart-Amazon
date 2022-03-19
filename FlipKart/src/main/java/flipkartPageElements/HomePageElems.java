package flipkartPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class HomePageElems {
		WebDriver PageElemsdriver;
		public  HomePageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
	
		@FindBy(xpath="//button[contains(text(),\"✕\")]")
		public WebElement PopUpCloseBtn;
		
		@FindBy(xpath="//input[@name=\"q\"]")
		public WebElement SearchFld;
		
		
	
		
		public WebElement SelectReqMinute(int minute, WebDriver driver) throws InterruptedException {
			PageElemsdriver = driver;
			WebElement ReqMinute=PageElemsdriver.findElement(By.xpath("(//span[contains(text(),\""+minute+"\")])[1]"));
			return ReqMinute;	
			
		}
			

		
		
	}