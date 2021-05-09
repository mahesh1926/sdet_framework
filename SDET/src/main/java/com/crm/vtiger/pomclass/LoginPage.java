package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver Driver) {
	PageFactory.initElements(Driver, this);
}
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginBTN;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBTN() {
		return loginBTN;
	}
	
	/*
	 * this method used to login to vtiget application
	 * @para username
	 * @para password
	 */
	
	public void login(String username, String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBTN.click();
	}	
}
