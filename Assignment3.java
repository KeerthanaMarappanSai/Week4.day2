package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static void main(String[] args) {
		//Driver setup
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.get("http://www.leafground.com/pages/Dropdown.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//Select by Index
				WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
				Select select1=new Select(dropDown1);
				select1.selectByIndex(1);
				//Select by visible text
				WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
				Select select2=new Select(dropDown2);
				select2.selectByVisibleText("Loadrunner");
				//Select by value
				WebElement dropDown3 = driver.findElement(By.id("dropdown3"));
				Select select3=new Select(dropDown3);
				select3.selectByValue("1");
				//Drop down size
				WebElement dropDown4 = driver.findElement(By.className("dropdown"));
				Select select4=new Select(dropDown4);
				List<WebElement> options = select4.getOptions();
				System.out.println("No. of drop down options are: " + options.size());

				
				driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select")).sendKeys("Selenium", Keys.ENTER);
				//Select Multiple drown down
				WebElement dropDown5 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select"));
				Select select5 = new Select(dropDown4);
				select5.selectByIndex(1);
				select5.selectByIndex(2);
				
				
	}

}
