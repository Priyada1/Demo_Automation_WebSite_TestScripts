package qa.pages;



import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import qa.base.TestBase;

public class WebTablePage extends TestBase
{
	@FindBy(css=".ui-grid-cell-contents.ui-grid-header-cell-primary-focus")
	List<WebElement> cols;
	@FindBy(xpath="//div/h1[contains(text(),'Automation Demo Site')]")
	 WebElement heading;
	@FindBy(xpath="//a[contains(text(),'SwitchTo')]")
	WebElement switchTo;
	@FindBy(xpath="//a[contains(text(),'Alerts')]")
	WebElement Alrt;
	
	@FindBy(xpath="//a[contains(text(),'Windows')]")
	WebElement Wind;
	
	
	
	public WebTablePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void webTableTitle()
	{
		System.out.println(driver.getTitle());
	}
	
	public void numberOfColumns()
	{
	    int num=cols.size();
	    System.out.println("number of columns: "+num);
	    Assert.assertEquals(num, 6);
	    
	    
	}
	
	public void exportFirstNamefromWebTabletoExcel() throws Exception
	{
		WebElement itemPP=driver.findElement(By.xpath("//div[contains(@class,'ui-grid-pager-row-count-picker')]/select"));
		Select sel=new Select(itemPP);
		sel.selectByValue("number:30");
		
		WebElement maxPage=driver.findElement(By.xpath("//span[contains(@class,'ui-grid-pager-max-pages-number')]"));
		
		String totalPageSize=maxPage.getText();
		String[] size=totalPageSize.split(" ");
		for(int i=0;i<size.length;i++)
		{
		System.out.println(size[i]);
		}
	
		int pageSize=Integer.parseInt(size[1]);
		System.out.println("Maximum Page available in WebTable :"+pageSize);
		
		
		
		List<String> li1=new ArrayList<String>();
		
		for(int i=1;i<=pageSize;i++)
		{
			List<WebElement> fnList=driver.findElements(By.xpath("//div[contains(@id,'uiGrid-0006-cell')]"));
			
			for(int j=0;j<fnList.size();j++)
			{
				String fName=fnList.get(j).getText();
				
				li1.add(fName);
				
				
				
				System.out.println(fName);
			}
			
		 WebElement next=driver.findElement(By.className("ui-grid-pager-next"));
		 next.click();
			
		
		}
		
	 Iterator<String> itr=li1.listIterator();
	 Workbook wb=new XSSFWorkbook();
	 Sheet sh=wb.createSheet();
	 int row=0;
	 
	 while(itr.hasNext())
	 {
		 sh.createRow(row++).createCell(0).setCellValue(itr.next());
		 
	 }
	 
	 FileOutputStream fout=new FileOutputStream("G:/TestData/FirNameDemo11.xlsx");
	 wb.write(fout);
	 fout.close();

	 
	 
	 
	 
		
		//wb.cloneSheet(arg0);
		
		
	}
	
	public void colorValidationOfHeading()
	{
		String color=heading.getCssValue("font-size");
		System.out.println(color);
		
	}
	
	public void switchToAlertLinkValidation()
	{
		System.out.println("Switch To Balidation Strated");
		Actions act=new Actions(driver);
		act.moveToElement(switchTo);
		String element=switchTo.getText();
		System.out.println(element );
		Assert.assertEquals(element, "SwitchTo");
		act.moveToElement(Alrt).build().perform();
		Alrt.click();
		
		
		
		
	}
	
	public void switchTo_Window_Page()
	{
		Actions act=new Actions(driver);
		act.moveToElement(switchTo);
		act.moveToElement(Wind).build().perform();
		Wind.click();
	}

}
