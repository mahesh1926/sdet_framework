package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiget.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	
	public HomePage(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
		this.driver=driver;
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OppertunitiesLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIMG;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLink;


	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getOppertunitiesLink() {
		return OppertunitiesLink;
	}

	public WebElement getAdministratorIMG() {
		return administratorIMG;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
		
	/*
	 * click on contact link
	 */
	
	public void clickoncontactLink() {
		ContactLink.click();
	}
	
	/*
	 * this method id used to click on oppertunities
	 */
	public void clickonoppertunitiesLink() {
		OppertunitiesLink.click();
	}
	/*
	 * this method used to click on signout
	 */
	public void clickonsignout() {
		Mouseover(driver, administratorIMG);
			signoutLink.click();
	}

}
