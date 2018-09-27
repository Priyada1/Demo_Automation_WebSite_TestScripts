package qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.base.TestBase;

public class SwitchTo_Alert extends TestBase
{
    @FindBy(xpath="//a[contains(text(),'Alert with OK & Cancel ')]")
    WebElement Ok_Cancel_btn;
    @FindBy(css=".btn.btn-primary")
    WebElement confirmBox;
    @FindBy(xpath="//a[contains(text(),'Alert with Textbox')]")
    WebElement alrt_textBox;
    @FindBy(css=".btn.btn-info")
    WebElement promptBox;
	
	
	
	
	public SwitchTo_Alert()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void validationOfAlert_OK_Cancel()
	{
		Ok_Cancel_btn.click();
		//#337ab7
		System.out.println(Ok_Cancel_btn.getCssValue("background-color"));
		System.out.println(confirmBox.getCssValue("background-color"));
		
		confirmBox.click();
		
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
	 }
	public void validationOfAlertWithTextBox() throws Exception
	{
		alrt_textBox.click();
		promptBox.click();
		
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.sendKeys("Hey How are you");
		Thread.sleep(4000);
		alt.dismiss();
		
		
	}
	
	
	
	
}
