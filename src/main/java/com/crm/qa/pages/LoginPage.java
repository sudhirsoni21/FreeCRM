package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Object
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	//@FindBy(xpath="//input[@type='submit']")
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement BtnLogin;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement ImgLogo;

//Initialize page elements/objects
	public LoginPage() {
		PageFactory.initElements(driver, this);	
		}
	
//Actions:
	//Getting Login Page Title
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
		}
	
	//Verifying CRM logo is displaying
	public boolean ValidateCRMImage() {
		return ImgLogo.isDisplayed();
		}
	
	//Perform Login
	public HomePage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		assertTrue(BtnLogin.isEnabled());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BtnLogin.click();
		
		return new HomePage();
		}
}