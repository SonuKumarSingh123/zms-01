package com.ZMS.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ZMS.genericUtiliti.WebdriverUtility;

public class ContactUsPage extends WebdriverUtility {

	//Declaration
	
	@FindBy(xpath = "//textarea[@name='pagedes']")
	private WebElement pagedescTxt;
	
	@FindBy(name = "email")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtn;
	
	//Initialization
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getPagedescTxt() {
		return pagedescTxt;
	}

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public void enterContactUsDetails(String page_desc, String email, WebDriver driver) {
		pagedescTxt.sendKeys(page_desc);
		emailTxt.sendKeys(email);
		updateBtn.click();
		acceptAlert(driver);
	}
	
	public void enterContactUsDetails(HashMap<String, String>map,WebDriver driver) {
		for(Entry<String, String> s:map.entrySet()) {
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		updateBtn.click();
		acceptAlert(driver);
	}
	
	public void clearTxt() {
		pagedescTxt.clear();
		emailTxt.clear();
	}
	
	public void validate(WebDriver driver) {
		String contactus_page = driver.findElement(By.xpath("//h4[text()='Contact Us']")).getText();
		if(contactus_page.contains("act Us")) {
			System.out.println("contact page has updated");
		}
		else {
			System.out.println("contact page has not updated");
		}
	}
}
