package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppertunitiesPage {
	
	WebDriver driver;
	public OppertunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createoppertunityImg;

	public WebElement getCreateoppertunityImg() {
		return createoppertunityImg;
	}
	
	public void clickOnCreateOppertunitiesIMG() {
		createoppertunityImg.click();
	}

}
