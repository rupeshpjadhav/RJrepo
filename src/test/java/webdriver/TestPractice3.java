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
import org.openqa.selenium.support.ui.Select;

public class TestPractice3 {
	
	 public static Month convertToMonth(String input) {
	        try {
	            return Month.valueOf(input.toUpperCase());
	        } catch (IllegalArgumentException | NullPointerException e) {
	            // Handling invalid input
	            return null;
	        }
	    }
	 
	 static void SelectCalendar (WebDriver driver, String expMonth, String expYear, String expDate ) 
	 {
		 
			while(true)
			{		
		        //select year and month


				WebElement years = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
				Select selYear = new Select (years);
				selYear.selectByVisibleText(expYear);
				
		        Month expMonthObj = convertToMonth(expMonth);
		        
		        String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		        Month currentMonthObj = convertToMonth(currentMonth);
		        int diff = currentMonthObj.compareTo(expMonthObj);
		        
		        if (diff>0)
		        {
		        	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		        	
		        }
		        else if (diff<0)
		        {
		        	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		        }
		        else 
		        {
		        	break;
		        }
		        
		        
			}
	        
			//select date
			List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td/a"));
			
			for (WebElement d:days)
			{
				if (d.getText().equals(expDate))
				{
					d.click();
					break;
				}
			}
	 }
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.switchTo().frame("frame-one796456169");
		
		// to scroll down, we can use JS executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement selectElement = driver.findElement(By.xpath("//label[@id='q4_label']"));
		js.executeScript("arguments[0].scrollIntoView();", selectElement);


		driver.findElement(By.xpath("//span[@role='button']")).click();
		
		String Month = "november";
		String Year = "2023";
		String Date = "24";

		SelectCalendar(driver, Month, Year, Date);
		


        
	}


}
