package com.hub.pages4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	//these is new comment
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(name="email1") WebElement email;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]") WebElement loginButton;
	
	public void loginTOCRM(String emailApplication,String passApplication)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		
		
		email.sendKeys(emailApplication);
		pass.sendKeys(passApplication);
		loginButton.click();
	}

}
