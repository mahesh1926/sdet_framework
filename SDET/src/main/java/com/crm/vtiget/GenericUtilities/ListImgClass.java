package com.crm.vtiget.GenericUtilities;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImgClass implements ITestListener{
	
	

	public void onTestFailure(ITestResult result)
	
	
	{
		String currentDate=new Date().toString().replace(":","_").replace(" ","_");
		String failedTestName=result.getMethod().getMethodName();

		EventFiringWebDriver ed=new EventFiringWebDriver(baseclass.sdriver);
		File srcImg=ed.getScreenshotAs(OutputType.FILE);
		File DestImg=new File("./screenshot/"+failedTestName+"_"+currentDate+".png");
		try
		{
			FileUtils.copyFile(srcImg, DestImg);
		}
		catch(IOException e) {}


	}

}
