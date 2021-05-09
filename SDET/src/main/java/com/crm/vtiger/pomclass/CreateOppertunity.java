package com.crm.vtiger.pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiget.GenericUtilities.WebDriverUtility;

public class CreateOppertunity extends WebDriverUtility {
	
	WebDriver driver;
	public CreateOppertunity(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement ContactSaluation;
	
	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement oppertynitynameTF;
	
	@FindBy(xpath = "//select[@id='related_to_type']")
	private WebElement relatedtoDropDown;

	@FindBy(xpath ="//select[@name='sales_stage']")
	private WebElement salesstageDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	@FindBy(id = "search_txt")
	private WebElement searchTF;
	
	@FindBy(name = "search")
	private WebElement searchBTN;

	public WebElement getContactSaluation() {
		return ContactSaluation;
	}

	public WebElement getOppertynitynameTF() {
		return oppertynitynameTF;
	}

	public WebElement getRelatedtoDropDown() {
		return relatedtoDropDown;
	}

	public WebElement getSalesstageDropDown() {
		return salesstageDropDown;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}
	
	public void createoppertunitywithcontact(String input, String prospecting,String contacts, 
			String childwindowText,String lastname,String parentwindowText) {
		oppertynitynameTF.sendKeys(input);
		salesstageDropDown.sendKeys(prospecting);
		relatedtoDropDown.sendKeys(contacts);
		ContactSaluation.click();
		SwitchToWindow(driver, childwindowText);
		searchTF.sendKeys(lastname);
		searchBTN.click();
		driver.findElement(By.linkText(lastname)).click();
		SwitchToWindow(driver, parentwindowText);
		saveBTN.click();
		
	}	
}
