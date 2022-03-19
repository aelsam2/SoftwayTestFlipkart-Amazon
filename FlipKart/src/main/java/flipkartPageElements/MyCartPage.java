package flipkartPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class MyCartPage {
		WebDriver PageElemsdriver;
		public  MyCartPage(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="(//button[@class=\"_23FHuj\"])[2]")
		public WebElement QuantityAddBtn;
		
		@FindBy(xpath="//div[@class=\"Ob17DV _3X7Jj1\"]/span")
		public WebElement TotalPriceInMyCart;
		
		@FindBy(xpath="@FindBy(xpath=\"//div[@class=\\\"Ob17DV _3X7Jj1\\\"]/span\")\r\n"
				+ "		public WebElement TotalPriceInMyCart;")
		public WebElement QuantityUpdateMessagePopUp;
		
		
		
		
		
	}