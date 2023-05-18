package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	
	WebDriver ldriver;
	
	 public NewAccountPage (WebDriver rdriver)
		{
			ldriver=rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
	 
	 //Identify WebElement
	 
	 @FindBy(linkText ="New Account")
	 WebElement lnkNewAccount;
	 
	 
	 @FindBy(xpath="//*[@id=\"dismiss-button\"]")
	 WebElement clickOnDimiss;
	 	 
	 @FindBy(name="cusid")
	 WebElement textCustId;
	 
	 @FindBy(name="selaccount")
	 WebElement accountType;
	 
	 @FindBy(name="inideposit")
	 WebElement textInideposit;
	 
	 @FindBy(name="button2")
	 WebElement textSubmit2;

	 //action on webElement
	 public void clickNewAccount()
		{
		 lnkNewAccount.click();
		}
	
	 public void clickOnDismiss()              //popup
		{
		 clickOnDimiss.click();
		} 
	 	 
	 public void setCustID(String custID)
		{
		 textCustId.sendKeys(custID);
		}
	 	 
	    public void setAccType(String accType) {                   //drop down 
		    Select selectAccountType = new Select(accountType);
		    selectAccountType.selectByVisibleText(accType);
		}
	 
	 public void setInitialDeposit(String deposit)
		{
		 textInideposit.sendKeys(deposit);
		}
	 
	 public void clickOnSubmit2()
		{
		 textSubmit2.click();
		}
	 		
}
