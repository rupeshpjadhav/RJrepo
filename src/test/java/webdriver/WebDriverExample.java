package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		String act_title = driver.getTitle();
		String WinId = driver.getWindowHandle();
		System.out.println(WinId);
		
		System.out.println(act_title);
		
		if (act_title.equals ("Your Store"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		
		driver.findElement(By.name("search")).sendKeys("mac");
//		Thread.sleep(500);
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/button[1]")).click();
//		driver.findElement(By.tagName("button")).click();
//		Thread.sleep(200);
		
		List<WebElement> tabname = driver.findElements(By.className("nav-item"));
		
		
		System.out.println(tabname.size());
		
		System.out.println(tabname.toString());
		
		driver.close(); 
	}

}
