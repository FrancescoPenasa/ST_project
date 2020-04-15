package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.AddOrdersPage;
import utils.BaseTest;
import utils.BrandPage;
import utils.CategoryPage;
import utils.DashboardPage;
import utils.LoginPage;
import utils.ManageOrdersPage;
import utils.ProductPage;

public class XssProductPhp3Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brandPage;
	CategoryPage categoriesPage;
	ProductPage productPage;
	
	@Test
	public void testXssProductPhp3Min() {

		// 1. Login
		LoginPage login = new LoginPage(driver);
		dashboard = login.login("admin", "admin");
		
		// add brand
		String brand = "<script>alert(\"" + "test" + "\") <\\/script>";
		brandPage = dashboard.goToBrand();
		brandPage.add(brand, "Available");
		
		// add category
		String category = "category";
		categoriesPage = dashboard.goToCategory();
		categoriesPage.add(category, "Available");
		
		// add product
		productPage = dashboard.goToProduct();
		
		String alertText = dashboard.getAlertText();
		assertEquals("test", alertText);
	}
	
	@After
	public void reset() throws InterruptedException {
		// we are on product page
		dashboard.closeAlert();
		dashboard.goToBrand();
		brandPage.remove();
		dashboard.goToCategory();
		categoriesPage.remove();
	}
	
}
