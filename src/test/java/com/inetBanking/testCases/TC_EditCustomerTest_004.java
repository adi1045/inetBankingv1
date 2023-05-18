package com.inetBanking.testCases;



import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass 
{
	@Test
	 public void editCustomer() 
	 {
		 LoginPage lP =new LoginPage(driver);
				 lP.setUserName(username);
		  logger.info("Enter UserName");
					
		         lP.setPassword(password);	       
		  logger.info("Enter password");
		     	
		         lP.clickSubmit();
		         
		 EditCustomerPage  editCust=new EditCustomerPage(driver);
		 logger.info("Edit customer details...");
		 
		         editCust.clickEditCustomer();
		         
		         editCust.custIDAdd("2274");
		         editCust.custSubmit();
		         		       
		         editCust.custCity("Latur");
		       logger.info("change city");   
		       
		         editCust.custState("maharashtra");
		      logger.info("change state");
		      
		         editCust.submit();
		      logger.info("submit All");
		      
		      driver.switchTo().alert().accept();
		      logger.info("clicked on alert button");     
	 }

}
