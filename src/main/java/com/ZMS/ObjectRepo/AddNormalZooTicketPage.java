package com.ZMS.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ZMS.genericUtiliti.ExcelUtility;
import com.ZMS.genericUtiliti.WebdriverUtility;

public class AddNormalZooTicketPage extends ExcelUtility {

	//Declaration
	
	@FindBy(id = "visitorname")
	private WebElement visitorNameTxt;
	
	@FindBy(id = "noadult")
	private WebElement adultFieldTxt;
	
	@FindBy(id = "nochildren")
	private WebElement childrenFieldTxt;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	//Initialization
	public AddNormalZooTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getVisitorNameTxt() {
		return visitorNameTxt;
	}

	public WebElement getAdultFieldTxt() {
		return adultFieldTxt;
	}

	public WebElement getChildrenFieldTxt() {
		return childrenFieldTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Library
	
	public void enterTestData(String visitorName, String adultNo, String childrenNo,WebdriverUtility wLib, WebDriver driver) {
		visitorNameTxt.sendKeys(visitorName);
		adultFieldTxt.sendKeys(adultNo);
		childrenFieldTxt.sendKeys(childrenNo);
		submitBtn.click();
		wLib.acceptAlert(driver);
	}
	
	public void enterTestData(HashMap<String, String> map,WebDriver driver,WebdriverUtility wLib) {
		
		for(Entry<String, String> s:map.entrySet()) {
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		
		submitBtn.click();
		wLib.acceptAlert(driver);
	}
	
	public void validate(WebDriver driver) {
		String addzooTicket_page = driver.findElement(By.xpath("//h4[text()='Add Normal Zoo Ticket']")).getText();
		if(addzooTicket_page.contains(" Normal Zoo Ticket")) {
			System.out.println("Add normal zoo ticket page displayed");
		}
		else {
			System.out.println("Add normal zoo ticket page not displayed");
		}
	}
}
