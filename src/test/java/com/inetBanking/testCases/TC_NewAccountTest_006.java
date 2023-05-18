package com.inetBanking.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.BalanceEnquiryPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewAccountPage;
                                                  //popup problem
public class TC_NewAccountTest_006 extends BaseClass 
{
	@Test
    public void NewAccount() throws InterruptedException 
    {
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Enter UserName");
	
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();
    	
		NewAccountPage newAcc=new NewAccountPage(driver);
		
		newAcc.clickNewAccount();
		logger.info("click on new Accoout");
		
		Thread.sleep(4000);
		if(driver.findElements(By.xpath("//*[@id='dismiss-button']")).size()!=0)
		{
			newAcc.clickOnDismiss();	
			logger.info("click on popUp");
		}
		
	    newAcc.setCustID("122647");
		logger.info("set customer ID");
		
		newAcc.setAccType("Current");               //drop down
		logger.info("Set account Type");
		
		newAcc.setInitialDeposit("10000");
		logger.info("set Initial deposit ");
		
		newAcc.clickOnSubmit2();
		logger.info("click on submit button");
		
		BalanceEnquiryPage balanceEn=new BalanceEnquiryPage(driver);
		logger.info("BalanceEnquiryPage start");
		
		balanceEn.clickOnBalanceEnquiry();
		logger.info("click On Balance Enquiry");

		
		balanceEn.addAccountNo("122647");
		logger.info("add Account Number");

		balanceEn.clickOnAccSubmit();
		logger.info("click On Acc Submit");

		logger.info("BalanceEnquiryPage end");
    }
	
}
