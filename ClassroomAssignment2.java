package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomAssignment2 {

	public static void main(String[] args) {
				//Driver setup
				WebDriverManager.chromedriver().setup();
				//Opening Chrome Browser
				ChromeDriver driver = new ChromeDriver();
				//Loading the URL
				driver.get("http://www.leafground.com/pages/Window.html");
				//Maximizing the browser
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.findElement(By.id("home")).click();
				String windowHandle = driver.getWindowHandle();
				
				
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> windowHandlesList=new ArrayList<String>(windowHandles);
				String newWindowHandle = windowHandlesList.get(1);
				System.out.println("Home Page");
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				System.out.println("------------------");
				
				
				driver.switchTo().window(newWindowHandle);
				System.out.println("New Page");
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				System.out.println("------------------");
				
				driver.switchTo().window(windowHandlesList.get(0));
				System.out.println("Home Page");
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				System.out.println("------------------");
				
				driver.quit();
	}
}
