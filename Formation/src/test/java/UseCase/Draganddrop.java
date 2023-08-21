package UseCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Draganddrop {

	public static void main(String[] args) throws InterruptedException {
		// chemin chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouverture de chrome driver

		WebDriver driver = new ChromeDriver();
		// maximiser window
		driver.manage().window().maximize();
		// acceder a URL

		driver.get("https://demoqa.com/droppable");

		// sleep
		Thread.sleep(5000);

		// declaration des elements

		WebElement drag;
		WebElement drop;

		drag = driver.findElement(By.id("draggable"));
		drop = driver.findElement(By.id("droppable"));

		// action

		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		// sleep
		Thread.sleep(5000);

		// verification resultat attendu

		WebElement draganddrop;
		draganddrop = driver.findElement(By.id("droppable"));

		String texte;
		texte = draganddrop.getText();

		Assert.assertEquals("Dropped!", texte);

		System.out.println("test drag and drop ok");

		driver.close();

	}

}
