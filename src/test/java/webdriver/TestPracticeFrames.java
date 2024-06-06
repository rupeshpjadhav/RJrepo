package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestPracticeFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		// frame 1

		WebElement frame1 = driver.findElement(By.xpath("/html[1]/frameset[1]/frame[1]"));

		driver.switchTo().frame(frame1);

		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello");

		driver.switchTo().defaultContent();

		// frame 3

		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));

		driver.switchTo().frame(frame3);

		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Welcome");

		// frame inside frame

		driver.switchTo().frame(0);

		// We can also use JS executor as follows to click a webelement
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement radioSelect = driver.findElement(By.xpath("//span[normalize-space()='I am a human']"));
		js.executeScript("arguments[0].click();", radioSelect);

		// to scroll down, we can use JS executor
		WebElement selectElement = driver.findElement(By.xpath("//span[normalize-space()='Web Testing']"));
		js.executeScript("arguments[0].scrollIntoView();", selectElement);
		selectElement.click();

		driver.switchTo().defaultContent();

		// driver.close();

	}

}
