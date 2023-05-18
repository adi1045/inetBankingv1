package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletCustomerpage 
{
	WebDriver ldriver;

	//constructor
 public	DeletCustomerpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
 
 //identify WebElement
 
  @FindBy(linkText = "Delete Customer")
  WebElement lnkDeletCust;
  
  @FindBy(name="cusid")
  WebElement txtDeleCustID;
  
  @FindBy(name="AccSubmit")
  WebElement txtAccSubmit;
  
  //action on webElement 
  
  public void clickOnDeleteCustomer()
  {
	  lnkDeletCust.click();
  }
  
  public void custIDDelete(String cid)
  {
	  txtDeleCustID.sendKeys(cid);
  }
  
  public void clickOnSubmit()
  {
	  txtAccSubmit.click();
  }
         
}
