package com.ZMS.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageTypeTicket_ViewDetailsOfTicketPage {

	//Declaration
	@FindBy(xpath = "//div[@class='card-body']/descendant::a[@href='edit-ticket.php?editid=1']")
	private WebElement editBtn;
	
	//Initialization
	
	public ManageTypeTicket_ViewDetailsOfTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getEditBtn() {
		return editBtn;
	}
	
	public void clickOnEdit() {
		editBtn.click();
	}
	
	public void validateViewTktPage(WebDriver driver) {
		String view_ticket_page = driver.findElement(By.xpath("//h4[text()='View Detail of Tickets']")).getText();
		if(view_ticket_page.contains("Tickets")) {
			System.out.println("View ticket page sucessfully open");
		}
		else {
			System.out.println("View ticket page is not open");
		}
	}
}
