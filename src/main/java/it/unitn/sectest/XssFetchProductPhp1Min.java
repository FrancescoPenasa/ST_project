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

public class XssFetchProductPhp1Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brandPage;
	CategoryPage categoriesPage;
	ProductPage productPage;
	AddOrdersPage addOrdersPage;
	ManageOrdersPage manageOrdersPage;
	
	@Test
	public void testXssFetchProductPhp1Min() {

		// 1. Login as admin
		// 2. Change brandName inserting XSS attack
		// 3. go to the product and assert the XSS attack is there
		
		// 1. Login
		LoginPage login = new LoginPage(driver);
		dashboard = login.login("admin", "admin");
		
		// add brand
		String brand = "<h1>brand</h1>";
		brandPage = dashboard.goToBrand();
		brandPage.add(brand, "Available");
		
		// add category
		String category = "<h1>category</h1>";
		categoriesPage = dashboard.goToCategory();
		categoriesPage.add(category, "Available");
		
		// add product
		brand = "brand";
		category = "category";
		String productName = "<h1>productName</h1>";
		String quantity = "1";
		String rate = "<h1>rate</h1>";
		String status = "Available";
		productPage = dashboard.goToProduct();
		productPage.add(productName, quantity, rate, brand, category, status);
		
		
		
		
		// check product
		String actualproductName = productPage.getProductName();
		assertEquals("<h1>productName</h1>", actualproductName);
		
		String actualBrandName = productPage.getBrandName();
		assertEquals("<h1>brand</h1>", actualBrandName);
		
		String actualCategoryName = productPage.geTCategoryName();
		assertEquals("<h1>category</h1>", actualCategoryName);
		
		String actualRate = productPage.getRate();
		assertEquals("<h1>rate</h1>", actualRate);
	}
	
	@After
	public void reset() {		
		// we are on product page
		productPage.remove();
		dashboard.goToBrand();
		brandPage.remove();
		dashboard.goToCategory();
		categoriesPage.remove();
		dashboard.goToProduct();
	}
	
}
