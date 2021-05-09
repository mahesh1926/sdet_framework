package com.crm.comcast.ProductTest;

import org.testng.annotations.Test;

public class CreateProductTest {
	
	
	@Test(groups = "smokeTest")
	public void createProductWithNAmeTest() {
		String browser = System.getProperty("browser");
		String enviorment = System.getProperty("env");
		
		System.out.println("BROWSER=======>"+browser);
		System.out.println("enviorment=======>"+enviorment);
		System.out.println("execute createProductWithNAmeTest");
 	}

	
	
	@Test(groups = "regressionTest")

	public void createProductWithIDTest() {
		System.out.println("execute createProductWithIDTest");
 	}
	
	
	@Test
	public void deleteProduct() {
		System.out.println("execute deleteProduct");
 	}
}
