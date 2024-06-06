package webdriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPractice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='male']")).click();
		driver.findElement(By.xpath("//label[@for='female']")).click();
		driver.findElement(By.xpath("//input[@id='male']")).click();

		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@class = 'form-check-input' and @type = 'checkbox']"));

		for (WebElement checkbox : checkboxes) {
			checkbox.click();
		}

		for (int i = 0; i < 3; i++) {

			checkboxes.get(i).click();

		}

		for (int i = 0; i < checkboxes.size(); i++) {
			if (checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}

		}

		driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();
		Thread.sleep(10);
		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();

		driver.findElement(By.xpath("//button[normalize-space()='Confirm Box']")).click();
		Thread.sleep(10);
		Alert myalert2 = driver.switchTo().alert();
		System.out.println(myalert2.getText());
		myalert2.accept();

		driver.findElement(By.xpath("//button[normalize-space()='Confirm Box']")).click();
		Thread.sleep(10);
		Alert myalert3 = driver.switchTo().alert();
		System.out.println(myalert3.getText());
		myalert3.dismiss();

		driver.findElement(By.xpath("//button[normalize-space()='Prompt']")).click();
		Thread.sleep(10);
		Alert myprompt = driver.switchTo().alert();
		System.out.println(myprompt.getText());
		myprompt.sendKeys("Rupesh Jadhav");
		myprompt.accept();

		// driver.quit();
	}

}
