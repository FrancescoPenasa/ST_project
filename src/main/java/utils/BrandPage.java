package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandPage extends PageObject{
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")
	WebElement addBrandButton; 
	
	@FindBy(id="brandName")
	WebElement brandNameTextBox; 	
	
	public BrandPage(WebDriver driver) {
		super(driver);
	}
		
	public void add(String username, String password) {
		this.addBrandButton.click();
		myWait();
		
		
	}
	
	
	
	public void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}