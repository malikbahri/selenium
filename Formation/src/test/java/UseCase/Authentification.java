package UseCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Authentification {

	public static void main(String[] args) throws InterruptedException {

		// chemin de chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouverture de chrome

		WebDriver driver = new ChromeDriver();

		// maximiser window

		driver.manage().window().maximize();

		// acceder a URL

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// sleep

		Thread.sleep(5000);

		// declaration des elements

		WebElement user, mdp, bouton;

		user = driver.findElement(By.name("username"));
		mdp = driver.findElement(By.name("password"));
		bouton = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

		// action

		user.sendKeys("Admin");
		mdp.sendKeys("admin123");
		bouton.click();

		// sleep
		Thread.sleep(5000);

		// verification resultat attendu

		WebElement profil;
		profil = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));

		String nom;
		nom = profil.getText();

		Assert.assertEquals("Paul Collings", nom);
	

		System.out.println("Test ok");

		// close navigateur

		driver.close();

	}

}
