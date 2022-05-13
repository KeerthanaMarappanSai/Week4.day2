package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws IOException, WebDriverException {
		//Driver Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Searching for an product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		//Getting price details for the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of first product is: "+price);
		//Getting customer rating for the first product
		String customerRating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("No of customer Rating for the first product is: "+customerRating);
		//Selecting first image
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		//Window handling
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windowHandles);
		String newWindow = list.get(1);
		driver.switchTo().window(newWindow);
		//Taking screenshot
		File productScreenshot = driver.getScreenshotAs(OutputType.FILE);
		File destImage=new File("./snaps/IMG001.png");
		FileUtils.copyFile(productScreenshot, destImage);
		//Adding to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		//Getting the subtotal value
		String subTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		//Checking the subtotal value
		if(price.contains(subTotal))
		{
			System.out.println("The subtotal is correct");
		}
		
		else
			System.out.println("Subtotal is not correct");
		
		driver.close();
		
	}
}
