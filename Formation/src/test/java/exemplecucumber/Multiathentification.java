package exemplecucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Multiathentification {
	WebDriver driver;

	@Given("ouvrir Navigateur4")
	public void ouvrir_navigateur4() {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Given("accéder à url du site {string}")
	public void accéder_à_url_du_site(String string) {
		driver.get(string);

	}

	@When("saisir le username de utilisateur {string}")
	public void saisir_le_username_de_utilisateur(String string) {
		WebElement name;
		name = driver.findElement(By.name("username"));
		name.sendKeys(string);

	}

	@When("saisir le mdp de utlisateur {string}")
	public void saisir_le_mdp_de_utlisateur(String string) {
		WebElement mdp;
		mdp = driver.findElement(By.name("password"));
		mdp.sendKeys(string);

	}

	@When("cliquer sur le boutton se connnecter")
	public void cliquer_sur_le_boutton_se_connnecter() {
		WebElement btnconnexion;
		btnconnexion = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		btnconnexion.click();
	}

	@Then("vérifier le résultat obtenu {string}")
	public void vérifier_le_résultat_obtenu(String string) {
		String URL;
		URL = driver.getCurrentUrl();

		if (URL.equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {

			WebElement messageerreur;
			messageerreur = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
			String texterreur;
			texterreur = messageerreur.getText();
			Assert.assertEquals(string, texterreur);
			System.out.println("test message erreur ok");
			driver.close();

		} else if (URL.equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
			WebElement nomduprofilconnecte;
			nomduprofilconnecte = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));

			String textnameprofilconnecte;
			textnameprofilconnecte = nomduprofilconnecte.getText();

			Assert.assertEquals(string, textnameprofilconnecte);
			System.out.println("test profil connecte ok");
			driver.close();

		} else {
			System.out.println("test ko");
			driver.close();
		}

	}

}
