package qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.RegisterPage;
import qa.pages.SwitchTo_Alert;
import qa.pages.WebTablePage;

public class TestSwitchTo extends TestBase
{
    SwitchTo_Alert alrt;
    RegisterPage rp;
    WebTablePage wtp;
    
	@BeforeMethod
	public void setUP()
	{
		initialization();
		alrt=new SwitchTo_Alert();
		rp=new RegisterPage();
		wtp=new WebTablePage();
		wtp.switchToAlertLinkValidation();
		
		
		
	}
	@Test(enabled=false)
	public void validateAlertWithOK_CancelButton()
	{
		alrt.validationOfAlert_OK_Cancel();
	}
	@Test(enabled=false)
	public void validateAlertWithTestBox() throws Exception
	{
		alrt.validationOfAlertWithTextBox();
	}
	
	
}
