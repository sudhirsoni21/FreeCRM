package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory: HomePage
	
	@FindBy(xpath="//td[contains(text(),'User: Sudhir SONI')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(@title,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(@title,'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(@title,'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(@title,'Tasks')]")
	WebElement tasksLink;

	//Initialize page elements/objects
	public HomePage() {
			PageFactory.initElements(driver, this);	
		}
		
	public String verifyHomePageTitle() {
		return driver.getTitle();
		}
	
	public boolean verifyValidUserName(){
		return userNameLabel.isDisplayed();		
	}
		
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		}
	
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
		}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
		}
}