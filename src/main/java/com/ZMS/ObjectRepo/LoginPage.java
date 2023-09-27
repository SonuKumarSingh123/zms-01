package com.ZMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Declaration
	@FindBy(id = "username")
	private WebElement userNameEdt;
	
	@FindBy(id = "password")
	private WebElement pwdEdt;
	
	@FindBy(id = "form_submit")
	private WebElement submitBtn;
	
	//Initlization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	//Utilization
	
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPwdEdt() {
		return pwdEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Library
	
	public void loginToApp(String userName, String password) {
		userNameEdt.sendKeys(userName);
		pwdEdt.sendKeys(password);
		submitBtn.click();;
	}
}
