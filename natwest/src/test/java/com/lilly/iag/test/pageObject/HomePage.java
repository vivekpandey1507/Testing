package com.lilly.iag.test.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	WebElement tShirt;
	@FindBy(xpath = "//a[@class='product_img_link']")
	WebElement productImage;
	@FindBy(id = "add_to_cart")
	WebElement addTocart;
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOut;
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement finalProceedToCheckOut;
	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement processAddress;
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement processCarrier;
	@FindBy(id = "cgv")
	WebElement acceptConditionCheckBox;
	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement bankWire;
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement confirmOrder;
	@FindBy(xpath = "//div[@class='box']")
	WebElement orderDetails;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnTShirts() {
		tShirt.click();
	}

	public void clickOnProductImage() {
		productImage.click();
	}

	public void clickOnAddCart() {
		addTocart.click();
	}

	public void clickOnProceedToCheckOut() {
		proceedToCheckOut.click();
	}

	public void clickOnFinalProceedToCheckout() {
		finalProceedToCheckOut.click();
	}

	public void clickOnProcessAddress() {
		processAddress.click();
	}

	public void clickOnProcessCarrier() {
		processCarrier.click();
	}

	public void clickOnAcceptConditionCheckBox() {

		if (!acceptConditionCheckBox.isSelected()) {
			acceptConditionCheckBox.click();
		}
	}
	
	public void clickOnBankWire(){
		bankWire.click();
	}
	
	public void clickOnConfirmOrder() {
		confirmOrder.click();
	}
	
	public String getOderDetails() {
		return orderDetails.getText();
	}
}
