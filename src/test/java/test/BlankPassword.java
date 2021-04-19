package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.LoginPage;

public class BlankPassword  extends Base{
	public WebDriver driver;
	
	LoginPage loginPage;
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void BlankPasswordTest()
	{
		loginPage=new LoginPage(driver);
		loginPage.getUserName().sendKeys(prop.getProperty("ValidUsername"));
		loginPage.getPassword().sendKeys("BlankPassword");
		loginPage.submit().click();
		
		String expectedResult="CarbonLITE";
		
		String actualResult=driver.getTitle();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
