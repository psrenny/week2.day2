package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Renny");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sunny");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Testlead123@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("12341234");
		
		WebElement Dat= driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select Date = new Select(Dat);
		Date.selectByValue("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Mot= driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select Month = new Select(Mot);
		Month.selectByValue("4");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Yea= driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select Year = new Select(Yea);
		Year.selectByValue("2009");
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		

	}

}
