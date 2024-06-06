package webdriver;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	
	public static void SelectFutureCalendar(WebDriver driver,String expectedMonth,String expectedYear, String expectedDate)
	{
		//select month and year
		while(true)
		{
			String CurrentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String CurrentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			if (CurrentYear.equals(expectedYear) && CurrentMonth.equals(expectedMonth))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//select date
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td/a"));
		
		for (WebElement d:days)
		{
			if (d.getText().equals(expectedDate))
			{
				d.click();
				break;
			}
		}
	}

	public static void SelectPastCalendar(WebDriver driver,String expectedMonth,String expectedYear, String expectedDate)
	{
		//select month and year
		while(true)
		{
			String CurrentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String CurrentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			if (CurrentYear.equals(expectedYear) && CurrentMonth.equals(expectedMonth))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		
		//select date
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td/a"));
		
		for (WebElement d:days)
		{
			if (d.getText().equals(expectedDate))
			{
				d.click();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
        driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		//method 1 - direct send-keys
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06/20/2024"); 
		//method 2 - manual selection
		
		
//		String expectedMonth = "July";
//		String expectedYear = "2025";
//		String expectedDate = "25";
		
		SelectFutureCalendar(driver, "August", "2025", "26");
		//DatePicker.SelectPastCalendar(driver, "August", "2023", "26");
		
		

		
		
		

	}

}
