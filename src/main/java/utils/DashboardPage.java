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
	
	@FindBy(id="navOrder")
	WebElement ordersButton; 
	
	@FindBy(id="topNavAddOrder")
	WebElement addOrdersButton; 
	
	@FindBy(id="topNavManageOrder")
	WebElement manageOrdersButton; 
	
	
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
	
	public AddOrdersPage goToAddOrders() {
		this.ordersButton.click();
		myWait();
		this.addOrdersButton.click();
		myWait();
		return new AddOrdersPage(driver);
	}
	
	public ManageOrdersPage goToManageOrders() {
		this.ordersButton.click();
		myWait(); 
		this.manageOrdersButton.click();
		myWait();
		return new ManageOrdersPage(driver);
	}
	

	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}