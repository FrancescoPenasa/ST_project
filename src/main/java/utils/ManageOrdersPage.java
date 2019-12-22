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
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[3]")
	WebElement clientName; 	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[4]")
	WebElement clientContact; 
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/button[1]")
	WebElement actionBtn;
	
	@FindBy(id="removeOrderModalBtn")
	WebElement removeOrderModalBtn;	
	@FindBy(id="removeOrderBtn")
	WebElement removeOrderBtn;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/ul[1]/li[3]/a[1]")
	WebElement printBtn;
	
	public ManageOrdersPage(WebDriver driver) {
		super(driver);
	}
		
	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void remove() {
		actionBtn.click();
		myWait();
		removeOrderModalBtn.click();
		myWait();
		removeOrderBtn.click();
		myWait();
	}

	public String getClientdName() {
		myWait();
		return clientName.getAttribute("innerHTML");
	}

	public String getClientContact() {
		return clientContact.getAttribute("innerHTML");
	}


	public void print() {
		actionBtn.click();
		myWait();
		printBtn.click();
		myWait();
		
	}

}
