package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class LoginPageTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver ();
		
		LoginPage2 LP = new LoginPage2 (driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		
		
		LP.enter_user_nm("standard_user");
		LP.enter_password_nm("secret_sauce");
		LP.click_login_btn();
		
	}

}
