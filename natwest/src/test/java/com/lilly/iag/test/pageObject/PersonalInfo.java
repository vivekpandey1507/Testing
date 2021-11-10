package com.lilly.iag.test.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfo {
	
	
WebDriver driver;
	
	
	@FindBy(xpath = "//a[@class='account']")
	WebElement account;
	@FindBy(xpath = "//a[@title='Information']")
	WebElement personalInformation;
	@FindBy(id = "firstname")
	WebElement firstname;
	@FindBy(id = "old_passwd")
	WebElement oldpassword;
	@FindBy(id = "passwd")
	WebElement newpassword;
	@FindBy(id = "confirmation")
	WebElement confirmpassword;
	@FindBy(name = "submitIdentity")
	WebElement submit;
	@FindBy(xpath ="//a[@class='account']/span")
	WebElement accountName;
	@FindBy(xpath = "//a[@title='Orders']")
	WebElement orderHistory;
	@FindBy(xpath = "//a[@class='color-myaccount']")
	List<WebElement> orderReference;
	
	
	public PersonalInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAccount() {
		account.click();
	}
	
	public void clickOnPersonalInformation() {
		personalInformation.click();
	}
	
	public void enterFirstName(String firstName) {
		firstname.clear();
		firstname.sendKeys(firstName);
	}
	
	public void enterOldPassword(String oldPassword) {
		oldpassword.sendKeys(oldPassword);
	}
	
	public void enterNewPassword(String newPassword) {
		newpassword.sendKeys(newPassword);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmpassword.sendKeys(confirmPassword);
	}
	
	public void clickOnSave() {
		submit.click();
	}
	
	public String getAccountname() {
		return accountName.getText();
	}
	
	public void clickOnOrderHistory() {
		orderHistory.click();
	}
	
	public boolean verifyOrderReference(String referenceStatement) {
		
		boolean result = false;
		for(WebElement elem : orderReference) {
			if(referenceStatement.contains(elem.getText())) {
				result = true;
				break;
			}
		}
		return result;
	}
}
