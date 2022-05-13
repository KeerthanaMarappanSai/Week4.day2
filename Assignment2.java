package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		//Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Frame1
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);
		//Sending values to Topic
		driver.findElement(By.xpath("/html/body/input")).sendKeys("Frame Handling");
		//Frame 3
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame3);
		//Selecting Check box
		driver.findElement(By.xpath("//input[@id='a']")).click();
		//Back to home page and out of frame
		driver.switchTo().defaultContent();
		//Frame2
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		//Sending values values to dropdown
		driver.findElement(By.id("animals")).sendKeys("Baby Cat");
		
		driver.close();
		
		
		
	}
}
