package com.ZMS.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ZMS.genericUtiliti.WebdriverUtility;

public class ManageAnimalPage extends WebdriverUtility {

	@FindBy(xpath = "(//table/tbody/tr/td/descendant::a[text()='Edit'])[1]")
	private WebElement editBtn;
	
	@FindBy(xpath = "(//table/tbody/descendant::a[text()='Delete'])[1]")
	private WebElement deleteBtn;
	
	//Initialization
	
	public ManageAnimalPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	
	//Business Library
	
	public void editManageAnimal() {
		editBtn.click();
	}
	
	public void deleteManageBtn(WebDriver driver) {
		deleteBtn.click();
		acceptAlert(driver);
		acceptAlert(driver);
		
	}
	
	
}
