package com.hub.pages4;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hub.utility4.BrowserFactory;
import com.hub.utility4.ConfigDataProvider;
import com.hub.utility4.ExceldataProvider;
import com.hub.utility4.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExceldataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	//@BeforeSuite
	//public  void SetUpSuite() 
	//{
	//	ExceldataProvider excel=new ExceldataProvider();

	//}
	
	@BeforeSuite
	public void setUpSuite()
	{
		 Reporter.log("Settinng up reports and test is getting ready",true);
		 excel=new ExceldataProvider();
		 config=new ConfigDataProvider();
		 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports1/FreeCRM1_"+Helper.getCurrentDataTime()+".html"));
		 report=new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Settinng Done- test can  be  started",true);

	}
	


	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start Browser and getting application ready",true);
		driver=BrowserFactory.startApplication(driver,config.getBrowser(), config.getStagingURL());
		Reporter.log("Browser and application is up and running",true);


	}
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitbrowser(driver);

	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		 Reporter.log("Test is about to end",true);

		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed" , MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed" , MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		
		report.flush();
		 Reporter.log("test Completed >>> Reports Generated",true);


	}
	

}
