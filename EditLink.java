package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLink {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		//Go to Home Page
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		//Find where am supposed to go without clicking me?
		driver.findElement(By.xpath("//a[@href='pages/Link.html']")).click();
		String value = driver.findElement(By.xpath("//a[@href='Button.html']")).getAttribute("href");
		System.out.println("I am supposed to go to : "+value);
		
		//Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String url = driver.getCurrentUrl();
		String error = driver.findElement(By.tagName("h1")).getText();
		if((url.contains("error"))&&(error.contains("HTTP Status 404")))
		{
			     System.out.println("URL is broken");
		}
		else
		{			
			     System.out.println("URL is working fine");		
		}
		
		//Go to Home Page (Interact with same link name)
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.xpath("(//a[@link='blue'])[3]"));
		
        //How many links are available in this page?
		List<WebElement> Links = driver.findElements(By.xpath("//a"));
		System.out.println("No of links available in the page is : "+Links.size());
				
	}

}
