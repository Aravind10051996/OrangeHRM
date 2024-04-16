package PageObject;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txt_username;
	@FindBy(xpath= "//input[@name='password']")
	WebElement txt_password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_login;
	

    public void enterUsername_and_enterPassword(String filePath) throws IOException {
    	
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		
    	FileReader reader = new FileReader("C://Users/KSPL/eclipse-workspace/MySeleniumProject/PropertiesFile/"+filePath+".txt");
	    
	    Properties pro = new Properties();
	    
	    pro.load(reader);
	    String username = pro.getProperty("username");
	    String password = pro.getProperty("password");
	    
	    txt_username.sendKeys(username);
		txt_password.sendKeys(password);
	}

	public void clickOnLoginButton() {
		btn_login.click();
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	


}
