package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage 
{
	WebDriver ldriver;	
	//constructor	
	
		public FundTransferPage(WebDriver rdriver) 
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}		
		//identify webElement
		
		@FindBy(xpath="//a[normalize-space()='Fund Transfer']")
		WebElement lnkFundTransfer;
		
		//@FindBy(xpath="//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']")
		//WebElement lnkDismiss;
		
		@FindBy(xpath="//div[@id='ad_position_box']")
		WebElement lnkDismiss;
		
		@FindBy(xpath="//input[@name='payersaccount']")
		WebElement txtPayersAccount;
		
		@FindBy(xpath="//input[@name='payeeaccount']")
		WebElement txtPayeeAccount;
		
		@FindBy(xpath="//input[@name='ammount']")
		WebElement txtAmmount;
		
		@FindBy(xpath="//input[@name='desc']")
		WebElement txtDescription;
		
		@FindBy(xpath="//input[@name='AccSubmit']")
		WebElement txtAccSubmit;
		
		//action on webElement
		
		public void clickOnFundTransfer()
		{
			lnkFundTransfer.click();
		}
		
		public void iframe()
		{
			//ldriver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
			lnkDismiss.click();   //  google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0
		}		                                    //ad_iframe
		public void payersAccount(String payersacc)
		{
			txtPayersAccount.sendKeys(payersacc);
		}
		
		public void payeeAccount(String payeeacc)
		{
			txtPayeeAccount.sendKeys(payeeacc);
		}
		
		public void amount(String amo)
		{
			txtAmmount.sendKeys(amo);
		}
		
		public void description(String desc)
		{
			txtDescription.sendKeys(desc);
		}
		
		public void clickOnAccSubmit()
		{
			txtAccSubmit.click();
		}
		
}
