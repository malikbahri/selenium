package exemplecucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Recherchegoogleexemple {

	WebDriver driver;

	@Given("ouvrir navigateur1")
	public void ouvrir_navigateur1() {

		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("ouvrir URL google {string}")
	public void ouvrir_url_google(String string) {

		driver.get(string);
	}

	@When("saisir le mot {string}")
	public void saisir_le_mot(String string) {

		WebElement barre;
		barre = driver.findElement(By.name("q"));
		barre.sendKeys(string);

	}

	@When("cliquer sur entre")
	public void cliquer_sur_entre() {
		WebElement barre;
		barre = driver.findElement(By.name("q"));
		barre.sendKeys(Keys.ENTER);
	}

	@Then("verifier que la phrase contient le mot {string}")
	public void verifier_que_la_phrase_contient_le_mot(String string) {

		WebElement message;
		message = driver.findElement(By.id("result-stats"));
		String text;
		text = message.getText();
		if (text.contains(string)) {
			System.out.println("test ok");
		} else {
			System.out.println("test ko");
		}
		driver.close();
	}

}
