/*
 * 
 * Author: Sudhir Soni
 */

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();		
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginToCRMTest() {
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
