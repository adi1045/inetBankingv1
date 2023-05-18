package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ReadExcelFile;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider ="inetBankingDataDriven")
   public void LoginDDT(String user,String pwd) throws IOException
   {
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("Enter UserName");
	
		lp.setPassword(pwd);
		logger.info("Enter password");
		lp.clickSubmit(); 
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			captureScreenShot(driver,"LoginDDT");
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
		
   }		
		
	  public boolean isAlertPresent() //user defined method createsd to check alert is present or not
		{
		   
		  try {
			driver.switchTo().alert();
			return true;
		  }
			catch(NoAlertPresentException e)
		  {
				return false;
		  }
		  
		}
	   	
	@DataProvider(name="inetBankingDataDriven")	
	 String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/inetBankingDataDriven.xlsx";
		
		int rownum=ReadExcelFile.getRowCount(path,"sheet1");
		int colcount=ReadExcelFile.getColCount(path,"sheet1",1);
		System.out.println("rownum count="+rownum);
		System.out.println("rownum count="+colcount);
		String logindata[][]=new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ReadExcelFile.getCellValue(path, "sheet1", i, j);//1 0
			}
		}                //LOOP WRONG
		
		return logindata;
	}
}
