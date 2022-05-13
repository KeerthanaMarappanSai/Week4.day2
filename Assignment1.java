package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
				//Driver setup
				WebDriverManager.chromedriver().setup();
				//Opening Chrome Browser
				ChromeDriver driver = new ChromeDriver();
				//Loading the URL
				driver.get("http://leaftaps.com/opentaps/control/login");
				//Maximizing the browser
				driver.manage().window().maximize();
				//Login Credentials
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
				driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
				//Navigating to next page using linktext locator
				driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
				
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
				
				driver.findElement(By.xpath("//img[contains(@src,'/images/fieldlookup.gif')]")).click();
				//Set<String> windowHandles = driver.getWindowHandles();
				//List<String> windowHandlesList=new ArrayList<String>(windowHandles);
				//String newWindowHandle = windowHandlesList.get(1);
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> list = new ArrayList<String>(windowHandles);
				String newwindowHandles = list.get(1);
				driver.switchTo().window(newwindowHandles);

				
				Thread.sleep(3000);
				
				// Clicking first Resulting contact
				driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

				// giving control back to base window
				driver.switchTo().window(list.get(0));

				// Clicking on To Contact widget
				driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

				// Assigning new windowsHandles and switching to new window

				Set<String> windowHandles1 = driver.getWindowHandles();
				List<String> list1 = new ArrayList<String>(windowHandles1);
				String newwindowHandles1 = list1.get(1);
				driver.switchTo().window(newwindowHandles1);

				Thread.sleep(3000);
				// Clicking first Resulting contact
				driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

				// giving control back to base window
				driver.switchTo().window(list1.get(0));

				// Clicking on Merge button
				driver.findElement(By.xpath("//a[text()='Merge']")).click();

				// Switching to alert
				Alert alert = driver.switchTo().alert();

				// Accepting Alert
				alert.accept();

				// Viewing title of the page
				System.out.println("The Title of the Page is: " + driver.getTitle());
			
				
				
				
	}
}
