package com.rbs.CucumberTestNGRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 * Runner Class - Please specify the features="features" where you keep the cucumber feature files
 * glue = {"com.rbs.StepDefinition"} - StepDefinition package has been glued with the runner class
 * 
 * All the available features will be fetched by this runner class and will get executed 
 * 
 * if the Scenarios marked as "@Ignore" then it will not be considered for execution 
 * 
 * 
 */

@CucumberOptions(
//        features = "src/test/resources/features",
		features="features",
        glue = {"com.rbs.StepDefinition"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    @Parameters(value = { "browser", "webSite"} )
    public void feature(CucumberFeatureWrapper cucumberFeature) 
    {
    	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}