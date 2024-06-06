package webdriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).click();
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> links = driver.findElements(By.partialLinkText("Selenium"));
		int linkcount = links.size();
		System.out.println("No of links are : "+linkcount);
		
//		for (WebElement l:links)    // using enhanced for loop
//		{
//			System.out.println((l.getText()));
//			driver.findElement(By.partialLinkText("l")).click();
//			
//		}
		
		java.util.Iterator<WebElement> it = links.iterator();
		
		while (it.hasNext()) // using iterator
		{
			String lc = it.next().getText();
			System.out.println(lc);
			driver.findElement(By.partialLinkText(lc)).click();
		}
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> win = new ArrayList<String>(windows);
		
		for (String w :win)   // using enhanced for loop
		{
			driver.switchTo().window(w);
			String title = driver.switchTo().window(w).getTitle();
			System.out.println(title);

			if (title.equals("Automation Testing Practice"))
					{
				System.out.println(title);
					}
					
			else {
						driver.close();
					}
			
		}
						
		driver.quit();
	}

}
