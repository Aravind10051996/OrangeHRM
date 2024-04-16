package test.stepDefinition;

import java.io.File;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import PageObject.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

//import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.testng.TestNGCucumberRunner;

import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

public class HooksClass extends BaseClass {
	private TestNGCucumberRunner testNGCucumberRunner;
	
    @Before
    public void openUrl() {
    	initializeDriver();
    }
    
    private void takeScreenshot(String fileName) {
        // Take screenshot using WebDriver
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            System.out.println("Screenshot taken: " + fileName);
        }
    }
    
   
    
//    @BeforeStep
//    public void beforeStep() {
//        // Take screenshot before each step
//        takeScreenshot("before_step");
//    }
//
//    @AfterStep
//    public void afterStep() {
//        // Take screenshot after each step
//        takeScreenshot("after_step");
//    }

    @AfterMethod
    public void takeScreenshot1(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getName());
        }
        tearDown();
    }

    private void captureScreenshot(String methodName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Implement logic to save the screenshot with appropriate name
    }
	
    @After
    public void closeBrowser() {
    	tearDown();
    }
	

}
