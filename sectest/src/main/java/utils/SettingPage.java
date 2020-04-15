package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingPage extends PageObject{

	@FindBy(id="username")
	WebElement usernameTextBox; 
	
	@FindBy(id="bio")
	WebElement bioTextBox; 
	
	@FindBy(id="changeUsernameBtn")
	WebElement changeUsernameBtn; 
	
	@FindBy(id="changeBioBtn")
	WebElement changeBioBtn; 
	
	public SettingPage(WebDriver driver) {
		super(driver);
	}
	
	public void changeUsername(String newUsername) {
		usernameTextBox.clear();
		usernameTextBox.sendKeys(newUsername);
		changeUsernameBtn.click();
		myWait();
	}
	public void changeBio(String newBio) {
		bioTextBox.clear();
		bioTextBox.sendKeys(newBio);
		changeBioBtn.click();
		myWait();
	}
	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
