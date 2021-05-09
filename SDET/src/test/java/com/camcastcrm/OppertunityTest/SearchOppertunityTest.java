package com.camcastcrm.OppertunityTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.vtiget.GenericUtilities.Excelutility;
import com.crm.vtiget.GenericUtilities.JavaUtility;
import com.crm.vtiget.GenericUtilities.baseclass;



public class SearchOppertunityTest extends baseclass {
	@Test(groups="smoketest")
	public void Contact() throws Throwable  {
	
	
	
	//creating contacts
			String FirstName = fUtil.getPropertyKeyValue("firstname");
			String LastName = fUtil.getPropertyKeyValue("lastname");
			
					driver.findElement(By.linkText("Contacts")).click();
					driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
					driver.findElement(By.name("firstname")).sendKeys(FirstName);
					driver.findElement(By.name("lastname")).sendKeys(LastName);
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

}
	@Test(groups="regressiontest")
	
	public void CreateOppertunity() throws Throwable {
		Excelutility eutil=new Excelutility();
		String contacts = eutil.getExcelTestData("sheet1", 1, 2);
		String prospecting = eutil.getExcelTestData("sheet1",1, 3);
			
		//navigate to oppertunities
		
		wUtil.WaitUntilPageLoad(driver);
		driver.findElement(By.linkText("Opportunities")).click();
		//filling opertunity name
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		String input = "abc"+JavaUtility.GetRandomData();
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(input);
		
		
		//selecting contact from dropdown
		WebElement relatedto = driver.findElement(By.xpath("//select[@id='related_to_type']"));
		wUtil.selectoption(relatedto, contacts);
		
		WebElement salesstage = driver.findElement(By.xpath("//select[@name='sales_stage']"));
		wUtil.selectoption(salesstage, prospecting);
		//handling window
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		wUtil.SwitchToWindow(driver,"Contacts");
		wUtil.WaitUntilPageLoad(driver);//wait till page get load
		driver.manage().window().maximize();
		
		//in pop
		String contactname="nanjundappa";
		driver.findElement(By.id("search_txt")).sendKeys(contactname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("kavitha nanjundappa")).click();
		
		//switch to main window
		wUtil.SwitchToWindow(driver, "Potentials");
		
		//click on user radiobutton		
		driver.findElement(By.xpath("(//input[@name='assigntype'])[1]")).click();
		
		//selecting salesstage to prospecting
		WebElement salesstage1 = driver.findElement(By.xpath("//select[@name='sales_stage']"));
		wUtil.selectoption(salesstage1,"Prospecting");
				
		//click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	@Test
	public void SearchOppertunitywithequals() {
		
		String input = "abc"+JavaUtility.GetRandomData();
		//click on oppertunities module
		driver.findElement(By.linkText("Opportunities")).click();
				
		
		//click on advancesearch link
		driver.findElement(By.linkText("Go to Advanced Search")).click();
		

		
		//selecting organization name from dropdown
		WebElement orgname = driver.findElement(By.xpath("//select[@onchange='updatefOptions(this, \"fop0\");addRequiredElements(0);']"));
		wUtil.selectOption(orgname, 11);
		
		//select equals to in dropdown
		WebElement equalstab = driver.findElement(By.xpath("//select[@class='repBox']"));
		wUtil.selectOption(equalstab, 1);
		
		//search with text abc
		driver.findElement(By.xpath("//input[@class='repBox']")).sendKeys(input);
		
		//click on seachnow button
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();		
	}
	@Test (groups="regressiontest")
	
	public void SearchOppertunitywithNotequal() {
		
		String input = "abc"+JavaUtility.GetRandomData();
		//click on oppertunities module
		driver.findElement(By.linkText("Opportunities")).click();
		
	
		
		//click on advancesearch link
		
		driver.findElement(By.linkText("Go to Advanced Search")).click();
		

		
		//selecting organization name from dropdown
		WebElement orgname = driver.findElement(By.xpath("//select[@onchange='updatefOptions(this, \"fop0\");addRequiredElements(0);']"));
		wUtil.selectOption(orgname, 11);
		
		//select equals to in dropdown
		WebElement equalstab = driver.findElement(By.xpath("//select[@class='repBox']"));
		wUtil.selectOption(equalstab, 2);
		
		//search with text abc
		driver.findElement(By.xpath("//input[@class='repBox']")).sendKeys(input);
		
		//click on seachnow button
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
		wUtil.WaitUntilPageLoad(driver);
		
			}
	@Test (groups="regressiontest")
	
	 public void SearchOppertunitywithStartsWith() {
		 
			String input = "abc"+JavaUtility.GetRandomData();
		//click on oppertunities module
			driver.findElement(By.linkText("Opportunities")).click();
					
			
			//click on advancesearch link
			driver.findElement(By.linkText("Go to Advanced Search")).click();
			

			
			//selecting organization name from dropdown
			WebElement orgname = driver.findElement(By.xpath("//select[@onchange='updatefOptions(this, \"fop0\");addRequiredElements(0);']"));
			wUtil.selectOption(orgname, 11);
			
			//select equals to in dropdown
			WebElement startswith = driver.findElement(By.xpath("//select[@class='repBox']"));
			wUtil.selectOption(startswith, 3);
			
			//search with text abc
			driver.findElement(By.xpath("//input[@class='repBox']")).sendKeys(input);
			
			//click on seachnow button
			driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
			
			
			}
	@Test (groups="regressiontest")
	
	public void SearchOppertunitywithEndswith() {

		String input = "abc"+JavaUtility.GetRandomData();
		//click on oppertunities module
		driver.findElement(By.linkText("Opportunities")).click();
				
		
		//click on advancesearch link
		driver.findElement(By.linkText("Go to Advanced Search")).click();
		

		
		//selecting organization name from dropdown
		WebElement orgname = driver.findElement(By.xpath("//select[@onchange='updatefOptions(this, \"fop0\");addRequiredElements(0);']"));
		wUtil.selectOption(orgname, 11);
		
		//select equals to in dropdown
		WebElement endswith = driver.findElement(By.xpath("//select[@class='repBox']"));
		wUtil.selectOption(endswith, 4);
		
		//search with text abc
		driver.findElement(By.xpath("//input[@class='repBox']")).sendKeys(input);
		
		//click on seachnow button
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
		
		
		}

}
