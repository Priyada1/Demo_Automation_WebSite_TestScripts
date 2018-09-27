package qa.base;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public static WebDriver driver;
	
	
	
	public void initialization()
	{
		
		System.setProperty("webdriver.firefox.marionette", "G:/geckoDriver/geckodriver-v0.19.1-win64/geckodriver.exe");
		driver=new FirefoxDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");//Method Overriding(Get() method is available 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);//Method OverLoading
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
	/*	Dimension d=new Dimension(400, 600);
		
		driver.manage().window().setSize(d);
		*/
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
