package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageObject{
	
	@FindBy(id="navBrand")
	WebElement brandButton; 
	
	@FindBy(id="navCategories")
	WebElement categoriesButton; 
	
	@FindBy(id="navProduct")
	WebElement productButton; 
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
		
	public BrandPage goToBrand() {
		this.brandButton.click();
		myWait();
		return new BrandPage(driver);
	}
	
	public CategoryPage goToCategory() {
		this.categoriesButton.click();
		myWait();
		return new CategoryPage(driver);
	}
	
	public ProductPage goToProduct() {
		this.productButton.click();
		myWait();
		return new ProductPage(driver);
	}
	

	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}