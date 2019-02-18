package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();		
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest(){
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectSingleContactTest(){
		contactsPage.selectContactByName("test test");
	}
	
	@Test(priority=3)
	public void selectMultipleContactTest(){
		contactsPage.selectContactByName("test test");
		contactsPage.selectContactByName("xyz test");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object testData[][] = TestUtil.getTestData("Contacts");
		return testData;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void createNewContactsTest(String Title, String FirstName, String LastName, String Comapny){
		homePage.clickOnNewContact();
		contactsPage.fillNewContactForm(Title, FirstName, LastName, Comapny);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
