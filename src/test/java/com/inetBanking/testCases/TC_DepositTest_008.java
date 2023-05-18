package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DepositPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_DepositTest_008 extends BaseClass
{
	@Test
   public void deposit() throws IOException
   {
		//logger.info("");
		LoginPage lp=new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Enter UserName");
	
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();
		
		DepositPage deposit=new DepositPage(driver);
		logger.info("deposit testcase start");
		deposit.clickOnDeposit();
		logger.info("click on deposit button");

		deposit.acccountNumber("122647");
		logger.info("add acount number");
		
		deposit.ammount("10000");
		logger.info("add amount");
		
		deposit.description("add mn");
		logger.info("add description");
		
		
		deposit.clickSubmit();
		logger.info("click on submit button");
		
		logger.info("deposit testcase end");
   }
}
