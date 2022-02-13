package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("leaftest@gmail.com");
		String append = driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).getText();
        String app = "+Testleaf";
        String newString = append.concat(app);
        driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).sendKeys(newString+Keys.TAB);
        String defauttext = driver.findElement(By.xpath("//label[text()='Get default text entered']/following-sibling::input")).getText();
        System.out.println("Default test entered is : "+defauttext);
        driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();
        boolean Status = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).isEnabled();
        if(Status == true)
        {
        	System.out.println("Edit field is enabled");
        }
        else
        {
        	System.out.println("Edit field is disabled");
        }
        }

}
