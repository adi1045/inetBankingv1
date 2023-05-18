package com.inetBanking.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ChangePassword 
{
	WebDriver ldriver;
	
	 public ChangePassword (WebDriver rdriver)
		{
			ldriver=rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
	 
	 //identify webElement
	 
	 @FindBy(linkText ="Change Password")
	 WebElement lnkchangepwd;
	 
	 @FindBy(xpath="//div[@id='dismiss-button']")
	 WebElement txtDismissElement;
	 
	 @FindBy(xpath="//input[@name='oldpassword']")         
	 WebElement txtoldPassword;
	 
	 @FindBy(name="newpassword")
	 WebElement txtnewpassword;
	 
	 @FindBy(name="confirmpassword")
	 WebElement txtconfirmpassword;
	 
	 @FindBy(name="sub")
	 WebElement btnsubmit;
	 
	 //action on webElement
	 
	 public void changePassword()
	 {
		 lnkchangepwd.click(); 
	 }
	 
	 public void dismiss()
	 {
		 txtDismissElement.click(); 
	 }
	 
	 public void oldPassword(String old)
	 {
		 txtoldPassword.sendKeys(old);
	 }
	 
	 public void newPassword(String New )
	 {
		 txtnewpassword.sendKeys(New); 
	 }
	 
	 public void confirmPassword(String confirm)
	 {
		 txtconfirmpassword.sendKeys(confirm);
	 }
	 
	 public void confirmSubmit()
	 {
		 btnsubmit.click(); 
		 
	 }
	 public boolean isAlertPresent()
	 {
		 try {
	            Alert alert = ldriver.switchTo().alert();
	            alert.accept();
	            return true;
	        } catch (NoAlertPresentException e) {
	            return false;
	        }
	 }
	
}
