package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceEnquiryPage {
		
		WebDriver ldriver;
		
		 public BalanceEnquiryPage (WebDriver rdriver)
			{
				ldriver=rdriver;
				
				PageFactory.initElements(rdriver, this);
			}
		 
		 //Identify WebElement
		 
		 @FindBy(linkText = "Balance Enquiry")
		 WebElement lnkBalanceEnquiry;
		 
		 @FindBy(name="accountno")
		 WebElement textAccountNo;
		 
		 
		 @FindBy(name="AccSubmit")
		 WebElement textAccSubmit;
		 
		 //action on WebElement 
		 
		 //action on webElement
		 public void clickOnBalanceEnquiry()
			{
			 lnkBalanceEnquiry.click();
			}
		 
		 public void addAccountNo(String accountNo)
			{
			 textAccountNo.sendKeys(accountNo);
			}
		 
		 public void clickOnAccSubmit()
			{
			 textAccSubmit.click();
			}
}
