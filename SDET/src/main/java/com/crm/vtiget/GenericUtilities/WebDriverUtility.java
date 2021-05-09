package com.crm.vtiget.GenericUtilities;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	/*
	 * this method helps to switch to another window
	 * @parameter driver
	 * @parameter partialWindowTitle
	 */
	
	public void SwitchToWindow(WebDriver driver, String PartialWindowTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(PartialWindowTitle)) 
			{
				break;
			}}}
	
	/*
	 * this method is used for 20 sec for page loading
	 * @parameter is driver
	 */
	
	public void WaitUntilPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/*
	 * this method is used for wait for 20 sec till element is visible
	 * @parameter is driver
	 * @parameter element
	 */
	public void WaitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/*
	 * this method is used to wait for element to be clicked
	 * @parameter is element
	 * @thows throwable
	 */
	public void WaitAndClick(WebElement element) throws Throwable 
	{
		int count=0;
		while(count<40) {
			try {
				element.click();
				break;
			}
			catch (Throwable e)
			{
				Thread.sleep(5000);
				count++;
			}}}
	
	
	/*
	 * this  method used to handle dropdown using visible text
	 * @parameter element
	 * @parameter option
	 */
	public void selectoption(WebElement element, String option) 
	{
		Select select=new Select(element);
		select.selectByValue(option);
	}
	
	/*
	 * this method used perform mouseover action
	 * @parameter driver
	 * parameter element
	 */
	
	public void Mouseover(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	/*
	 * this method used to accept alert
	 * @parametr driver
	 */
	public void AcceptAlert(WebDriver driver )
	{
	 driver.switchTo().alert().accept();
	}
	
	
	/*
	 * this method used to dismiss alert
	 * @parametr driver
	 */
	public void CancelAlert(WebDriver driver )
	{
	 driver.switchTo().alert().dismiss();
	}

	/*
	 * this method used for dropdown
	 * @parameter element
	 * @parameter index
	 */
	public void selectOption(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/*
	 * this method used for right click operation
	 * @parameter driver
	 * @element
	 */
	
	public void RightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/*
	 * this method used for scrollbar
	 * @parameter driver
	 * @parameter element
	 */
	public void ScrollToWebElement(WebDriver driver, WebElement element)
	{
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		
	}
	/*
	 * this method used to switch to frame
	 * @parameter driver
	 * @index
	 */
	public void SwitchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/*
	 * this method used to switch to frame
	 * @parameter driver
	 * @element
	 */
	public void SwitchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void SwitchToFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	/*
	 * take screenshot
	 * @parameter driver, screenshotfome
	 */
	public void TakeScrennShot(WebDriver driver, String screenshotname) throws Throwable 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotname+".png");
		Files.copy(src, dest);
	}
	
	
	public void PressEnterKey() throws Throwable
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyPress(KeyEvent.VK_ENTER);
		
	}
}
