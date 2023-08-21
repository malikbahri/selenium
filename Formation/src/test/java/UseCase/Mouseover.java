package UseCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouseover {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","src/test/ressources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu");
		
		Thread.sleep(5000);
		
		// declaration webelement
		WebElement menu2;
		menu2=driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
		
		// action
		
		Actions action = new Actions(driver);
		action.moveToElement(menu2).perform();
		
		System.out.println("test menu ok");
		driver.close();
		
		
		
		

	}

}
