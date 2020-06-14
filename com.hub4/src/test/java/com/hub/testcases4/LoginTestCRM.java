package com.hub.testcases4;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hub.pages4.BaseClass;
import com.hub.pages4.LoginPage;


public class LoginTestCRM extends BaseClass {
	
	@Test(priority=1)
	public void loginApp()
	{
		logger=report.createTest("Login to CRM");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginPage.loginTOCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("login success");
		
		
		
		
	}
	@Test(priority=2)
	public void loginApp1()
	{
		logger=report.createTest("Logout");
		
		logger.fail("logout failed");
		
		
	}
	

	
	

}
