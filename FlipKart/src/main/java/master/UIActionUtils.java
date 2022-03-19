package master;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UIActionUtils {
	WebDriver driver;
	Wait wait;
    FluentWait<WebDriver> fluentWait;
	
	public void Click(WebDriver driver, WebElement element, int timeout)
	{
		fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofMillis(100))
	            .ignoring(WebDriverException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}
	
	public void SendKeys(WebDriver driver, WebElement element, int timeout, String value)
	{
	   fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofMillis(100))
	            .ignoring(WebDriverException.class);
		
	   fluentWait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		
	}
	
	public String GetText(WebDriver driver, WebElement element, int timeout)
	{
	   fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofMillis(100))
	            .ignoring(WebDriverException.class);
		
	   fluentWait.until(ExpectedConditions.visibilityOf(element));
		String Text=element.getText();
		return Text;
		
	}
	
	@SuppressWarnings("deprecation")
	public WebDriver WaitUntilElementVisible (int N, WebElement WE, WebDriver driver) {
		wait = new WebDriverWait(driver, N);
		wait.until( ExpectedConditions.visibilityOf(WE));
		return driver;
	}



}
