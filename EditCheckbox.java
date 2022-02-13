package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCheckbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Select the languages you know
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		
		//Check whether Selenium is selected
		boolean status = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).isSelected();
		if(status==true)
		{
			System.out.println("Selenium is selected");
		}
		else
		{
			System.out.println("Selenium is not selected");
		}
		
		//de-select the checked item
		driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		
		//Select all options
		List<WebElement> checkbox = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::div/input"));
		for(WebElement check : checkbox) {
			check.click();
		}

	}

}
