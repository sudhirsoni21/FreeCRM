package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver ef_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Learning\\elipse_Workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties");
			prop.load(ip);
			}
		catch (FileNotFoundException e){
			e.printStackTrace();
			}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
	
		
		if (browserName.equals("chrome")) {			
			System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
	
		ef_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		ef_driver.register(eventListener);
		driver = ef_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT_TIME,TimeUnit.SECONDS);
		
		driver.get(url);
	}
}