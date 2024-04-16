package PageObject;

import java.lang.reflect.Field;
import java.time.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;



import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;


public class Admin extends BaseClass {
	static String newusername = "Aravind007";
	static String editednewusername = "Hari007";
	private WebDriver driver;
	
	
	@FindBy(xpath="//img[@alt='profile picture']//following :: p[@class='oxd-userdropdown-name']")
	WebElement user_profile;

	@FindBy(xpath="//span[text()='Admin']")
	WebElement Admin_Button;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	WebElement before_user_count;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement add_user;
	
	@FindBy(xpath="//label[normalize-space()='User Role']")
	WebElement user_Role;
	
	@FindBy(xpath="//label[normalize-space()='User Role']//following :: div[@class='oxd-select-wrapper']")
    WebElement user_Role_Dropdown;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement Employee_Name;
	
	@FindBy(xpath="//label[normalize-space()='Status']//following :: div[@class='oxd-select-wrapper']")
    WebElement status_Dropdown;
	
	@FindBy(xpath="//label[normalize-space()='Username']//following :: input[@autocomplete='off']")
	WebElement new_user_name_textbox;
	
	@FindBy(xpath="//label[normalize-space()='Password']//following :: input[@type='password']")
	WebElement input_password;
	
	@FindBy(xpath="//label[normalize-space()='Confirm Password']//following :: input[@type='password']")
	WebElement input_confirm_password;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement submit_button;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	WebElement after_user_count;
	
	@FindBy(xpath="//div[@class='oxd-table']//div[@class='oxd-table-body']/child::*")
	List<WebElement> tableRecords;
	
	@FindBy(xpath="//div[@class='oxd-table']")
	WebElement tableName;
	
	@FindBy(xpath="//div[@class='oxd-table']//div[@class='oxd-table-body']//div[@role='cell'][2]")
	List<WebElement> userNameInTable; 
	
	@FindBy(xpath="//input[@autocomplete='off']")
	WebElement editusernametextbox;
	
	@FindBy(xpath="//div[@class='oxd-table']//div[@class='oxd-table-body']//div[@role='row']")
	List<WebElement> recordvalues;
	
	@FindBy(xpath="//div[@class='oxd-table']//div[@class='oxd-table-body']//div[@role='cell']//button[2]")
	WebElement editButton;
	
	@FindBy(xpath="//div[normalize-space()='Username']// following :: input[@class='oxd-input oxd-input--active']")
	WebElement serachUsernametextbox;
	
	@FindBy(xpath="//button[@type='submit' and normalize-space()='Search']")
	WebElement SerachButton;
	
	
	
	public void clickOnAdmin() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Admin_Button));
		
		Admin_Button.click();	
	}
	
	public int geting_the_count_before() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(before_user_count));
		
		int before_number_count = 0;
		String before_count = before_user_count.getText();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(before_count);
		
		 if (matcher.find()) {
	           
	            String numberString = matcher.group();
	            before_number_count = Integer.parseInt(numberString);
		 } 
		 System.out.println(before_number_count);
		 return before_number_count;
		
	}
	
	public void adding_user() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(add_user));
		add_user.click();
	}
	
	public void create_new_admin_page() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(user_Role));
		
		//selecting user type
		Actions action = new Actions(driver);
		action.moveToElement(user_Role_Dropdown).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		//Selecting Employee 
		String userprofile1 = user_profile.getText();
		System.out.println(user_profile.getText());
		action.moveToElement(Employee_Name).click().sendKeys(userprofile1).perform();
		Thread.sleep(2000); //loading time for fetch mandatory suggestions
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		//Selecting status type
		action.moveToElement(status_Dropdown).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		//Entering new admin user 
		new_user_name_textbox.sendKeys(newusername);
		
		//Entering password
		input_password.sendKeys("ara@123");
		
		//Entering confirm password
		input_confirm_password.sendKeys("ara@123");		
	}
	
	public void submit_Button() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(submit_button));
		
		//Click on confirm
		submit_button.click();
	}
	
	public void geting_the_count_after() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(after_user_count));
		
		int after_number_count = 0;
		String after_count = after_user_count.getText();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(after_count);
		
		 if (matcher.find()) {
	           
	            String numberString = matcher.group();
	            after_number_count = Integer.parseInt(numberString);
		 }
		 
		 int before_number_count = geting_the_count_before();
		 System.out.println(before_number_count);
		 System.out.println(after_number_count);
		 SoftAssert softassert = new SoftAssert();
		 softassert.assertEquals(before_number_count+1,after_number_count);	 
	}
	
	public void validatingTheRecordBeforeEdit() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(tableName));
		
//		System.out.println("Size before editing: " +userNameInTable.size());
		
		for(WebElement element  : userNameInTable) {
			 String text = element.getText().trim(); 
			    if (text.equals(newusername)) {
			        System.out.println("record found: " + newusername);
			        break; 
			   }   
		}
	}
	
	public void EditTheRecordAndValidate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(tableName));
		
		
		
		serachUsernametextbox.sendKeys(newusername);
		SerachButton.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(tableName));
		
		editButton.click();

		wait.until(ExpectedConditions.visibilityOf(new_user_name_textbox));
		
		// Click on the input field to ensure it's focused
		editusernametextbox.click();

		// Select all text (Ctrl+A or Cmd+A)
		editusernametextbox.sendKeys(Keys.chord(Keys.CONTROL, "a"));

		// Delete the selected text by pressing the Backspace key
		editusernametextbox.sendKeys(Keys.BACK_SPACE);

		// Now, send the new username
		editusernametextbox.sendKeys(editednewusername);
		submit_button.click();	
	}
	
	
	public void serach_validate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(tableName));
		
		for(WebElement element  : userNameInTable) {
			 String text = element.getText().trim(); 
			    if (text.equals(newusername)) {
			        System.out.println("edited record found: " + newusername);
			        break; 
			   }   
		}
		
		serachUsernametextbox.sendKeys(editednewusername);
		SerachButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(tableName));
		
		for(WebElement element  : userNameInTable) {
			 String text = element.getText().trim(); 
			    if (text.equals(editednewusername)) {
			        System.out.println("edited record found: " + editednewusername);
			        break; 
			   }   
		}	
	}
	
	public Admin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
}
