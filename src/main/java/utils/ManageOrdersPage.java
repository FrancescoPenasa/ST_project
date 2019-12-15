package utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ManageOrdersPage extends PageObject{
	
	@FindBy(id="addProductModalBtn")
	WebElement addProductButton; 	
	
	@FindBy(id="productName")
	WebElement productNameTextBox; 
	
	public ManageOrdersPage(WebDriver driver) {
		super(driver);
	}
	
	private void getUploadFile() {
		URL res = getClass().getClassLoader().getResource("ow.jpg");
		File file = null;
		try {
			file = Paths.get(res.toURI()).toFile();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String absolutePath = file.getAbsolutePath(); // Use this
		driver.findElement(By.id("productImage")).sendKeys(absolutePath);
	}

	public void add(String name, String quantity, String rate, String brand, String category, String status) {
		// open pop-up
		this.addProductButton.click();
		myWait();
		
		
		getUploadFile();
		
		productNameTextBox.sendKeys(name);
		
		WebElement quantityTextBox = driver.findElement(By.id("quantity"));
		quantityTextBox.sendKeys(quantity);
		
		WebElement rateTextBox = driver.findElement(By.id("rate"));
		rateTextBox.sendKeys(rate);

		Select elmBrand = new Select(driver.findElement(By.id("brandName")));
		elmBrand.selectByVisibleText(brand);
		
		Select elmCategory = new Select(driver.findElement(By.id("categoryName")));
		elmCategory.selectByVisibleText(category);
		
		Select elmStatus = new Select(driver.findElement(By.id("productStatus")));
		if (status.equals("Available")){
			elmStatus.selectByVisibleText("Available");
		}
		else {
			elmStatus.selectByVisibleText("Not Available");
		}
		
		WebElement saveButton = driver.findElement(By.id("createProductBtn"));
		saveButton.click();
		
		// close pop-up
		WebElement closeButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]"));
		closeButton.click();
		myWait();
	}
	
	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
