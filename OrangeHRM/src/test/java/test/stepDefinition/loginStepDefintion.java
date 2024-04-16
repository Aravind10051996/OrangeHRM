package test.stepDefinition;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.BaseClass;
import PageObject.HomePage;
import PageObject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Test
public class loginStepDefintion extends BaseClass {
	private LoginPage loginpage = new LoginPage(driver);
	private HomePage homepage = new HomePage(driver);
	
	@Given("User open url and on login page login")
	public void user_open_url_and_on_login_page_login() throws InterruptedException {
//		 initializeDriver();
		System.out.println("User open url and on login page login");
	}

	@When("User enters valid username and password with file {string}")
	public void user_enters_valid_username_and_password(String filePath) throws IOException, InterruptedException {
		loginpage.enterUsername_and_enterPassword(filePath);
	    Thread.sleep(2000);
	}
	
	
	@And("Clicks on login Button")
	public void clicks_on_login_button() throws InterruptedException {
	  loginpage.clickOnLoginButton();
	  Thread.sleep(2000);
	}

	
	@Then("User should navigate to home page")
	public void user_should_navigate_to_home_page() throws InterruptedException {
//		homepage = new HomePage(driver);
		homepage.isDashboardDisplayed();
		Thread.sleep(2000);
//		baseclass.close_the_browser();
//		tearDown();
	}

//	@AfterSuite
//	public void close_the_browser() {
//		driver.quit();  
//	}

}
