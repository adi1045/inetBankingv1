package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	//constructor
 public	AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
 
  //identify webElement
 
   @FindBy(linkText="New Customer")
   WebElement lnkAddNewCustomer;
   
   @FindBy(name="name")
   WebElement txtName;
   
   @FindBy(name="rad1")
   WebElement rdGender;
   
   @FindBy(name="dob")
   WebElement txtdob;
   
   @FindBy(name="addr")
   WebElement txtAddress;
   
   @FindBy(name="city")
   WebElement txtcity;
   
   @FindBy(name="state")
   WebElement txtstate;
   
   @FindBy(name="pinno")
   WebElement txtpippo;
   
   @FindBy(name="telephoneno")
   WebElement txttelephoneno;
   
   @FindBy(name="emailid")
   WebElement txtemailid;
   
   @FindBy(name="password")
   WebElement txtpassword;
   
   @FindBy(name="sub")
   WebElement btnsubmit;
  
   //action on WebElement
   
   public void clickAddNewCustomer()
   {
	   lnkAddNewCustomer.click();
   }
    
   public void custName(String cname)
   {
	   txtName.sendKeys(cname);
   }
   
   public void custGender(String cgender)
   {
	   rdGender.click();
   }
   
   public void custdob(String mm,String dd,String yy)
   {
	   txtdob.sendKeys(mm);
	   txtdob.sendKeys(dd);
	   txtdob.sendKeys(yy);
   }
  
   public void custAddress(String caddress)
   {
	   txtAddress.sendKeys(caddress);
   }
   
   public void custCity(String ccity)
   {
	   txtcity.sendKeys(ccity);
   }
   
   public void custstate(String cstate)
   {
	   txtstate.sendKeys(cstate);
   }
   
   public void custpinno(String pinno)
   {
	   txtpippo.sendKeys(pinno);
   }
   
   public void custtelephoneno(String telephoneno)
   {
	   txttelephoneno.sendKeys(telephoneno);
   }
   
   public void custemailid(String emailid)
   {
	   txtemailid.sendKeys(emailid);
   }
   
   public void custpassword(String password)
   {
	   txtpassword.sendKeys(password);
   }
   
   public void custsubmit()
   {
	   btnsubmit.click();
   }
   


}
