package com.natwest.iag.test.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lilly.iag.test.pageObject.HomePage;
import com.lilly.iag.test.pageObject.LoginPage;
import com.lilly.iag.test.pageObject.PersonalInfo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderTShirtAndUpdatePI {

	public static WebDriver driver;
	PersonalInfo pi;
	String referenceStatement;
	
	@SuppressWarnings("deprecation")
	@Given("Open application in browser")
	public void open_application_in_browser(){
		System.setProperty("webdriver.chrome.driver",".\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/");
	}
	
	
	@Given("User logins with username and password into application")
	public void user_logins_with_username_and_password_into_application() {
		
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		LoginPage login = new LoginPage(driver);
		login.clickOnSignIn();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnSubmitLogin();
	}
	
	@When("Order T Shirt")
	public void order_t_shirt() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnTShirts();
		homePage.clickOnProductImage();
		WebElement frameElem = driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
		driver.switchTo().frame(frameElem);
		homePage.clickOnAddCart();
		driver.switchTo().defaultContent();
		homePage.clickOnProceedToCheckOut();
		homePage.clickOnFinalProceedToCheckout();
		homePage.clickOnProcessAddress();
		homePage.clickOnAcceptConditionCheckBox();
		homePage.clickOnProcessCarrier();	
		homePage.clickOnBankWire();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage.clickOnConfirmOrder();
		referenceStatement = homePage.getOderDetails();
		
	}
	
	@Then("Verify in order history")
	public void verify_in_order_history() {
	    pi = new PersonalInfo(driver);
	    pi.clickOnAccount();
	    pi.clickOnOrderHistory();
	    assertTrue(pi.verifyOrderReference(referenceStatement));
	}
	
	@When("Update Personal Information First Name in my account")
	public void update_personal_information_first_name_in_my_account(){
		
		String firstName = System.getProperty("firstName");
		String oldPassword = System.getProperty("password");
		String newPassword =System.getProperty("newPassword");
		pi = new PersonalInfo(driver);
		pi.clickOnAccount();
		pi.clickOnPersonalInformation();
		pi.enterFirstName(firstName);
		pi.enterOldPassword(oldPassword);
		pi.enterNewPassword(newPassword);
		pi.enterConfirmPassword(newPassword);
		pi.clickOnSave();
	}
	
	@Then("Verify information is updated")
	public void verify_information_is_updated() {
		
		String firstName = System.getProperty("firstName");
		assertTrue(pi.getAccountname().contains(firstName));
	}
}
