package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.BalanceEnquiryPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_BalanceEnquiry_010 extends BaseClass
{
	@Test
    public void BalanceEnquiry()
    {
		//logger.info("");
 		LoginPage lp=new LoginPage(driver);
 		logger.info("Login page start");
 		lp.setUserName(username);
 		logger.info("Enter UserName");
 	
 		lp.setPassword(password);
 		logger.info("Enter password");
 		lp.clickSubmit(); 
 		logger.info("Login page end");
 		
 		BalanceEnquiryPage balEnq=new BalanceEnquiryPage(driver);
 		balEnq.clickOnBalanceEnquiry();
 		balEnq.addAccountNo("122647");
 		balEnq.clickOnAccSubmit();
 	
    }
}
