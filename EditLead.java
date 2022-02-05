package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Babu'])[1]")).click();
		System.out.println("Page title is : " + driver.getTitle());
		String Title = driver.getTitle();
		if(Title.equalsIgnoreCase("View Lead | opentaps CRM"))
		{
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("HCL");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		boolean check = driver.findElement(By.xpath("//span[contains(text(),'HCL')]")).isDisplayed();
		if(check)
		{
			System.out.println("Company updated successfully");
		}
		else
		{
			System.out.println("Company not updated");
		}
		}
		driver.close();
			
	}

}
