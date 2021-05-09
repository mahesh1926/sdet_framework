package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.vtiget.GenericUtilities.WebDriverUtility;

public class GotoAdvanceSearch extends WebDriverUtility {
	WebDriver driver;
	
	public GotoAdvanceSearch(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(linkText = "Go to Advanced Search")
	private WebElement AdvanceSearchLink;

		
	@FindBy(xpath = "//select[@class='repBox']")
	private WebElement optionDropDown;
	
	@FindBy(xpath = "//input[@class='repBox']")
	private WebElement inputTF;
	
	@FindBy(xpath = "(//input[@value=' Search Now '])[2]")
	private WebElement searchnowTAB;
	
	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[3]/a")
	private WebElement oppercolumList;

	public WebElement getAdvanceSearchLink() {
		return AdvanceSearchLink;
	}

	
	

	public WebElement getOppercolumList() {
		return oppercolumList;
	}




	public WebElement getOptionDropDown() {
		return optionDropDown;
	}

	public WebElement getInputTF() {
		return inputTF;
	}

	public WebElement getSerachnowTAB() {
		return searchnowTAB;
	}
	
	public void selectoptionequals(String option, String input) throws Throwable {
		AdvanceSearchLink.click();
		WaitUntilPageLoad(driver);
		optionDropDown.sendKeys(option);
		inputTF.sendKeys(input);
		searchnowTAB.click();
		
		
	}
	
	
		
		
	
	
	
}	



