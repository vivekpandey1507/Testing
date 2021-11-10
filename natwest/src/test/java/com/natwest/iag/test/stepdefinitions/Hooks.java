package com.natwest.iag.test.stepdefinitions;

import io.cucumber.java.After;

public class Hooks {

	@After
	public void tearDown() {
		OrderTShirtAndUpdatePI.driver.quit();
	}
}
