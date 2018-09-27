package qa.testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.SwitchTo_Window;
import qa.pages.WebTablePage;

public class TestSwitchTo_Window extends TestBase
{
   SwitchTo_Window Swth_Window;
   WebTablePage wtp;
	@BeforeMethod
	public void setUP()
	{
		initialization();
		Swth_Window=new SwitchTo_Window();
		wtp=new WebTablePage();
		wtp.switchTo_Window_Page();
		
	}
	
	@Test(enabled=false)
	public void ValidateSwitchTo_Window_Page()
	{
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Frames & windows");
	}
	
	@Test(enabled=false)
	public void validateNewTabWindow()
	{
		Swth_Window.validateNewTabWindow();
	}
	
	@Test
	public void validateMultipleWindowButton()
	{
		Swth_Window.validateMultipleWindows();
	}
	
}
