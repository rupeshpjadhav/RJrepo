package webdriver;

import java.time.Duration;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestPractice5 {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//open a new webpage in a new tab by using ctrl + click and then switching the window
		WebElement reglink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions act = new Actions (driver);
		
		act.keyDown(Keys.CONTROL).click(reglink).keyUp(Keys.CONTROL).perform();
		
		//Set<String> pages = driver.getWindowHandles();
		
		List<String> pg = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(pg.get(1));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Rupesh J");
		driver.switchTo().window(pg.get(0));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Samsung");
		
		//open a new webpage in a new tab and make it active by default
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://testautomationpractice.blogspot.com/");
		//open a new webpage in a new window and make it active by default
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://demo.opencart.com/");
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
		
        
	}


}
