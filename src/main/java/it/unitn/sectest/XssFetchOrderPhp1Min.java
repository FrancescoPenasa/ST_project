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

public class XssFetchOrderPhp1Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brandPage;
	CategoryPage categoriesPage;
	ProductPage productPage;
	AddOrdersPage addOrdersPage;
	ManageOrdersPage manageOrdersPage;
	
	@Test
	public void testXssFetchOrderPhp1Min() {

		// 1. Login as admin
		// 2. Change brandName inserting XSS attack
		// 3. go to the product and assert the XSS attack is there
		
		// 1. Login
		LoginPage login = new LoginPage(driver);
		dashboard = login.login("admin", "admin");
		
		// add brand
		String brand = "tmp";
		brandPage = dashboard.goToBrand();
		brandPage.add(brand, "Available");
		
		// add category
		String category = "tmp";
		categoriesPage = dashboard.goToCategory();
		categoriesPage.add(category, "Available");
		
		// add product
		String productName = "PerfectProduct";
		String quantity = "1";
		String rate = "1";
		String status = "Available";
		productPage = dashboard.goToProduct();
		productPage.add(productName, quantity, rate, brand, category, status);
		
		// add order
		String paid = "0";
		String discount = "0";
		myWait();
		addOrdersPage = dashboard.goToAddOrders();
		myWait();
		addOrdersPage.add("21/12/2012", "<h1>name</h1>", "<h1>contact</h1>", productName, discount, paid, "Cash", "No Payment", "In Gujarat");
		myWait();
		manageOrdersPage = dashboard.goToManageOrders();
		
		
		// check order
		String actualClientName = manageOrdersPage.getClientdName();
		String actualClientContact = manageOrdersPage.getClientContact();

		assertEquals("<h1>name</h1>", actualClientName);
		assertEquals("<h1>contact</h1>", actualClientContact);
	}
	
	@After
	public void reset() {		
		// We are still in the manageOrder
//		manageOrdersPage.remove();
//		dashboard.goToBrand();
//		brandPage.remove();
//		dashboard.goToCategory();
//		categoriesPage.remove();
		//dashboard.goToProduct();
		//productPage.remove();
	}
	
	private void myWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
