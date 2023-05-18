package com.inetBanking.utilities;
	import java.io.File;
	import java.sql.Date;
	import java.text.SimpleDateFormat;
//listnear class used to generate Extent report
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentListenerClass implements ITestListener {

		ExtentSparkReporter htmlReporter;
		ExtentReports reports;
		ExtentTest test;
		
		public void configureReport()
		{
			ReadConfig readConfig=new ReadConfig();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));//time stamp
			String reportName="MyStoreTestReport."+timeStamp+".html";
			htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" +reportName);//specify location
			reports=new ExtentReports();
			reports.attachReporter(htmlReporter);
			
			//add system information/environment info to reports
			reports.attachReporter(htmlReporter);
			reports.setSystemInfo("Machine", "testpc1");
			reports.setSystemInfo("OS", "window10");
			reports.setSystemInfo("browser", readConfig.getbrowser());//also use browser
			reports.setSystemInfo("user name", "adi");
			
			//configuration to change look and feel of report
			
			htmlReporter.config().setDocumentTitle("InetBanking Test Project");//title of the report
			htmlReporter.config().setReportName("Fuctional Test Automation Report");//name of the report
			
			htmlReporter.config().setTheme(Theme.DARK);
		}
		
		//OnStart method is called when any Test starts.
		public void onStart(ITestContext Result) 
		{  
			configureReport();  //
			System.out.println("on start method invoke ");
		}  
		//OnFinish method is called after all Test are executed.

		public void onFinish(ITestContext Result) 
		{  
			System.out.println("on finish method invoke ");	
			reports.flush(); //it is mandatory to call flush method to ensure information is written to the started repoter
		}  
		
		 //when test case get started, this method is called
			public void onTestStart(ITestResult Result) 
		{  
				System.out.println("Name of the test method started : " +Result.getName());
		} 
			  
	 //when test case get success, this method is called
			public void onTestSuccess(ITestResult Result) 
		{					
				System.out.println("Name of test method successfully executed"+Result.getName());
				test=reports.createTest(Result.getName());//create entry in html report
				test.log(Status.PASS,MarkupHelper.createLabel("Name of the passed test case is:"+Result.getName(),ExtentColor.PURPLE));	    
		} 
		
	 //when test case get failure, this method is called 		
			public void onTestFailure(ITestResult Result) 
		{ 			
			System.out.println("Name of test method failed:"+Result.getName());
			test=reports.createTest(Result.getName());//create entry in html report
			test.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed test case is:"+Result.getName(),ExtentColor.RED));
			
			String screenShotPath=System.getProperty("user.dir")+ "\\ScreenShots\\"+Result.getName() + ".png";/////
			
			File screenShotFile=new File(screenShotPath);
			
		  if(screenShotFile.exists())
		{
			test.fail("captured screenshot is below :"+test.addScreenCaptureFromPath(screenShotPath));
		}
		
		  
		}
	//when test case get skipped, this method is called
			public void onTestSkipped(ITestResult Result) 
		{  	
			System.out.println("Name of the Test method skipped:"+Result.getName()); 
			test=reports.createTest(Result.getName());//create entry in html report
			test.log(Status.SKIP,MarkupHelper.createLabel("Name of the skip test case is:"+Result.getName(),ExtentColor.INDIGO));
		}  
				 
			public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
		{  
			 
		} 
		
		
	}


