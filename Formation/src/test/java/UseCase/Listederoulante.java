package UseCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Listederoulante {

	public static void main(String[] args) {
		// chemin chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		// ouverture du navigateur

		WebDriver driver = new ChromeDriver();
		// maximiser

		driver.manage().window().maximize();
		// implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// accéder a URL
		driver.get("https://demoqa.com/select-menu");

		// identification des elements

		WebElement liste;
		liste = driver.findElement(By.id("oldSelectMenu"));

		// appel de la class select

		Select selecte = new Select(liste);
		selecte.selectByValue("7");

		System.out.println("test ok : liste déroulante affiche la couleur violet");

	}

}
