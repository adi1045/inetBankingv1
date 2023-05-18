package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {

	WebDriver ldriver;
	
//constructor	
	
	public DepositPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
//identify webElement
	
	@FindBy(xpath="//a[normalize-space()='Deposit']")
	WebElement lnkDepositElement;
	
	@FindBy(name="accountno")
	WebElement txtAccountno;
	
	@FindBy(name="ammount")
	WebElement txtAmmount;
	
	@FindBy(name="desc")
	WebElement txtDescription;
	
	@FindBy(name="AccSubmit")
	WebElement txtAccSubmit;
	
//action on webElement
	
	public void clickOnDeposit()
	{
		lnkDepositElement.click();
	}
	
	public void acccountNumber(String accNumber)
	{
		txtAccountno.sendKeys(accNumber);
	}
	
	public void ammount(String amo)
	{
		txtAmmount.sendKeys(amo);
	}
	
	public void description(String desc)
	{
		txtDescription.sendKeys(desc);
	}
	
	public void clickSubmit()
	{
		txtAccSubmit.click();
	}

}
