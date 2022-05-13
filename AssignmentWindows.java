package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentWindows {

	public static void main(String[] args) {
		//driver setup
		WebDriverManager.chromedriver().setup();
		//Opening Chrome Browser
		ChromeDriver driver=new ChromeDriver();
		//Entering URL
		driver.get("http://www.leafground.com/pages/Window.html");
		//Maximize the browser
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//First window
		driver.findElement(By.id("home")).click();
		//Window Handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windowHandles);
		String newWindow = list.get(1);
		driver.switchTo().window(newWindow);
		//Getting current page URL
		System.out.println("New page");
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		//Back to home page
		driver.switchTo().window(list.get(0));
		//Second window
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();
		//Window Handles
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(windowHandles1);
		String newWindow1 = list1.get(1);
		driver.switchTo().window(newWindow1);
		//Getting current page URL
		System.out.println("New page");
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		//Back to home page
		driver.switchTo().window(list.get(0));
		//Third window
		driver.findElement(By.xpath("//button[contains(text(),'Do not close me ')]")).click();
		//Window Handling
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list2=new ArrayList<String>(windowHandles2);
		String newWindow2 = list2.get(1);
		driver.switchTo().window(newWindow2);
		//Getting current page URL
		System.out.println("New page");
		System.out.println(driver.getCurrentUrl());
	
				
		driver.close();
		//Back to home page
		driver.switchTo().window(list.get(0));
		//Fourth page
		driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
		//Window Handling
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> list3=new ArrayList<String>(windowHandles3);
		String newWindow3 = list3.get(1);
		driver.switchTo().window(newWindow3);
		//Getting current page URL
		System.out.println("New page");
		System.out.println(driver.getCurrentUrl());
		
		//Closing all the windows
		driver.quit();
		
		
		
	}
}
