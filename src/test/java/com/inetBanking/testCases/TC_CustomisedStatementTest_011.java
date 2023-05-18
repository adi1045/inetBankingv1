package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.CustomisedStatementPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_CustomisedStatementTest_011 extends BaseClass
{
	@Test
 public void CustomisedStatementTest()
 {
		logger.info("");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Enter UserName");

		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();
		
	CustomisedStatementPage  customisedSta=new CustomisedStatementPage(driver);
	logger.info("CustomisedStatementPage start");
	
	customisedSta.clickOnCustomisedStatement();
	logger.info("add On Customised Statement");
	
	customisedSta.clickOnAcountNo("12264");
	logger.info("add On Acount Number");
	
	customisedSta.clickOnFdate("01","05","2023");
	logger.info("add On Fdate");
	
	customisedSta.clickOntdate("10","05","2023");
	logger.info("add On tdate");
	
	customisedSta.clickAmountLowerlimit("10");
	logger.info("add Amount Lower limit");
	
	customisedSta.clickNumtransaction("10");
	logger.info("add Num transaction");
	
	customisedSta.clickAccSubmit();
	logger.info("click on Account Submit");
	
 
 }
}
