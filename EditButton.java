package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.findElement(By.xpath("//a[@href='pages/Button.html']")).click();
		Thread.sleep(2000);
		Point location = driver.findElement(By.xpath("//button[@id='position']")).getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("Coordinates of an element is : " + x + " and " + y);
		
		WebElement t = driver.findElement(By.xpath("//button[@id='color']"));
		String s = t.getCssValue("background-color");
	      // convert rgba to hex
	      String c = Color.fromString(s).asHex();
	      System.out.println("Color is :" + s);
	      System.out.println("Hex code for color:" + c);
	}

}
