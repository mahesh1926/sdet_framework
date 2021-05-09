package com.crm.vtiget.GenericUtilities;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.vtiger.pomclass.HomePage;

public class baseclass {
	public WebDriver driver;
	 public Excelutility eUtil=new Excelutility();
	 public FileUtility fUtil=new FileUtility();
	 public WebDriverUtility wUtil=new WebDriverUtility();
	 public static WebDriver sdriver;
	 public HomePage homepage;
	 
		
	 @BeforeSuite(groups= {"smoketest","regressiontest"})
	 public void configBS() {
	  //connect to DB
	 }
	 
	 @BeforeTest(groups= {"smoketest","regressiontest"})
	 public void configBT() {
	  //launch browser in parallel mode
	 }
	 
	 @BeforeClass(groups= {"smoketest","regressiontest"})
	 public void configBC() throws Throwable {
	  String browserName=fUtil.getPropertyKeyValue("browser");
	  if(browserName.equalsIgnoreCase("firefox")) {
	   driver = new FirefoxDriver();
	  }
	  else if(browserName.equalsIgnoreCase("chrome")) {
	   driver=new ChromeDriver();
	  }
	  else if(browserName.equalsIgnoreCase("IE")) {
	   driver=new InternetExplorerDriver();
	  }
	  sdriver=driver;
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	 }
	 @BeforeMethod(groups= {"smoketest","regressiontest"})
	 public void setUp() throws Throwable {
	  String url=fUtil.getPropertyKeyValue("url");
	  String username=fUtil.getPropertyKeyValue("username");
	  String password=fUtil.getPropertyKeyValue("password");
	  driver.get(url);
	  //login to the application
	  WebElement username1 = driver.findElement(By.name("user_name"));
		username1.clear();
		driver.findElement(By.name("user_name")).sendKeys(username);
		WebElement userpassword1 = driver.findElement(By.name("user_password"));
		userpassword1.clear();
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		
	 }
	 @AfterMethod(groups= {"smoketest","regressiontest"})
	 public void tearDown() throws Throwable {
	  WebElement administrator=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  wUtil.Mouseover(driver, administrator);
	  wUtil.WaitAndClick(driver.findElement(By.xpath("//a[text()='Sign Out']")));
	  
	 }
	 
	 @AfterClass(groups= {"smoketest","regressiontest"})
	 public void configAC() {
	  driver.quit();
	 }
	 
	 @AfterTest(groups= {"smoketest","regressiontest"})
	 public void configAT() {
	  //close driver ref in parallel mode
	 }
	 
	 @AfterSuite(groups= {"smoketest","regressiontest"})
	 public void configAS() {
	  // close DB connection
	 }


}
