package com.crm.vtiget.contact;

import org.testng.annotations.Test;

import com.crm.vtiger.pomclass.GotoAdvanceSearch;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.ShowRecordValidation;
import com.crm.vtiget.GenericUtilities.Excelutility;
import com.crm.vtiget.GenericUtilities.FileUtility;
import com.crm.vtiget.GenericUtilities.JavaUtility;
import com.crm.vtiget.GenericUtilities.baseclass;

public class SearchOppertunityTest extends baseclass{

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
	

	


