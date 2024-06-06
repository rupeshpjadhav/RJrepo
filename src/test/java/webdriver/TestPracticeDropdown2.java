package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;

public class TestPracticeDropdown2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement selectDD = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select options = new Select (selectDD);
		
		options.selectByValue("canada");
		options.selectByVisibleText("United Kingdom");
		options.selectByIndex(0);
		
		List<WebElement> EachOption = options.getOptions();
		
		for (WebElement o:EachOption)
		{
			System.out.println(o.getText());
			
			if(o.getText().equals("India"))
			{
				o.click();
			}
			
		}
		
		
		WebElement MultiSelectOption = driver.findElement(By.xpath("//select[@id='colors']"));
		
		Select multiselect = new Select (MultiSelectOption);
		
		multiselect.selectByValue("red");
		multiselect.selectByValue("blue");
		
		multiselect.deselectAll();
		
		
		List<WebElement> mso = multiselect.getOptions();
		
		for (WebElement ms: mso)
		{
			if (ms.getText().equals("Red") || ms.getText().equals("Blue") || ms.getText().equals("Green"))
			{
				ms.click();
			}
		}
		

	}

}
