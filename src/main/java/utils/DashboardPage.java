package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageObject{
	
	
	@FindBy(id="navBrand")
	WebElement brandButton; 
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
		
	public BrandPage goToBrand() {
		this.brandButton.click();
		myWait();
		return new BrandPage(driver);
	}
	

	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}