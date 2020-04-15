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

public class XssFetchUserPhp1Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brand;
	CategoryPage categories;
	ProductPage productPage;
	AddUserPage addUserPage;
	
	@Test
	public void testXssFetchUserPhp1Min() {

		// 1. Login
		LoginPage login = new LoginPage(driver);
		dashboard = login.login("admin", "admin");
		
		addUserPage = dashboard.goToAddUserPage();
		String username = "<h1>Username</h1>";
		String password = "password";
		String email = "user@email.com";
		
		addUserPage.add(username, password, email);
		
		String actualUserName= addUserPage.getAddedUsername();
		
		assertEquals(username, actualUserName);
	}
	
	@After
	public void reset() {		
		addUserPage.remove();
	}
	
}
