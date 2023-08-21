package UseCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeysEvents {

	public static void main(String[] args) throws InterruptedException {
		// chemin de chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouverture de chrome

		WebDriver driver = new ChromeDriver();

		// maximiser window

		driver.manage().window().maximize();

		// acceder a URL

		driver.get("https://demoqa.com/text-box");

		// sleep

		Thread.sleep(5000);

		// declaration des elements

		WebElement user, mdp;

		user = driver.findElement(By.id("userName"));
		mdp = driver.findElement(By.id("userEmail"));
		
		user.sendKeys("Bonjour");
		
		Actions action =new Actions(driver);
		
		action.keyDown(user, Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		action.keyDown(mdp, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

	}

}
