package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;

public class TestPracticeDropdown3 {

	public static void main(String[] args) throws InterruptedException,StaleElementReferenceException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[3]/div[1]/div[2]/div[1]/div[1]"))
				.click();

		// driver.findElement(By.xpath("//span[normalize-space()='Freelance']")).click();
		Thread.sleep(5000);

		List<WebElement> SelectList = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println(SelectList.size());
		boolean status = false;
		for (WebElement SL : SelectList) {

			System.out.println(SL.getText());
			
			String check = "Full-Time Permanent";
			test:
			if (SL.getText().equals(check) && status == false) {
				SL.click();
				status = true;
				break test;
				

			}

		}

		//stale element reference: stale element not found in the current frame - getting this error
//		for (WebElement SL : SelectList) {
//			String check = "Full-Time Permanent";
//			try {
//				if (SL.getText().equals(check)) {
//					SL.click();
//
//				}
//
//			} catch (StaleElementReferenceException e) {
//				System.out.println(e.toString());
//			}
//
//		}

	}
}
