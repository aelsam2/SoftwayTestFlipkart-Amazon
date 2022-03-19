package flipkartPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class ProductDetailPageElems {
		WebDriver PageElemsdriver;
		public  ProductDetailPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="//div[@class=\"_30jeq3 _16Jk6d\"]")
		public WebElement ProductPrice;
		
		@FindBy(xpath="//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
		public WebElement AddToCartBtn;
		
	}