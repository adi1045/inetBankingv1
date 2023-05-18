package com.inetBanking.testCases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
@Test	
public void loginTest() throws IOException
  {
		LoginPage lp=new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Enter UserName");
	
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager Homepage"))
		{
		     Assert.assertTrue(true);	
		     logger.info("Login test pass");
		}else 
		{    
			captureScreenShot(driver,"loginTest");
			Assert.assertTrue(false);
			
			logger.info("Login test failed");
		}
   }

}
