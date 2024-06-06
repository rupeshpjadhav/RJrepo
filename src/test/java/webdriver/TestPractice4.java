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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestPractice4 {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// to scroll down, we can use JS executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement selectElement = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		js.executeScript("arguments[0].scrollIntoView();", selectElement);
		
		// to double click
		WebElement input1 = driver.findElement(By.xpath("//input[@id='field1']"));
		input1.clear();
		input1.sendKeys("Welcome everyone");
		WebElement input2 = driver.findElement(By.xpath("//input[@id='field2']"));
		
		WebElement DDclick = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		Actions act = new Actions(driver);
		act.doubleClick(DDclick).perform();
		
		String inputvalue1 = input1.getAttribute("value");
		String inputvalue2 = input2.getAttribute("value");
		
		if (inputvalue2.equals(inputvalue1)) {
			System.out.println("Test Case passed");
		}
		else
		{
			System.out.println("Test failed");
		}

        //drag and drop
		
		WebElement ScrollElement = driver.findElement(By.xpath("//h2[normalize-space()='Drag and Drop']"));
		js.executeScript("arguments[0].scrollIntoView();", ScrollElement);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dest = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Action ddaction = act.dragAndDrop(source, dest).build();
		ddaction.perform();
		

        
	}


}
