package com.natwest.iag.test.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "resources/features/", glue = { "com.natwest.iag.test.stepdefinitions" }, plugin = { "pretty", "html:target/cucumber-reports" })
public class TestRunner {

	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void initializeCucumberRunner() throws Exception {

		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(dataProvider = "scenarios")
	public void featureRunner(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Exception {
		
		testNGCucumberRunner.runScenario(pickle.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

}
