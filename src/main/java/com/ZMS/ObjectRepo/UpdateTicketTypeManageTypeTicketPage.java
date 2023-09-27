package com.ZMS.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ZMS.genericUtiliti.WebdriverUtility;

public class UpdateTicketTypeManageTypeTicketPage extends WebdriverUtility {

	//Declaration
	@FindBy(id = "tprice")
	private WebElement ticketCostTxt;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtn;
	
	//Initialization
	public UpdateTicketTypeManageTypeTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getTicketCostTxt() {
		return ticketCostTxt;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	//Business Library
	public void enterTestData(String cost, WebDriver driver) {
		ticketCostTxt.sendKeys(cost);
		updateBtn.click();
		acceptAlert(driver);
	}
	
	public void validate(WebDriver driver) {
		String price = driver.findElement(By.id("tprice")).getText();
		if(price.contains("3234")) {
			System.out.println("Sucessfully price has updated");
		}
		else {
			System.out.println("price has not updated");
		}
}
	
	public void validateTktGenerated(WebDriver driver) {
		String ticket_generated_page = driver.findElement(By.xpath("//h4[@class='header-title']")).getText();
		if(ticket_generated_page.contains("Ticket ID")) {
			System.out.println("ticket has generated ");
		}
		else {
			System.out.println("ticket has not generated");
		}
	}
	}
