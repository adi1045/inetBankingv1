package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomisedStatementPage 
{
      WebDriver ldriver;
      
      public  CustomisedStatementPage(WebDriver rdriver)
      {
    	  ldriver=rdriver;
    	   PageFactory.initElements(rdriver, this);
      }
      
      //identify webElement     
      @FindBy(xpath="//a[normalize-space()='Customised Statement']")
      WebElement lnkCustomisedStatement;
      
      @FindBy(xpath="//input[@name='accountno']")
      WebElement accountno;
      
      @FindBy(xpath="//input[@name='fdate']")
      WebElement fdate;
      
      @FindBy(xpath="//input[@name='tdate']")
      WebElement tdate;
      
      @FindBy(xpath="//input[@name='amountlowerlimit']")
      WebElement amountlowerlimit;
      
      @FindBy(xpath="//input[@name='numtransaction']")
      WebElement numtransaction;
      
      @FindBy(xpath="//input[@name='AccSubmit']")
      WebElement AccSubmit;
      
      
      //action on webElement
      
      public void clickOnCustomisedStatement()
      {
    	  JavascriptExecutor js = (JavascriptExecutor) ldriver;
    	// Scrolling down the page till the element is found		
          js.executeScript("arguments[0].scrollIntoView();", lnkCustomisedStatement);
    	  lnkCustomisedStatement.click();  
      }
      
      public void clickOnAcountNo(String accNo)
      {
    	  accountno.sendKeys(accNo);  
      }
      
      public void clickOnFdate(String dd,String mm,String yy)
      {
    	  fdate.sendKeys(dd); 
    	  fdate.sendKeys(mm); 
    	  fdate.sendKeys(yy); 
      }
      
      public void clickOntdate(String dd,String mm,String yy)
      {
    	  tdate.sendKeys(dd); 
    	  tdate.sendKeys(mm); 
    	  tdate.sendKeys(yy);  
      }
      
      public void clickAmountLowerlimit(String amount)
      {
    	  amountlowerlimit.sendKeys(amount);  
      }
      
      public void clickNumtransaction(String num)
      {
    	  numtransaction.sendKeys(num);  
      }
      
      public void clickAccSubmit()
      {
    	  AccSubmit.click(); 
      }
      
}
