package qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.RegisterPage;

public class TestRegister extends TestBase
{
  RegisterPage rp;
  
	@BeforeMethod
	public void Initialization()
	{
		initialization();
		rp=new RegisterPage();
	}
	
	
	@Test
	public void ValidateRegisterPage()
	{
		rp.RegisterPageValidation();
	}
	
	@Test(dependsOnMethods= {"ValidateRegisterPage"})
	public void ValidateFileUpload() throws Exception
	{
		rp.FileUpload();
	}
	
	@Test
	public void ValidateWebTableLink()
	{
		rp.webTableLinkValidation();
	}
	
	@AfterMethod
	public void tear()
	{
		//driver.close();
	}
	
}
