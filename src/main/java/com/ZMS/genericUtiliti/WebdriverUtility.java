package com.ZMS.genericUtiliti;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility {

	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to wait until elements in the page gets load
	 * @param driver
	 * @param duration
	 */
	public void implictwait(WebDriver driver, long duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	/**
	 * this method will wait until the title of the page gets load
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilUrlLoads(WebDriver driver, long duration, String expectedTitle) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	
	/**
	 * This method will wait until the element in the page gets load
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementTobeClickable(WebDriver driver, long duration, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * 
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver, long duration) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	/**
	 * This method will wait until the element to be visible in the page
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				
				element.click();
				break;
				
			} catch (Exception e) {
				
				Thread.sleep(2000);
				count++;
			}
		}
	}
	
	/**
	 * This method will select a dropdown element based on value
	 * @param element
	 * @param value
	 */
	public void selectDropDown( WebElement element, String value) {
		Select s =new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will select a dropdown based on visible text
	 * @param text
	 * @param element
	 */
	public void selectDropDown( String text,WebElement element) {
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to mouseover on an element
	 * @param driver
	 * @param element
	 */
	public void mouseHoveronElement(WebDriver driver,WebElement element) {
		Actions a =new Actions(driver);
		a.moveToElement(element).perform();;
	}
	
	/**
	 * This method is used to right click on an element
	 * @param driver
	 * @param element
	 */
	public void rightclick(WebDriver driver, WebElement element) {
		Actions a =new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method will use for Drag and drop action
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dranandDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions a =new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	
	/**
	 * This method will use for double click action
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions a =new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to click on enter button
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions a =new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will press enter key
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable {
		Robot rb =new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will use to release the key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable {
		Robot rb =new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to switch from one frame to another frame using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will used to switch from one frame to another using id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	
	/**
	 * This method is used to switch one frame to another using Webelement
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to accept the alert message
	 * @param driver
	 * @param expectedMsg
	 */
	public void acceptAlertPopup(WebDriver driver,String expectedMsg) {
		Alert a =driver.switchTo().alert();
		if(a.getText().equalsIgnoreCase(expectedMsg)) {
			System.out.println("Alert msg verified");
		}
		else {
			System.out.println("Alert msg is not verified");
		}
		a.accept();
	}
	
	/**
	 * This method is used to accept the popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		Alert a =driver.switchTo().alert();
		a.accept();
	}
	
	/**
	 * This method is used to dismiss the popup
	 * @param driver
	 * @param expectedMsg
	 */
	
	public void dismissAlertPopup(WebDriver driver,String expectedMsg) {
		Alert a =driver.switchTo().alert();
		if(a.getText().equalsIgnoreCase(expectedMsg)) {
			System.out.println("Alert message is verified");
		}
		else {
			System.out.println("Alert message is not verified");
		}
		a.dismiss();
	}
	
	/**
	 * This method is used to switch from one window to another window based on title
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle) {
		Set<String> set = driver.getWindowHandles();
		for (String str : set) {
			driver.switchTo().window(str);
			String title = driver.getTitle();
			if(title.contains(expectedTitle)) {
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch from one window to another window based on CurrentUrl
	 * @param driver
	 * @param expectedURL
	 */
	public void switchWindowBasedOnUrl(WebDriver driver, String expectedURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedURL)) {
				break;
			}
		}
	}
	
	
	/**
	 * This method will taken screen shot of element when script is getting failed
	 * @param driver
	 * @param screenShotName
	 * @return
	 */
	
	public static String takeScreenShot(WebDriver driver,String screenShotName) {
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst =new File(".\\screenshots"+screenShotName+"png");
		try {
			Files.copy(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return screenShotName;
	}
	
	/**
	 * This method will use for scroll bar action
	 * @param driver
	 * @param element
	 */
	public void scrollToParticularElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * This method will use for random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)","");
	}
	
	public void scrollaction(WebDriver driver,WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		int x =element.getLocation().getX();
	}
}
