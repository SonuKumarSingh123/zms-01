package com.ZMS.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAnimalDetailPage {

	//Declaration
	
	@FindBy(id = "aname")
	private WebElement animalNameTxt;
	
	@FindBy(id = "breed")
	private WebElement breedTxt;
	
	@FindBy(id = "desc")
	private WebElement descTxt;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtn;
	
	//Initialization
	
	public UpdateAnimalDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getAnimalNameTxt() {
		return animalNameTxt;
	}

	public WebElement getBreedTxt() {
		return breedTxt;
	}

	public WebElement getDescTxt() {
		return descTxt;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	//Business Library
	
	public void enterTestData(String animalName, String breedName, String desc) {
		animalNameTxt.sendKeys(animalName);
		breedTxt.sendKeys(breedName);
		descTxt.sendKeys(desc);
		updateBtn.click();
	}
	
	public void enterTestData(HashMap<String, String>map,WebDriver driver) {
		for(Entry<String, String> s:map.entrySet()) {
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		updateBtn.click();
	}
}
