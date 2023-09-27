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

public class AddAnimalDetailsPage extends ExcelUtility{

	//Declaration
	
	@FindBy(id = "aname")
	private WebElement animalNameTxt;
	
	@FindBy(id = "image")
	private WebElement animalImage;
	
	@FindBy(id = "cnum")
	private WebElement cageNumberTxt;
	
	@FindBy(id = "fnum")
	private WebElement feedNumberTxt;
	
	@FindBy(id = "breed")
	private WebElement breedTxt;
	
	@FindBy(id = "desc")
	private WebElement descTxt;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	//Initialization
	
	public AddAnimalDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	
	public WebElement getAnimalNameTxt() {
		return animalNameTxt;
	}

	public WebElement getAnimalImage() {
		return animalImage;
	}

	public WebElement getCageNumberTxt() {
		return cageNumberTxt;
	}

	public WebElement getFeedNumberTxt() {
		return feedNumberTxt;
	}

	public WebElement getBreedTxt() {
		return breedTxt;
	}

	public WebElement getDescTxt() {
		return descTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Library
	
	public void enterTestData(String animalName, String image, String cageNo, String feedNo,String breedName, String desc,WebdriverUtility wLib, WebDriver driver) {
		animalNameTxt.sendKeys(animalName);
		animalImage.sendKeys(image);
		cageNumberTxt.sendKeys(cageNo);
		feedNumberTxt.sendKeys(feedNo);
		breedTxt.sendKeys(breedName);
		descTxt.sendKeys(desc);
		submitBtn.click();
		wLib.acceptAlert(driver);
	}
	
	public void enterTestData(HashMap<String, String>map,WebDriver driver,WebdriverUtility wLib) {
		for(Entry<String, String> s:map.entrySet()) {
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		submitBtn.click();
		wLib.acceptAlert(driver);
	}
	
}
