package com.camcastcrm.OppertunityTest;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiget.GenericUtilities.baseclass;



public class CreateContact extends baseclass{
	
	@Test(groups="smoketest")
	public void CreatingContact() throws Throwable {
		
	//creating contacts
	String FirstName = fUtil.getPropertyKeyValue("firstname");
	String LastName = fUtil.getPropertyKeyValue("lastname");
	
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("firstname")).sendKeys(FirstName);
			driver.findElement(By.name("lastname")).sendKeys(LastName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

}

}

