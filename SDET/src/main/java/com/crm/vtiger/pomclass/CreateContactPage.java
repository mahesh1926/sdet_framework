package com.crm.vtiger.pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiget.GenericUtilities.WebDriverUtility;



public class CreateContactPage extends WebDriverUtility{
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(name = "lastname")
	private WebElement lastNameTF;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	

	

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * create contact with mandatory fields
	 * @param lastName
	 */
	public void createContact(String lastName) {
		
		lastNameTF.sendKeys(lastName);
		saveBtn.click();
	}
	
	}


