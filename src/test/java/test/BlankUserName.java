package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.LoginPage;

public class BlankUserName  extends Base{
	public WebDriver driver;
	
	LoginPage loginPage;
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void BlankUsernameTest()
	{
		loginPage=new LoginPage(driver);
		loginPage.getUserName().sendKeys(prop.getProperty("BlankUsername"));
		loginPage.getPassword().sendKeys("validPassword");
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
