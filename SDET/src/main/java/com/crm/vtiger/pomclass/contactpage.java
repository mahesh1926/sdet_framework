package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactpage {
	public contactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactIMG;

	public WebElement getCreateContactIMG() {
		return createContactIMG;
	}
	/**
	 * click on create contact image
	 */
	public void clickOnCreateContactIMG() {
		createContactIMG.click();
	}
	

}
