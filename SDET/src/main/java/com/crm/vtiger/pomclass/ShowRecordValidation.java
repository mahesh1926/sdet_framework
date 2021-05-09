package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShowRecordValidation {
	
	WebDriver driver;
	
	public ShowRecordValidation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[3]/a")
	private WebElement showrecordTABLE;

	public WebElement getShowrecordTABLE() {
		return showrecordTABLE;
	
	}
	
	public String opperNameTable(String input) {
		String actualvalue = showrecordTABLE.getText();
		return actualvalue;
		
		
	}
	
	
	

	
	

}
