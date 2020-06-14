package com.hub.testcases4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseseWithoutFrameWork {
	@Test
	public  void test1() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ui.freecrm.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("nikhilsoni86869@gmail.com");
		driver.findElement(By.name("password")).sendKeys("nikhilsoni1313@");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
		driver.quit();
		
	}

}
