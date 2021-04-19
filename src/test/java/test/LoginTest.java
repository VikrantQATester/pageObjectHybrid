package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.LoginPage;

public class LoginTest  extends Base{
	public WebDriver driver;
	
	LoginPage loginPage;
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void LoginTest()
	{
		loginPage=new LoginPage(driver);
		
		System.out.println("username:"+prop.getProperty("Username"));
		System.out.println("Password:"+prop.getProperty("Password"));
		loginPage.getUserName().sendKeys(prop.getProperty("Username"));
		loginPage.getPassword().sendKeys("Password");
		loginPage.submit().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
