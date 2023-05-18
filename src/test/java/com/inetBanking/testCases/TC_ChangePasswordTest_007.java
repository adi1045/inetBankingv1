package com.inetBanking.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.ChangePassword;
import com.inetBanking.pageObjects.LoginPage;

public class TC_ChangePasswordTest_007 extends BaseClass
{    
	@Test 
         public void changePassword() throws InterruptedException
         {
		     LoginPage lp=new LoginPage(driver);
		
		      lp.setUserName(username);
		      logger.info("Enter UserName");
	
		        lp.setPassword(password);
		       logger.info("Enter password");
		       lp.clickSubmit(); 
		       logger.info("");
		       ChangePassword changpwd=new ChangePassword(driver);
		       logger.info("change password start");
		       
		       
				if(driver.findElements(By.xpath("//div[@id='dismiss-button']")).size()!=0)
				{
					changpwd.dismiss();	
					logger.info("click on popUp");
				}
		       changpwd.changePassword();
		       
		       changpwd.oldPassword("cricket@11");
		       logger.info("Enter oldPassword");
		       
		       changpwd.newPassword("cricket@12");
		       logger.info("Enter New Password");
		       
		       changpwd.confirmPassword("cricket@12");
		       logger.info("Enter confirm password");
		       
		       changpwd.confirmSubmit();
		       if (changpwd.isAlertPresent()) {
		            logger.info("Password change successful");
		            Assert.assertTrue(true);
		        } else {
		            logger.info("Password change failed");
		            Assert.assertTrue(false);
		        }
		      	       
		       
         }
}
