package com.ZMS.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForeignersPage {

	//Declaration
	
	@FindBy(xpath = "//span[text()='Foreigners Ticket']")
	private WebElement foreignersLink;
	
	@FindBy(xpath = "//a[@href='manage-foreigners-ticket.php']")
	private WebElement manageForeignersTicketLink;
	
	//Initialization
	public ForeignersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getForeignersLink() {
		return foreignersLink;
	}

	public WebElement getManageForeignersTicketLink() {
		return manageForeignersTicketLink;
	}
	
	//Business Library
	
	public void clickOnForeignersManagePage() {
		foreignersLink.click();
		manageForeignersTicketLink.click();
	}
	
	
}
