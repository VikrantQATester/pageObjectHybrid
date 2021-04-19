package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	private By username = By.xpath("//input[@id='LoginForm_username']");

	private By password = By.xpath("//input[@id='LoginForm_password']");

	private By submit = By.xpath("//input[@value='Login']");
	

	public WebElement getUserName() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement submit() {
		return driver.findElement(submit);
	}

}
