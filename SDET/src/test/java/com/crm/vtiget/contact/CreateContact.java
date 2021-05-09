package com.crm.vtiget.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.pomclass.ContactInformationPage;
import com.crm.vtiger.pomclass.CreateContactPage;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.contactpage;
import com.crm.vtiget.GenericUtilities.baseclass;



public class CreateContact extends baseclass{
	
	@Test(groups="smoketest")
	public void CreatingContact() throws Throwable {
		
	//creating contacts
	
	String LastName = fUtil.getPropertyKeyValue("lastname");
	
	//navigate to contacts 
		homepage =new HomePage(driver);
		homepage.clickoncontactLink();
		
	//create contact (+ symbol)
		contactpage contactpage=new contactpage(driver);
		contactpage.clickOnCreateContactIMG();
	
	//navigate to createcontact page
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.createContact(LastName);
		
		//verify
		ContactInformationPage contactinfopage=new ContactInformationPage(driver);
		String actualcontact=contactinfopage.getcontacttext();
		Assert.assertTrue(actualcontact.contains(LastName));		
	}
	}