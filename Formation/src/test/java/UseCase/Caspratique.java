package UseCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Caspratique {

	public static void main(String[] args) {
		// chemin chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouverture chromedriver

		WebDriver driver = new ChromeDriver();

		// maximise window
		driver.manage().window().maximize();

		// implicity wait

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// ouvrir URL

		driver.get("https://www.google.com/");

		// declaration des elements

		WebElement barre;

		// identification des elements

		barre = driver.findElement(By.name("q"));

		// action

		barre.sendKeys("tunisie");
		barre.sendKeys(Keys.ENTER);

		// verification du resultat

		WebElement resultat;
		resultat = driver.findElement(By.id("result-stats"));

		String texte;
		texte = resultat.getText();

		if (texte.contains("résultats")) {
			System.out.println("test ok");
		} else {
			System.out.println("test ko");
		}

	}

}
