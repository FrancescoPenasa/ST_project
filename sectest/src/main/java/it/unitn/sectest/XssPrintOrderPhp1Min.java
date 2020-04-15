package it.unitn.sectest;
import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//import org.apache.pdfbox.pdfparser.PDFParser;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.util.PDFTextStripper;
import org.junit.After;
import org.junit.Test;

import utils.AddOrdersPage;
import utils.BaseTest;
import utils.BrandPage;
import utils.CategoryPage;
import utils.DashboardPage;
import utils.LoginPage;
import utils.ManageOrdersPage;
import utils.ProductPage;
public class XssPrintOrderPhp1Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brandPage;
	CategoryPage categoriesPage;
	ProductPage productPage;
	AddOrdersPage addOrdersPage;
	ManageOrdersPage manageOrdersPage;
	
	/*
	 * UNCOMMENT LINES OF CODE TO MAKE THIS TEST WORK
	 */
	
	@Test
	public void testXssPrintOrderPhp1Min() {
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
		String quantity = "30";
		String rate = "1";
		String status = "Available";
		productPage = dashboard.goToProduct();
		productPage.add(productName, quantity, rate, brand, category, status);
		
		// add order
		String name = "<h1>name</h1>";
		String contact = "<h1>contact</h1>";
		String paid = "0";
		String discount = "0";
		addOrdersPage = dashboard.goToAddOrders();
		addOrdersPage.add("21/12/2012", name, contact, productName, discount, paid, "Cash", "No Payment", "In Gujarat");
		
		manageOrdersPage = dashboard.goToManageOrders();
		manageOrdersPage.print();
		
		URL currentURL = null;
		try {
			currentURL = new URL(driver.getCurrentUrl());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Boolean nameInPDF = true;
		Boolean contactInPDF = true;
//		try {
//			nameInPDF = verifyPDFContent(currentURL, name);
//			contactInPDF = verifyPDFContent(currentURL, name);	
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		assertEquals(false, nameInPDF);
		assertEquals(false, contactInPDF);
	}
	
	@After
	public void reset() throws InterruptedException {
		tearDown();
		setUp();
		LoginPage login = new LoginPage(driver);
		dashboard = login.login("admin", "admin");
		manageOrdersPage = dashboard.goToManageOrders();
		manageOrdersPage.remove();
		brandPage = dashboard.goToBrand();
		brandPage.remove();
		categoriesPage = dashboard.goToCategory();
		categoriesPage.remove();
		productPage = dashboard.goToProduct();
		productPage.remove();
	}
	
	
	
	
//	private Boolean verifyPDFContent(URL TestURL, String text) throws IOException {
//		BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
//		PDFParser TestPDF = new PDFParser(TestFile);
//		TestPDF.parse();
//		PDDocument pd = TestPDF.getPDDocument();
//		String testText = new PDFTextStripper().getText(pd);
//		
//		
//		return testText.contains(text);
//	}
	
	
	
	
	
}
