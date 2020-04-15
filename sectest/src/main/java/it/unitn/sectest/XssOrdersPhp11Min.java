package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AddOrdersPage;
import utils.BaseTest;
import utils.BrandPage;
import utils.CategoryPage;
import utils.DashboardPage;
import utils.LoginPage;
import utils.ManageOrdersPage;
import utils.ProductPage;

public class XssOrdersPhp11Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brandPage;
	CategoryPage categoriesPage;
	ProductPage productPage;
	AddOrdersPage addOrdersPage;
	ManageOrdersPage manageOrdersPage;
	
	@Test
	public void testXssOrdersPhp11Min() {
		// 1. Login
		LoginPage login = new LoginPage(driver);
		dashboard = login.login("admin", "admin");
		
		// add brand
		String brand = "brand";
		brandPage = dashboard.goToBrand();
		brandPage.add(brand, "Available");
		
		// add category
		String category = "category";
		categoriesPage = dashboard.goToCategory();
		categoriesPage.add(category, "Available");
		
		// add product
		String productName = "<script>alert(\"test\")<\\/script>";
		String quantity = "30";
		String rate = "rate";
		String status = "Available";
		productPage = dashboard.goToProduct();
		productPage.add(productName, quantity, rate, brand, category, status);
		
		
		addOrdersPage = dashboard.goToAddOrders();
		
		String alertText = dashboard.getAlertText();
		assertEquals("test", alertText);
	}
	
	@After
	public void reset() {		
		// we are on order page
		dashboard.closeAlert();
		dashboard.closeAlert();
		dashboard.goToBrand();
		brandPage.remove();
		dashboard.goToCategory();
		categoriesPage.remove();
		dashboard.goToProduct();
		productPage.remove();
	}
	
}
