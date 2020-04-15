package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.BaseTest;
import utils.BrandPage;
import utils.CategoryPage;
import utils.DashboardPage;
import utils.LoginPage;
import utils.ProductPage;

public class XssFetchCategoriesPhp1Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brand;
	CategoryPage categories;
	ProductPage productPage;
	
	@Test
	public void testXssFetchCategoriesPhp1Min() {

		// 1. Login
		LoginPage login = new LoginPage(driver);
		dashboard = login.login("admin", "admin");
		
		categories = dashboard.goToCategory();
		categories.add("<h1>tmp</h1>", "Available");
		
		String actualCategoriesName = categories.getBrandName();
		
		assertEquals("<h1>tmp</h1>", actualCategoriesName);
	}
	
	@After
	public void reset() {		
		dashboard.goToCategory();
		categories.remove();
	}
	
}
