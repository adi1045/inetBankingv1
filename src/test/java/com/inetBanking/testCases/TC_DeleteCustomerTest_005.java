package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DeletCustomerpage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_DeleteCustomerTest_005 extends BaseClass
{
	@Test
	public void deleteCustomer() 
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Enter UserName");

		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();
		
		DeletCustomerpage deleteCust=new DeletCustomerpage(driver);
		
		deleteCust.clickOnDeleteCustomer();
		logger.info("click on Delete Customer");
		
		deleteCust.custIDDelete("2274");
		logger.info("Delete custmer Id");
				
		deleteCust.clickOnSubmit();
		logger.info("click on submit button");
		
		driver.switchTo().alert().accept();
	     logger.info("clicked on alert button");
	      
	}

}
