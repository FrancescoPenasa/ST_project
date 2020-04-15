package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AddUserPage;
import utils.BaseTest;
import utils.BrandPage;
import utils.CategoryPage;
import utils.DashboardPage;
import utils.LoginPage;
import utils.ProductPage;
import utils.SettingPage;

public class XssSettingPhp1Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brand;
	CategoryPage categories;
	ProductPage productPage;
	AddUserPage addUserPage;
	SettingPage settingPage;
	
	@Test
	public void testXssSettingPhp1Min() {

		// 1. Login
		LoginPage login = new LoginPage(driver);
		dashboard = login.login("admin", "admin");
		
		settingPage = dashboard.goToSettingPage();
		String username = "\"> <script>alert(\"test\") </script>";		
		settingPage.changeUsername(username);
		
		// refresh page
		dashboard.goToSettingPage();
		
		String alertMsg = dashboard.getAlertText();
		assertEquals("test", alertMsg);
	}
	
	@After
	public void reset() {	
		dashboard.closeAlert();
		settingPage.changeUsername("admin");
	}
	
}
