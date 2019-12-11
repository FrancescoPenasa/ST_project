package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.BaseTest;
import utils.DashboardPage;
import utils.LoginPage;

public class XssProduct1Min extends BaseTest{

	@Test
	public void XssProduct1Min() {

		// 1. Login as admin
		// 2. Change brandName inserting XSS attack
		// 3. go to the product and assert the XSS attack is there
		
		// 1. Login
		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard = login.login("admin", "admin");
		dashboard.goToBrand();
			
		// 2. Go to setting page
		// WebElement settingButton = driver.findElement(By.cssSelector("#topNavSetting > a:nth-child(1)")); ElementNotVisibleException
		// settingButton.click();
		
	}
	
}
