package utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
	
	@FindBy(id="navSetting")
	WebElement settingsBtn; 
	
	@FindBy(xpath="/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[1]/a[1]")
	WebElement addUserBtn; 
	
	@FindBy(xpath="/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[2]/a[1]")
	WebElement settingBtn; 
	
	
	
	
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
	
	public AddUserPage goToAddUserPage() {
		this.settingsBtn.click();
		myWait(); 
		this.addUserBtn.click();
		myWait();
		return new AddUserPage(driver);
	}
	public SettingPage goToSettingPage() {
		this.settingsBtn.click();
		myWait(); 
		this.settingBtn.click();
		myWait();
		return new SettingPage(driver);
	}
	

	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/* common method, TO ADD IN A SPECIFIC CLASS */
	public String getAlertText(){ 
		try {
			return driver.switchTo().alert().getText();
		} catch (Exception e) {
			return null;
		}		 
	}
	
	public void closeAlert() {
		myWait();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// do nothing
		}
		myWait();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// do nothing
		}
		myWait();
	}


	
	
}