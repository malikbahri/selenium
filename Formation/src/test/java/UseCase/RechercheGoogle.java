package UseCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RechercheGoogle {

	public static void main(String[] args) {
		// PATH DRIVER
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouvrir Navigateur
		WebDriver driver = new ChromeDriver();

		// MAXIMAZE BROWSER
		driver.manage().window().maximize();

		// implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// ouvrir URL
		driver.navigate().to("https://www.google.com/");

		// declaration des elements
		WebElement barre;

		// identification des elements
		barre = driver.findElement(By.name("q"));

		// action
		barre.sendKeys("Tunisie");
		barre.sendKeys(Keys.ENTER);

		// verification
		String URL_obtenu;
		URL_obtenu = driver.getCurrentUrl();

		if (URL_obtenu.contains("Tunisie")) {
			System.out.println("test ok");
		} else {
			System.out.println("test ko");
		}

	}

}
