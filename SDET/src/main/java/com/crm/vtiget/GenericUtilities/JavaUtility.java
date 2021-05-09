package com.crm.vtiget.GenericUtilities;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*
	 * generate random number
	 */
	
	public static String GetRandomData()
	{
		Random random=new Random();
		int ran = random.nextInt(1000);
		return " "+ran;
		
	}
	/*
	 * generate current system date
	 */
	
	public String GetCurrentSystemDate() {
		Date date=new Date();
			String currentdate = date.toString();
		return currentdate;
			
		
	}

}
