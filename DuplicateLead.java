package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("hari@testlesf.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		WebElement Lead = driver.findElement(By.xpath("(//a[@class='linktext'])[6]"));
		String LD = Lead.getText();
		System.out.println(LD);
		Lead.click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		System.out.println("Page title is : " + driver.getTitle());
		String Title = driver.getTitle();
		if(Title.equalsIgnoreCase("Duplicate Lead | opentaps CRM"))
		{
			System.out.println("Duplicate Lead page exists");
			driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		}
		else
		{
			System.out.println("Duplicate Lead page does not exists");
		}
		WebElement LeadDup = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
		String Dup = LeadDup.getText();
		if(LD.equalsIgnoreCase(Dup))
		{
			System.out.println("Duplicate Lead created successfully");
		}
		else
		{
			System.out.println("Duplicate Lead not created");
		}

	}

}
