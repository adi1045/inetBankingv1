package com.inetBanking.testCases;
 
import java.io.File;              //comment in xml file  <!--     -->
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
 {

	public static WebDriver driver; 
	public static Logger logger;   //Added logger   //not working
	 
	 ReadConfig rConfig=new ReadConfig();
	
     public String baseURL=rConfig.getBaseURL();
	 public String username=rConfig.getUserName();
	 public String password=rConfig.getPassword();
	 public String browser=rConfig.getbrowser();   
	 
	 
	 
	@BeforeClass
	 public void setup()
		 {
		// for logging 	   
		logger = LogManager.getLogger(BaseClass.class.getName());
		// logger = Logger.getLogger("inetbanking"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
			   switch(browser.toLowerCase())
			   {
			   case "chrome":			   
				   WebDriverManager.chromedriver().setup();
				   driver=new ChromeDriver();
				   break;
				   
			   case "msedge":   			   
				   WebDriverManager.edgedriver().setup();
				   driver=new EdgeDriver();
				   break;
				   
	           case "firefox":   			   
				   WebDriverManager.firefoxdriver().setup();
				   driver=new FirefoxDriver();
				   break; 
				 
				default:
					driver=null;
					break;
				   
			   }
			     //implicit wait of 10 secs
	           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		  
			   
		   
			 //open url			
				driver.get(baseURL);
			    logger.info("url opened");
			   
			    //maximize screen
			    driver.manage().window().maximize();		    
			    
		 }
	
	@AfterClass
    public static void tearDown()  
    {
   	 driver.close();
   	 driver.quit();
    }  
	 public void captureScreenShot(WebDriver driver,String testName) throws IOException 
	 {
		 // step1: convert webDriver object to TakesScreenShot interface 
		     TakesScreenshot screenshot =((TakesScreenshot)driver);

	     //Call getScreenshotAs method to create image file

		     File src=screenshot.getScreenshotAs(OutputType.FILE);
	         //Move image file to new destination

	             File dest=new File(System.getProperty("user.dir")+"//Screenshots//" + testName + ".png");

	             //Copy file at destination

	             FileUtils.copyFile(src, dest);	 
	 }
	 
	    @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            captureScreenShot(driver, result.getName());
	        }
	        driver.quit();
	    }

	 
     public String randomestring()
		{
		   String generatedString=RandomStringUtils.randomAlphabetic(8);
			return (generatedString);
		}
	public static  String randomeNum()
		{
		   String generatedString2=RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
	
	/* 	public void frame()
	{
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"); //switching the frame by ID
	  WebElement element1=driver.findElement(By.xpath("//div[@id='dismiss-button']"));  
	  
	  driver.switchTo().frame("ad_iframe"); //switching the frame by ID
	  WebElement element2=driver.findElement(By.xpath("//div[@id='dismiss-button']"));  
	*/
		
	/*	public void frame() {
			  if (driver.findElements(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0")).size() > 0) {
			    driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"); //switching the frame by ID
			    WebElement element1 = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
			    element1.click();
			  } else if (driver.findElements(By.id("ad_iframe")).size() > 0) {
			    driver.switchTo().frame("ad_iframe"); //switching the frame by ID
			    WebElement element2 = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
			    element2.click(); // click the element in second iframe
			  } else {
			    // handle case when neither iframe is present
			  }
			}*/

	
	
	}

