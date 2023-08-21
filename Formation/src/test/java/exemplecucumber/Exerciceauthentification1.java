package exemplecucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Exerciceauthentification1 {

	WebDriver driver;

	@Given("ouvrir le Navigateur chrome")
	public void ouvrir_le_navigateur_chrome() {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Given("ouvrir URL du site de orange")

	public void ouvrir_url_du_site_de_orange() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("saisir le username de administrateur")
	public void saisir_le_username_de_administrateur() {
		WebElement usernameadministrateur;
		usernameadministrateur = driver.findElement(By.name("username"));
		usernameadministrateur.sendKeys("Admin");

	}

	@When("saisir le mdp de administrateur")
	public void saisir_le_mdp_de_administrateur() {
		WebElement mdpadministrateur;
		mdpadministrateur = driver.findElement(By.name("password"));
		mdpadministrateur.sendKeys("admin123");

	}

	@When("cliquer sur le boutton se connecter")
	public void cliquer_sur_le_boutton_se_connecter() {
		WebElement bouttonconnexion;
		bouttonconnexion = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		bouttonconnexion.click();
	}

	@Then("verifier le nom du profil affiché")
	public void verifier_le_nom_du_profil_affiché() {
		WebElement nomduprofil;
		nomduprofil = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));

		String textname;
		textname = nomduprofil.getText();

		Assert.assertEquals("Paul Collings", textname);
	}

}
