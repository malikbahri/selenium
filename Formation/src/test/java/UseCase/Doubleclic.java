package UseCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Doubleclic {

	public static void main(String[] args) throws InterruptedException {

		// chemin chrome driver

		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouverture de chrome

		WebDriver driver = new ChromeDriver();

		// maximiser window

		driver.manage().window().maximize();

		// acceder a URL

		driver.get("https://demoqa.com/buttons");

		// sleep

		Thread.sleep(5000);

		// declaration des elements

		WebElement doubleclick;

		doubleclick = driver.findElement(By.id("doubleClickBtn"));

		// action

		Actions action = new Actions(driver);
		action.doubleClick(doubleclick).perform();

		// sleep
		Thread.sleep(5000);

		// verification resultat attendu

		WebElement messagedoubleclick;
		messagedoubleclick = driver.findElement(By.id("doubleClickMessage"));

		String texte;
		texte = messagedoubleclick.getText();

		Assert.assertEquals("You have done a double click", texte);

		System.out.println("Test double click ok");

		// boutton droit

		WebElement bouttondroit;
		bouttondroit = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(bouttondroit).perform();
		Thread.sleep(5000);

		WebElement messageclickbouttondroit;
		messageclickbouttondroit = driver.findElement(By.id("rightClickMessage"));

		String texte1;
		texte1 = messageclickbouttondroit.getText();
		Assert.assertEquals("You have done a right click", texte1);

		System.out.println("Test click boutton droit ok");

		driver.close();

	}

}
