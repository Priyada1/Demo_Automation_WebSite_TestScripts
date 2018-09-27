package qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.RegisterPage;
import qa.pages.WebTablePage;

public class TestWebTable extends TestBase
{
	RegisterPage rp;
	WebTablePage wtp;

	
	@BeforeMethod
	public void setUP() 
	{
		initialization();
		rp=new RegisterPage();
		wtp=new WebTablePage();
		rp.webTableLinkValidation();
		
	}
	
	@Test(enabled=false)
	public void validateWebTableTitle()
	{
		wtp.webTableTitle();
	}
	
	@Test(enabled=false)
	public void validateNumberOfColumns()
	{
		wtp.numberOfColumns();
	}
	
	@Test
	public void exportFirstNameToExcel() throws Exception
	{
		wtp.exportFirstNamefromWebTabletoExcel();
	}
	
	@Test(enabled=false)
	public void validateHeadingColor()
	{
		wtp.colorValidationOfHeading();
	}
}
