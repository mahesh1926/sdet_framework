package com.crm.vtiget.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.pomclass.ContactInformationPage;
import com.crm.vtiger.pomclass.CreateContactPage;
import com.crm.vtiger.pomclass.CreateOppertunity;
import com.crm.vtiger.pomclass.GotoAdvanceSearch;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.OppertunitiesPage;
import com.crm.vtiger.pomclass.ShowRecordValidation;
import com.crm.vtiger.pomclass.contactpage;
import com.crm.vtiget.GenericUtilities.Excelutility;
import com.crm.vtiget.GenericUtilities.FileUtility;
import com.crm.vtiget.GenericUtilities.JavaUtility;
import com.crm.vtiget.GenericUtilities.baseclass;

public class CreateOppertunityWithContact extends baseclass{
	
	
		
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
	@Test

	public void createoppertunitywithcontact() throws Throwable {
		Excelutility eutil=new Excelutility();
		String contacts = eutil.getExcelTestData("sheet1", 1, 2);
		String prospecting = eutil.getExcelTestData("sheet1",1, 3);
		String input =fUtil.getPropertyKeyValue("value")+JavaUtility.GetRandomData();
		String childwindowText="Contacts";
		String parentwindowText="Potentials";
		String LastName = fUtil.getPropertyKeyValue("lastname");
		
		//click on oppertunity link
		homepage =new HomePage(driver);
		homepage.clickonoppertunitiesLink();
		
		//click on create oppertunity
		
		OppertunitiesPage oppertunitiespage=new OppertunitiesPage(driver);
		oppertunitiespage.clickOnCreateOppertunitiesIMG();
		
		//navigate to create oppertunity page
		CreateOppertunity createopper=new CreateOppertunity(driver);
		createopper.createoppertunitywithcontact(input, prospecting, contacts, childwindowText, LastName, parentwindowText);
				
	}
	@Test
	
	public void search() throws Throwable

{
	
	Excelutility eutil=new Excelutility();
	FileUtility futil=new FileUtility();
	String option =futil.getPropertyKeyValue("option");
	String input =fUtil.getPropertyKeyValue("value")+JavaUtility.GetRandomData();
	
	//click on oppertunity link
	homepage =new HomePage(driver);
	homepage.clickonoppertunitiesLink();
	
	GotoAdvanceSearch advancesearch =new GotoAdvanceSearch(driver);
				advancesearch.selectoptionequals(option, input);
				
			ShowRecordValidation showrecordvalidation =new ShowRecordValidation(driver);
			showrecordvalidation.opperNameTable(input);
			}}
