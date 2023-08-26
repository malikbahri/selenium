package exemplecucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class Multiinscriptionfacebook {

	WebDriver driver;

	@Given("Ouvrir navigateur3")
	public void ouvrir_navigateur3() {

		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Given("Accéder à URL de facebook {string}")
	public void accéder_à_url_de_facebook(String string) {

		driver.get(string);

	}

	@When("cliquer sur le boutton création de nouveaux comptes")
	public void cliquer_sur_le_boutton_création_de_nouveaux_comptes() {
		WebElement newcompte;
		newcompte = driver.findElement(By.xpath("//a[normalize-space()='Créer nouveau compte']"));
		newcompte.click();

	}

	@When("saisir le first name {string}")
	public void saisir_le_first_name(String string) {
		WebElement prenomutilisateur;
		prenomutilisateur = driver.findElement(By.name("firstname"));
		prenomutilisateur.sendKeys(string);

	}

	@When("saisir le name {string}")
	public void saisir_le_name(String string) {
		WebElement nomdeutilisateur;
		nomdeutilisateur = driver.findElement(By.name("lastname"));
		nomdeutilisateur.sendKeys(string);

	}

	@When("saisir email {string}")
	public void saisir_email(String string) {
		WebElement adressemail;
		adressemail = driver.findElement(By.name("reg_email__"));
		adressemail.sendKeys(string);

	}

	@When("confirmer email saisi")
	public void confirmer_email_saisi() {
		WebElement adressemail;
		adressemail = driver.findElement(By.name("reg_email__"));

		WebElement confirmationadressemailnvutilisateur;
		confirmationadressemailnvutilisateur = driver.findElement(By.name("reg_email_confirmation__"));
		Actions action = new Actions(driver);
		action.keyDown(adressemail, Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		action.keyDown(confirmationadressemailnvutilisateur, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

	}

	@When("saisir le password {string}")
	public void saisir_le_password(String string) {
		WebElement motdepasse;
		motdepasse = driver.findElement(By.name("reg_passwd__"));
		motdepasse.sendKeys(string);

	}

	@When("choisir day of birth {string}")
	public void choisir_day_of_birth(String string) {
		WebElement numerodejourdenaissance;
		numerodejourdenaissance = driver.findElement(By.name("birthday_day"));
		Select selecte = new Select(numerodejourdenaissance);
		selecte.selectByValue(string);

	}

	@When("choisir month of birth {string}")
	public void choisir_month_of_birth(String string) {
		WebElement lemoisdenaissance;
		lemoisdenaissance = driver.findElement(By.name("birthday_month"));
		Select selecte = new Select(lemoisdenaissance);
		selecte.selectByVisibleText(string);

	}

	@When("choisir year of birth {string}")
	public void choisir_year_of_birth(String string) {
		WebElement anneedenaissance;
		anneedenaissance = driver.findElement(By.name("birthday_year"));
		Select selecte = new Select(anneedenaissance);
		selecte.selectByValue(string);

	}

	@When("choisir gendre {string}")
	public void choisir_gendre(String string) {
		if (string.equals("Homme")) {
			WebElement sexdeutilisateur;
			sexdeutilisateur = driver.findElement(By.xpath("//label[normalize-space()='Homme']"));
			sexdeutilisateur.click();
		} else if (string.equals("Femme")) {
			WebElement sexdeutilisateur;
			sexdeutilisateur = driver.findElement(By.xpath("//label[normalize-space()='Femme']"));
			sexdeutilisateur.click();
		} else {
			WebElement sexdeutilisateur;
			sexdeutilisateur = driver.findElement(By.xpath("//label[normalize-space()='Personnalisé']"));
			sexdeutilisateur.click();
		}

	}

	@When("cliquer sur le bouton inscription facebook")
	public void cliquer_sur_le_bouton_inscription_facebook() {
		WebElement boutoninscription;
		boutoninscription = driver.findElement(By.xpath("//button[@name='websubmit']"));
		boutoninscription.click();

	}

	@Then("écrire le message de création de compte avec succès")
	public void écrire_le_message_de_création_de_compte_avec_succès() {
		System.out.println("création de compte avec succès");
		driver.close();

	}

}
