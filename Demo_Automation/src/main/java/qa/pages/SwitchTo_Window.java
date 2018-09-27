package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import qa.base.TestBase;

public class SwitchTo_Window extends TestBase
{
   
	@FindBy(xpath="//a[contains(text(),'Open New Tabbed Windows')]")
	WebElement newTabWind;
	
	@FindBy(xpath="//div[@id='Tabbed']/a/button")
	WebElement click1;
	
	@FindBy(xpath="//a[contains(text(),'Open Seperate Multiple Windows')]")
	WebElement multiWinds;
	
	@FindBy(xpath="//*[@id='Multiple']/button")
	WebElement click2;
	
	public SwitchTo_Window()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateNewTabWindow()
	{
		String text=newTabWind.getText();
		Assert.assertEquals(text, "Open New Tabbed Windows");
		newTabWind.click();
		click1.click();
		
		for(String win:driver.getWindowHandles())
		{
			System.out.println(win);
		}
		
		
		//driver.switchTo().window("df4261d0-ab16-4f17-9fde-13ba6e310997");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().defaultContent();
		
		
	}
	
	public void validateMultipleWindows()
	{
		String text=multiWinds.getText();
		Assert.assertEquals(text, "Open Seperate Multiple Windows");
		
		String parent=driver.getWindowHandle();
		multiWinds.click();
		click2.click();
		
		
		
		for(String win:driver.getWindowHandles())
		{
			if(win!=parent)
			{
				driver.switchTo().window(win);
			}
		}
		
	}
	
}
