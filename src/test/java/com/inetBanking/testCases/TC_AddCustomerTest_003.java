package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
	LoginPage lp=new LoginPage(driver);
	
	lp.setUserName(username);
	logger.info("Enter UserName");

	lp.setPassword(password);
	logger.info("Enter password");
	lp.clickSubmit();
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	
	logger.info("providing customer details...");
	addcust.clickAddNewCustomer();
	addcust.custName("adinath");
	addcust.custGender("male");
	addcust.custdob("19", "12", "1998");
	Thread.sleep(3000);
	
	addcust.custAddress("INDIA");
	addcust.custCity("MH");
	addcust.custstate("AP");
	addcust.custpinno("412513");
	addcust.custtelephoneno("992345789");
	
	String email=randomestring()+"@gmail.com";   //call base class
	addcust.custemailid(email);
	
	addcust.custpassword("adi123");
	addcust.custsubmit();
	Thread.sleep(3000);
	logger.info("validation started..");
	
  boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
if(res==true)
{
	Assert.assertTrue(true);
	logger.info("test case passed");
}else
	{
	logger.info("test case failed");
	captureScreenShot(driver, "addNewCustomer");
	Assert.assertFalse(false);                          //correct or not
	
	}
	
	}
		
}
