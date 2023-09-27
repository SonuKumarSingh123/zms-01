package com.ZMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ZMS.genericUtiliti.WebdriverUtility;

public class ViewDetilsOfForeignersTicketPage extends WebdriverUtility {

	//Declaration
	
	@FindBy(xpath = "(//table/tbody/descendant::a[text()='Delete'])[1]")
	private WebElement deleteBtn;
	
	//Initialization
	public ViewDetilsOfForeignersTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	//utilization
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	//Business Library
	public void deleteForeignersTicket(WebDriver driver) {
		deleteBtn.click();
		acceptAlert(driver);
		acceptAlert(driver);
		
	}
}
