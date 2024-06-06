package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;

public class TestPracticeDropdown1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		WebElement CountriesList = driver.findElement(By.xpath("//select[@id='country-list']"));
		System.out.println(CountriesList.getText());
		
		Select SingleCountry = new Select (CountriesList);
		
		SingleCountry.selectByValue("4");
		
		Thread.sleep(5000);
		
		WebElement StateList = driver.findElement(By.xpath("//select[@id='state-list']"));
		//StateList.click();
		System.out.println(StateList.getText());
		
		Select SingleState = new Select (StateList);
		List<WebElement> state = SingleState.getOptions();
		
		for (WebElement st: state)
		{
			if (st.getText().equals("Tamil Nadu"))
			{
				st.click();
			}
			
		}
		//SingleState.selectByValue("24");
		

	
		//driver.findElement(By.xpath("//option[@value='23']")).click();

	}

}
