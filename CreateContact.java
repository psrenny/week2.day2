package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click(); 	
		driver.findElement(By.id("firstNameField")).sendKeys("Renny");
		driver.findElement(By.id("lastNameField")).sendKeys("Sunny");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Ren");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Sun");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Learning Selenium");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("psrenny@gmail.com");
        
		WebElement Sta = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select State = new Select(Sta);
		State.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Descriptino updated");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		System.out.println("Page title is : " + driver.getTitle());

	}

}
