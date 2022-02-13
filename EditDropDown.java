package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditDropDown {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Select by index
		WebElement down1 = driver.findElement(By.id("dropdown1"));
		Select drop1 = new Select(down1);
		drop1.selectByIndex(1);
		
		//Select by Text
		WebElement down2 = driver.findElement(By.name("dropdown2"));
		Select drop2 = new Select(down2);
		drop2.selectByVisibleText("Selenium");
		
		//Select by Value
		WebElement down3 = driver.findElement(By.id("dropdown3"));
		Select drop3 = new Select(down3);
		drop3.selectByValue("1");
		
		//No of options in the dropdwon
		List<WebElement> options = driver.findElements(By.xpath("//select[@class='dropdown']//option"));
		System.out.println("No of options available in the drop down is : "+options.size());
		
		//Select using Send Keys
		driver.findElement(By.xpath("(//option[text()='Selenium']/parent::select)[5]")).sendKeys("Selenium");
		
		//select your programs
		WebElement select1 = driver.findElement(By.xpath("(//option[text()='Select your programs']/following::option)[1]"));
		WebElement select2 = driver.findElement(By.xpath("(//option[text()='Select your programs']/following::option)[2]"));
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(select1).click(select2).keyUp(Keys.CONTROL).perform();

	}

}
