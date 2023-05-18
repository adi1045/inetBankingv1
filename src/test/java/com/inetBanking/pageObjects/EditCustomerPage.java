package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver ldriver;

	//constructor
public	EditCustomerPage(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	//identify webElement
	
	@FindBy(linkText = "Edit Customer")
	WebElement lnkEditCustomer;
	
	@FindBy(name="cusid")
	WebElement txtCustID;
	
	@FindBy(name="AccSubmit")
	WebElement txtAccSubmit;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtState;
	
	@FindBy(name="sub")
	WebElement txtsub;
	
	 public void clickEditCustomer()
	   {
		 lnkEditCustomer.click();
	   }
	
	 public void custIDAdd(String custID)
	   {
		 txtCustID.sendKeys(custID);
	   }
	 
	 public void custSubmit()
	   {
		 txtAccSubmit.click();
	   }
	 
	 public void custCity(String eCity )
	   {
		 txtState.clear();
		 txtState.sendKeys(eCity);
	   }
	 
	 public void custState(String eState )
	   {
		 txtcity.clear();
		 txtcity.sendKeys(eState);
	   }
	 
	 public void submit()
	   {
		 txtsub.click();
	   }
	 
}
