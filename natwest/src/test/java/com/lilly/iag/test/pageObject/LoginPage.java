package com.lilly.iag.test.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn;
	@FindBy(id = "email")
	WebElement loginUsername;
	@FindBy(id = "passwd")
	WebElement loginPassword;
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public void enterUsername(String userName) {
		loginUsername.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		loginPassword.sendKeys(password);
	}
	
	public void clickOnSubmitLogin() {
		submitLogin.click();
	}
	
}
