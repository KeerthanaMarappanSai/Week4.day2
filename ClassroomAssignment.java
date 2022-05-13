package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomAssignment {

	public static void main(String[] args) {
		//Driver setup
		WebDriverManager.chromedriver().setup();
		//Opening Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		//Loading the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		//Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//WebElement frameElement = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Keerthana");
		promptAlert.accept();
		String text = driver.findElement(By.id("demo")).getText();
		if(text.contains("Keerthana"))
		{
			System.out.println("The text contains Keerthana");
		}
		
		
		
	}
}
