package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CategoryPage extends PageObject{

	@FindBy(id="addCategoriesModalBtn")
	WebElement addCategoriesButton; 	
	
	@FindBy(id="categoriesName")
	WebElement categoriesNameTextBox; 
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement categoriesName;
	
	public CategoryPage(WebDriver driver) {
		super(driver);
	}
	
	public void add(String name, String status) {
		// open pop-up
		this.addCategoriesButton.click();
		myWait();
		
		categoriesNameTextBox.sendKeys(name);
		Select elm = new Select(driver.findElement(By.id("categoriesStatus")));
		if (status.equals("Available")){
			elm.selectByVisibleText("Available");
		}
		else {
			elm.selectByVisibleText("Not Available");
		}
		WebElement saveButton = driver.findElement(By.id("createCategoriesBtn"));
		saveButton.click();
		// close pop-up
		WebElement closeButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]"));
		closeButton.click();
		myWait();
	}
	
	public void remove() {
		// TODO Auto-generated method stub
		WebElement actionButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/button[1]"));
		actionButton.click();
		myWait();
		WebElement removeButton = driver.findElement(By.xpath("//a[@id='removeCategoriesModalBtn']"));
		removeButton.click();
		myWait();
		WebElement confirmRemoveButton = driver.findElement(By.id("removeCategoriesBtn"));
		confirmRemoveButton.click();
		myWait();
	}
	
	public String getBrandName() {
		return	categoriesName.getAttribute("innerHTML");
	}
	
	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
