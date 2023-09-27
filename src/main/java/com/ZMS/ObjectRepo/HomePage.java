package com.ZMS.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	//Declaration
	
	@FindBy(xpath = "//a[@href='dashboard.php']/ancestor::ul[@id='menu']/descendant::span[text()='Dashboard']")
	private WebElement dashboardLink;
	
	@FindBy(xpath = "//span[text()='Animals Details']")
	private WebElement animalDetalisLink;
	
	@FindBy(xpath = "//a[@href='add-animals.php']")
	private WebElement addAnimalsLink;
	
	@FindBy(xpath = "//a[@href='manage-animals.php']")
	private WebElement manageAnimalLink;
	
	@FindBy(xpath = "//span[contains(text(),'Manage Type Ticket')]")
	private WebElement manageTypeTicket;
	
	@FindBy(xpath = "//span[text()='Normal Ticket']")
		private WebElement normalTicketLink;
	
	@FindBy(xpath = "//a[@href='add-normal-ticket.php']")
	private WebElement addTicketLink;
	
	@FindBy(xpath = "//a[@href='manage-normal-ticket.php']")
	private WebElement manageNormalTicketLink;
	
	@FindBy(xpath = "//span[text()='Foreigners Ticket']")
	private WebElement foreignersTicketLink;
	
	@FindBy(xpath = "//a[@href='manage-foreigners-ticket.php']")
	private WebElement manageTicketForeignersLink;
	
	@FindBy(xpath = "//span[text()='Page']")
	private WebElement pageLink;
	
	@FindBy(xpath = "//a[@href='contactus.php']")
	private WebElement contactUsLink;
	
	@FindBy(xpath = "//h4[contains(text(),'Admin1 ')]")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement logOutImg;
	
	
	//Initlization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getAnimalDetalisLink() {
		return animalDetalisLink;
	}

	public WebElement getAddAnimalsLink() {
		return addAnimalsLink;
	}

	public WebElement getManageAnimalLink() {
		return manageAnimalLink;
	}

	public WebElement getManageTypeTicket() {
		return manageTypeTicket;
	}

	public WebElement getNormalTicketLink() {
		return normalTicketLink;
	}

	public WebElement getAddTicketLink() {
		return addTicketLink;
	}

	public WebElement getManageTicketLink() {
		return manageNormalTicketLink;
	}

	public WebElement getPageLink() {
		return pageLink;
	}

	public WebElement getContactUsLink() {
		return contactUsLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getLogOutImg() {
		return logOutImg;
	}
	
	public WebElement getManageNormalTicketLink() {
		return manageNormalTicketLink;
	}


	public WebElement getForeignersTicketLink() {
		return foreignersTicketLink;
	}


	public WebElement getManageTicketForeignersLink() {
		return manageTicketForeignersLink;
	}

	//Business Library
	
	public void clickAnimalsDetails_AddAnimal() {
		animalDetalisLink.click();
		addAnimalsLink.click();
	}
	
	public void clickAnimalDetails_ManageAnimals() {
		animalDetalisLink.click();
		manageAnimalLink.click();
		
	}
	
	public void clickManageTypeTicket() {
		manageTypeTicket.click();
	}

	public void clickNormalTicket_AddTicket() {
		normalTicketLink.click();
		addTicketLink.click();
	}
	
	public void clickNormalTicket_ManageTicket() {
		normalTicketLink.click();
		manageNormalTicketLink.click();
	}


	public void clickForeignersTicket_ManageTicket() {
		foreignersTicketLink.click();
		manageTicketForeignersLink.click();
	}
	
	public void clickOnPage_ContactUs() {
		pageLink.click();
		contactUsLink.click();
	}
	
	public void signout() {
		adminImg.click();
		logOutImg.click();
	}
	
	


}
