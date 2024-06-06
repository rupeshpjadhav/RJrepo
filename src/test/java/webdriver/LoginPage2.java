package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	//Using POM - with page factory
	
	WebDriver ldriver;    // create an object of web driver
	
	
	//Create constructor with driver reference
	public LoginPage2 (WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this); //this method will create the web elements
	}
	
	// identify elements using find by annotation
	
	@FindBy (id="user-name")
	WebElement user_name;
	
	@FindBy (id="password")
	WebElement pass_word;
	
	@FindBy (id ="login-button")
	WebElement loginbtn;


	//create function to find element using the above web element and do action on each element 
	
	public void enter_user_nm (String uname) {
		user_name.sendKeys(uname);
	}
	
	public void enter_password_nm (String pname) {
		pass_word.sendKeys(pname);
	}
	
	public void click_login_btn () {
		loginbtn.click();
	}
	
	
	
	
}
