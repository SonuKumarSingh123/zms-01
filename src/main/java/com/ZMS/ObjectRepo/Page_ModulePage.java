package com.ZMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_ModulePage {

	//Declaration
	@FindBy(xpath = "//span[text()='Page']")
	private WebElement pageLink;
	
	@FindBy(xpath = "//a[@href='contactus.php']")
	private WebElement contactUsLink;
	
	//Initialization
	public Page_ModulePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getPageLink() {
		return pageLink;
	}

	public WebElement getContactUsLink() {
		return contactUsLink;
	}
	
	//Business Library
	
	public void clickOnPageContactus() {
		pageLink.click();
		contactUsLink.click();
	}
}
