package test.stepDefinition;

import org.testng.annotations.Test;

import PageObject.Admin;
import PageObject.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

@Test
public class AdminStepDefinition extends BaseClass {
	private Admin admin = new Admin(driver);
	
	
	@Then("Click on admin in main menu")
	public void click_on_admin_in_main_menu() throws InterruptedException {
		admin.clickOnAdmin();
	}
//	(dependsOnMethods= {"loginStepDefintion"})	
	
	@And("Take the count of the admin user before creation")
	public void take_the_count_of_the_admin_user_before_creation() {
		admin.geting_the_count_before();
	}

	
	@Then("Click on the add admin user button")
	public void click_on_the_add_admin_user_button() {
		admin.adding_user();
	}

	
	@Then("Enter the detials of new admin")
	public void enter_the_detials_of_new_admin() throws InterruptedException {
	    admin.create_new_admin_page();
	}

	
	@And("Click on submit")
	public void click_on_submit() {
	    admin.submit_Button();
	}

	@Then("Take the count of the admin user after creation")
	public void take_the_count_of_the_admin_user_after_creation() throws InterruptedException {
		admin.geting_the_count_after();
	}

	@Then("Validate newly created user record")
	public void validate_newly_created_user_record() throws InterruptedException {
		admin.validatingTheRecordBeforeEdit();
	}

	@Then("Edit the record")
	public void edit_the_record_validate_the_data() throws InterruptedException {
		admin.EditTheRecordAndValidate();
	}
	
	@Then("Search user - Validate the data")
	public void Search_user_Validate_the_data() throws InterruptedException {
		admin.serach_validate();
	}

}
