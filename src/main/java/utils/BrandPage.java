package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BrandPage extends PageObject{
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")
	WebElement addBrandButton; 
	
	@FindBy(id="brandName")
	WebElement brandNameTextBox; 	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement brandName;
	
	
	public BrandPage(WebDriver driver) {
		super(driver);
	}
		
	public void add(String name, String status) {
		// open pop-up
		this.addBrandButton.click();
		myWait();
		
		brandNameTextBox.sendKeys(name);
		Select elm = new Select(driver.findElement(By.id("brandStatus")));
		if (status.equals("Available")){
			elm.selectByVisibleText("Available");
		}
		else {
			elm.selectByVisibleText("Not Available");
		}
		WebElement saveButton = driver.findElement(By.id("createBrandBtn"));
		saveButton.click();
		// close pop-up
		WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
		closeButton.click();
		myWait();
	}
	
	public void remove() {
		// TODO Auto-generated method stub
		WebElement actionButton = driver.findElement(By.xpath("//button[@class='btn btn-default dropdown-toggle']"));
		actionButton.click();
		myWait();
		WebElement removeButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/ul[1]/li[2]/a[1]"));
		removeButton.click();
		myWait();
		WebElement confirmRemoveButton = driver.findElement(By.id("removeBrandBtn"));
		confirmRemoveButton.click();
		myWait();
	}
	
	public String getBrandName() {
		return	brandName.getAttribute("innerHTML");
	}
	
	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
	
}