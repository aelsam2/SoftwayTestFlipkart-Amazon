package master;


import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Main {
	WebDriver driver;
	Properties prop =new Properties();
	String projPath =System.getProperty("user.dir");
	WebDriverWait wait ;
	
  
	public WebDriver driver(String browser, String url)throws IOException {
	  
	  if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", projPath+"/Drivers/geckodriver.exe");
		driver=new FirefoxDriver();
    	driver.get(url);
    	driver.manage().window().maximize();
	  }

	  else if(browser.equalsIgnoreCase("chrome")){
		  
			System.setProperty("webdriver.chrome.driver", projPath+"/ChromeDriver/chromedriver.exe");
			driver = new ChromeDriver();	
		     	driver.get(url);
	    	driver.manage().window().maximize();
		  }
	  else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", projPath+"/Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
	    	driver.get(url);
	    	driver.manage().window().maximize();
		  }
    	return driver;
	}
	

}
