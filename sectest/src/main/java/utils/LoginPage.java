package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{
	
	
	@FindBy(id="username")
	WebElement usernameTextBox; 
	@FindBy(id="password")
	WebElement passwordTextBox; 
	@FindBy(xpath="/html/body/div/div/div/div/div[2]/form/fieldset/div[3]/div/button")
	WebElement submitButton; 
	@FindBy(xpath="//*[@id=\\\"navSetting\\\"]/a")
	WebElement dropDownMenuButton; 
	@FindBy(xpath="/html/body/nav/div/div[2]/ul/li[7]/ul/li[3]/a")
	WebElement logOutButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
	public DashboardPage login(String username, String password) {
		this.usernameTextBox.sendKeys(username);
		this.passwordTextBox.sendKeys(password);
		this.submitButton.click();
		myWait();
		return new DashboardPage(driver);
	}
	
	public void logout() {
		this.dropDownMenuButton.click();
		this.logOutButton.click();
	}
	
	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
