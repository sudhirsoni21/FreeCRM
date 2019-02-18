package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//PageFactory for ContactsPage
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return ContactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String sName) {
		driver.findElement(By.xpath("//a[text()='"+sName+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void fillNewContactForm(String sTitle, String sFirstName, String sLastName, String sCompany) {
		Select selectTitle = new Select(title);
		selectTitle.selectByValue(sTitle);
		firstName.sendKeys(sFirstName);
		lastName.sendKeys(sLastName);
		company.sendKeys(sCompany);
		saveBtn.click();		
	}

}
