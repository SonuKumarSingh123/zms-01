package com.ZMS.genericUtiliti;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ZMS.ObjectRepo.HomePage;
import com.ZMS.ObjectRepo.LoginPage;
public class BaseClass {

	public DatabaseUtility dLib =new DatabaseUtility();
	public ExcelUtility eLib =new ExcelUtility();
	public FileUtility fLib =new FileUtility();
	public JavaUtility jLib =new JavaUtility();
	public WebdriverUtility wLib =new WebdriverUtility();
	public  WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		dLib.connectToDB();
		System.out.println("-----DataBase connected-----");
	}
	
	//@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		}
		/*
		 * else if (BROWSER.equalsIgnoreCase("firefox")) { driver =new FirefoxDriver();
		 * }
		 */
		
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver =new EdgeDriver();
		}
		
		else {
			System.out.println("-----Invallid Browser-----");
		}
		
		System.out.println("-----Browser has launched-----");
		
		
		sdriver= driver;
		wLib.maximizeTheBrowser(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		driver.get(URL);
		
		wLib.implictwait(driver, 10);
		
		
		LoginPage lp =new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("-----Login to the application-----");
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		HomePage hp =new HomePage(driver);
		
		hp.signout();
		
		System.out.println("-----Logout from the application-----");
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
		System.out.println("-----Close the browser-----");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException {
		dLib.closeDB();
		System.out.println("-----DataBase closed-----");
	}
}
