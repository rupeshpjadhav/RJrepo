package webdriver;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.blazedemo.com/");
		driver.manage().window().maximize();

		WebElement FromList = driver.findElement(By.xpath("//select[@name='fromPort']"));

		Select FromCity = new Select(FromList);

		FromCity.selectByVisibleText("Philadelphia");

		WebElement ToList = driver.findElement(By.xpath("//select[@name='toPort']"));

		Select ToCity = new Select(ToList);

		ToCity.selectByVisibleText("London");

		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		int rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();

		int columms = driver.findElements(By.xpath("//table[@class='table']//th")).size();

		//creating an array list to store all the prices 
		
		List<Float> colarr = new ArrayList<Float>();
			
		for (int r = 1; r <= rows; r++) {
			String Col = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]//td[6]")).getText();
			Col = Col.substring(1); //to remove the first character of $
			float Colnew = Float.parseFloat(Col);   //to parse the string to float
			colarr.add(Colnew); // adding each value to the array list
	
		}
		int listlen = colarr.size();
		for (float x:colarr)
		{
			System.out.println(x); //printing the array list of price
		}
		
		float min = colarr.get(0);
		for (int j=1;j<listlen;j++) { //to get the min price
			
			if (min > colarr.get(j))
			{
				min = colarr.get(j);
			}
		}
		System.out.println("The min price is "+min);
		int newrow = colarr.indexOf(min); //to get the row number for the min price
		
		driver.findElement(By.xpath("//tr["+newrow+"]/td[1]")).click();	//click on row found for min price and 1st column
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Rupesh J");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Bavdhan,Pune");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("411021");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Rupesh Jadhav");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		Thread.sleep(3000);
		String actualtext = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
		String expectedtext = "Thank you for your purchase today!";
		
		if (actualtext.equals(expectedtext))
		{
			System.out.println("Test case passed");
		}
					
	}
}


