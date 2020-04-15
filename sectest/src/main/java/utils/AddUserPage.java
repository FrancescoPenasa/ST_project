package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends PageObject{
	
	@FindBy(id="addUserModalBtn")
	WebElement addUserModalBtn; 

	@FindBy(id="userName")
	WebElement userNameTextBox; 
	
	@FindBy(id="upassword")
	WebElement userPasswordTextBox; 
	
	@FindBy(id="uemail")
	WebElement userEmailTextBox; 
	
	@FindBy(id="createUserBtn")
	WebElement createUserBtn; 
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]")
	WebElement closeModalBtn;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[2]/td[1]")
	WebElement addedUserName;

	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/button[1]")
	WebElement actionUserBtn;
	
	public AddUserPage(WebDriver driver) {
		super(driver);
	}
	
	public void add(String username, String password, String email) {
		addUserModalBtn.click();
		myWait();
		userNameTextBox.sendKeys(username);
		userPasswordTextBox.sendKeys(password);
		userEmailTextBox.sendKeys(email);
		myWait();
		createUserBtn.click();
		myWait();
		closeModalBtn.click();
		myWait();
	}
	
	public String getAddedUsername() {
		return addedUserName.getAttribute("innerHTML");
	}
	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void remove() {
		myWait();
		actionUserBtn.click();
		myWait();
		myWait();
		WebElement removeUserModalBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/ul[1]/li[2]/a[1]"));
		removeUserModalBtn.click();
		myWait();
		WebElement removeUserConfirmationtBtn = driver.findElement(By.id("removeProductBtn"));
		removeUserConfirmationtBtn.click();
		myWait();
	}
		
}
