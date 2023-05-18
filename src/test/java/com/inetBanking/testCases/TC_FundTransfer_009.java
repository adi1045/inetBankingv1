package com.inetBanking.testCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.FundTransferPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_FundTransfer_009 extends BaseClass
{
	   @Test
       public void fundFransfer()
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
	 		
	 		FundTransferPage fundTransfer=new FundTransferPage(driver);
	 		logger.info("FundTransferPage start");
	 		
	 		fundTransfer.clickOnFundTransfer();
	 		logger.info("click On Fund Transfer");
	 		
	       // fundTransfer.iframe();
	 	    logger.info("click on iframe");
	 	 			 			 		
	 		fundTransfer.payersAccount("122647");
	 		logger.info("add a payers Account ");
	 		
	 		fundTransfer.payeeAccount("122650");
	 		logger.info("add a payee Account");
	 		
	 		fundTransfer.amount("10");
	 		logger.info("add a amount");
	 		
	 		fundTransfer.description("am mn");
	 		logger.info("add a discription");
	 		
	 		fundTransfer.clickOnAccSubmit();
	 		logger.info("click on account submit");
	 		
	 		WebElement element=driver.findElement(By.xpath("//p[@align='center']"));
	 		element.getText();
	 		
	 		
	 		Assert.assertEquals("Fund Transfer Details",element.getText());
        }
	     
}
