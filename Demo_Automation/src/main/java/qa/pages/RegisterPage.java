package qa.pages;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import qa.base.TestBase;

public class RegisterPage extends TestBase 
{
	
	@FindBy(xpath="//input[@id='imagesrc']")
	WebElement browse;
	
	@FindBy(xpath="//a[contains(text(),'WebTable')]")
	WebElement webTabLink;
	
	
	
	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterPageValidation()
	{
		String title=driver.getTitle();
		System.out.println("home page title is: "+ title);
		Assert.assertEquals("Register", title);

		
	}
	
	public void FileUpload() throws Exception
	{
		browse.click();
		//browse.sendKeys("C:/Users/Priyadarshi/Desktop/FileUpload.jpg");
		
	
			Robot rbt=new Robot();
			rbt.setAutoDelay(5000);
			
			WebDriverWait wait= new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			
			
			StringSelection stringsel1= new StringSelection("G:/TestData/WebDriver_Architecture.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringsel1,null);
			
			rbt.setAutoDelay(3000);
			
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			
			rbt.keyRelease(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			
			rbt.setAutoDelay(3000);
			
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			
		}
	
	public WebTablePage webTableLinkValidation()
	{
		webTabLink.click();
		return new WebTablePage();
	}

}
