package PageObject;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

public class HomePage  {
		private WebDriver driver;
		
		@FindBy(xpath="//h6[text()='Dashboard']")
		WebElement lbl_dasboard;
		
		public void isDashboardDisplayed() {
			lbl_dasboard.isDisplayed();
		}
		
		public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
}


