package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//Using POM - without page factory
	
	WebDriver ldriver;    // create an object of web driver
	
	public LoginPage (WebDriver rdriver) { //Create constructor with driver reference
		
		ldriver = rdriver;
	}
	
	// create variables for each identified elements
	By user_name = By.id("user-name");
	By pass_word = By.id("password");
	By loginbtn = By.id("login-button");
	
	//create function to find element using the variable and do action on each element 
	
	public void enter_user_nm (String uname) {
		ldriver.findElement(user_name).sendKeys(uname);
	}
	
	public void enter_password_nm (String pname) {
		ldriver.findElement(pass_word).sendKeys(pname);
	}
	
	public void click_login_btn () {
		ldriver.findElement(loginbtn).click();
	}
	
	
	
	
}
