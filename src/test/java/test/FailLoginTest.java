package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.LoginPage;

public class FailLoginTest  extends Base{
	public WebDriver driver;
	
	LoginPage loginPage;
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void FailLoginTest()
	{
		loginPage=new LoginPage(driver);
		loginPage.getUserName().sendKeys(prop.getProperty("WrongUsername"));
		loginPage.getPassword().sendKeys("WrongPassword");
		loginPage.submit().click();
		
		String expectedResult="CarbonLITE";
		
		String actualResult=driver.getTitle();
		
		System.out.println("expectedResult is:"+expectedResult);
		System.out.println("actualResult is:"+actualResult);
		
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
