package it.unitn.sectest;
import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;
import utils.AddOrdersPage;
import utils.BaseTest;
import utils.BrandPage;
import utils.CategoryPage;
import utils.DashboardPage;
import utils.LoginPage;
import utils.ManageOrdersPage;
import utils.ProductPage;
//import org.apache.pdfbox.pdfparser.PDFParser;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.util.PDFTextStripper;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class XssPrintOrderPhp1Min extends BaseTest{

	DashboardPage dashboard;
	BrandPage brandPage;
	CategoryPage categoriesPage;
	ProductPage productPage;
	AddOrdersPage addOrdersPage;
	ManageOrdersPage manageOrdersPage;
	
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
		String quantity = "1";
		String rate = "1";
		String status = "Available";
		productPage = dashboard.goToProduct();
		productPage.add(productName, quantity, rate, brand, category, status);
		
		// add order
		String paid = "0";
		String discount = "0";
		addOrdersPage = dashboard.goToAddOrders();
		addOrdersPage.add("21/12/2012", "<h1>name</h1>", "<h1>contact</h1>", productName, discount, paid, "Cash", "No Payment", "In Gujarat");
		
		manageOrdersPage = dashboard.goToManageOrders();
		manageOrdersPage.print();
		
		assertEquals(true, verifyPDFContent("http://localhost/inventory-management-system/orders.php?o=manord", "<h1>name</h1>"));		
	}
	
	
	private boolean verifyPDFContent(String strURL, String reqTextInPDF) {
		
		boolean flag = false;
		
//		PDFTextStripper pdfStripper = null;
//		PDDocument pdDoc = null;
//		COSDocument cosDoc = null;
//		String parsedText = null;
//
//		try {
//			URL url = new URL(strURL);
//			BufferedInputStream file = new BufferedInputStream(url.openStream());
//			PDFParser parser = new PDFParser(file);
//			
//			parser.parse();
//			cosDoc = parser.getDocument();
//			pdfStripper = new PDFTextStripper();
//			pdfStripper.setStartPage(1);
//			pdfStripper.setEndPage(1);
//			
//			pdDoc = new PDDocument(cosDoc);
//			parsedText = pdfStripper.getText(pdDoc);
//		} catch (MalformedURLException e2) {
//			System.err.println("URL string could not be parsed "+e2.getMessage());
//		} catch (IOException e) {
//			System.err.println("Unable to open PDF Parser. " + e.getMessage());
//			try {
//				if (cosDoc != null)
//					cosDoc.close();
//				if (pdDoc != null)
//					pdDoc.close();
//			} catch (Exception e1) {
//				e.printStackTrace();
//			}
//		}
//
//		if(parsedText.contains(reqTextInPDF)) {
//			flag=true;
//		}
		
		return flag;
	}
}
