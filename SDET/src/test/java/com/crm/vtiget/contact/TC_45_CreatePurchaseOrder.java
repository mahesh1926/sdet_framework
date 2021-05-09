package com.crm.vtiger.AllocatedTestCases;



import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.vtiger.Genericutils.BaseClass;
import com.crm.vtiger.pomclass.CreateNewVendor;
import com.crm.vtiger.pomclass.CreateProductPage;
import com.crm.vtiger.pomclass.CreatePurchaseOrderPage;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.ProductPage;
import com.crm.vtiger.pomclass.ProductsInfoPage;
import com.crm.vtiger.pomclass.PurchaseOrderpage;
import com.crm.vtiger.pomclass.VendorInfoPage;
import com.crm.vtiger.pomclass.VendorsPage;

/**
 * 
 * @author Mahesh
 *
 */
public class TC_45_CreatePurchaseOrder extends BaseClass  {
	@Test
	public void CreatePurchaseOrder() throws Throwable{
		
		
				//mouuseovering/creating vendor
				HomePage homepage=new HomePage(driver);
				homepage.clickOnMore();
				homepage.clickVendor();
				VendorsPage vp=new VendorsPage(driver);
				vp.ClickonVendor();
				
				String vendorname = eUtil.getExcelData("Sheet1", 7, 2);
				CreateNewVendor cvn=new CreateNewVendor(driver);
				cvn.CreateVendor(vendorname);
				
				//verification
				VendorInfoPage vip=new VendorInfoPage(driver);
				String actualVendorName = vip.getvendorInfo();
				Assert.assertTrue(actualVendorName.contains(vendorname));
				
				
				//creating product
				homepage.clickOnnproduct();
				ProductPage productpage=new ProductPage(driver);
				productpage.clickonProducts();
				String product = eUtil.getExcelData("Sheet1", "TC_45", "ProductName");
				CreateProductPage createproduct=new CreateProductPage(driver);
				createproduct.createproduct(product);
				
				//verification
				ProductsInfoPage prodInfoPage=new ProductsInfoPage(driver);
				String ActualproductName = prodInfoPage.getproductinfo();
				Assert.assertTrue(ActualproductName.contains(product));
				
				//creating PO
				homepage.clickOnMore();
				homepage.clickonPurchaseOrder();
				PurchaseOrderpage PoPage=new PurchaseOrderpage(driver);
				PoPage.clickOnPurchaseOrderbtn();
				
				String sub = eUtil.getExcelData("Sheet1", 7, 4);
				String cityname = eUtil.getExcelData("Sheet1", 9, 2);
				String Qty = eUtil.getExcelData("Sheet1", 11, 2); 
				String price = eUtil.getExcelData("Sheet1", 13, 2);
				CreatePurchaseOrderPage createPoPage=new CreatePurchaseOrderPage(driver);
				createPoPage.createPO(sub, vendorname, "Vendors", "PurchaseOrder&action", "Products&action", cityname, product);
				createPoPage.Billing(Qty, price);
											
	}
}
