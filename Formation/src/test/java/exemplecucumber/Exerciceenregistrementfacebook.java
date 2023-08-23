package exemplecucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Exerciceenregistrementfacebook {

	WebDriver driver;

	@Given("Ouvrir navigateur2")
	public void ouvrir_navigateur2() {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("Accéder à URL du site {string}")
	public void accéder_à_url_du_site(String string) {
		driver.get(string);
	}

	@When("cliquer sur le boutton créer nouveau compte")
	public void cliquer_sur_le_boutton_créer_nouveau_compte() {
		WebElement créationnvcompte;
		créationnvcompte = driver.findElement(By.xpath("//a[normalize-space()='Créer nouveau compte']"));
		créationnvcompte.click();

	}

	@When("saisir le prenom {string}")
	public void saisir_le_prenom(String string) {
		WebElement prenom;
		prenom = driver.findElement(By.name("firstname"));
		prenom.sendKeys(string);

	}

	@When("saisir le nom {string}")
	public void saisir_le_nom(String string) {
		WebElement nom;
		nom = driver.findElement(By.name("lastname"));
		nom.sendKeys(string);

	}

	@When("saisir adresse mail {string}")
	public void saisir_adresse_mail(String string) {
		WebElement mail;
		mail = driver.findElement(By.name("reg_email__"));
		mail.sendKeys(string);
	}

	@When("confirmer adresse mail saisi")
	public void confirmer_adresse_mail_saisi() {

		WebElement mail;
		mail = driver.findElement(By.name("reg_email__"));

		WebElement confirmationadressemail;
		confirmationadressemail = driver.findElement(By.name("reg_email_confirmation__"));
		Actions action = new Actions(driver);
		action.keyDown(mail, Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		action.keyDown(confirmationadressemail, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

	}

	@When("saisir le mot de passe {string}")
	public void saisir_le_mot_de_passe(String string) {

		WebElement mdp;
		mdp = driver.findElement(By.name("reg_passwd__"));
		mdp.sendKeys(string);

	}

	@When("choisir le chiffre du jour de naissance {string}")
	public void choisir_le_chiffre_du_jour_de_naissance(String string) {

		WebElement journaiss;
		journaiss = driver.findElement(By.name("birthday_day"));
		Select selecte = new Select(journaiss);
		selecte.selectByValue(string);

	}

	@When("choisir le mois de naissance {string}")
	public void choisir_le_mois_de_naissance(String string) {
		WebElement moisnaiss;
		moisnaiss = driver.findElement(By.name("birthday_month"));
		Select selecte = new Select(moisnaiss);
		selecte.selectByVisibleText(string);

	}

	@When("choisir année de naissance {string}")
	public void choisir_année_de_naissance(String string) {
		WebElement anneenaiss;
		anneenaiss = driver.findElement(By.name("birthday_year"));
		Select selecte = new Select(anneenaiss);
		selecte.selectByValue(string);

	}

	@When("choisir le genre {string}")
	public void choisir_le_genre(String string) {
		if (string.equals("Homme")) {
			WebElement genre;
			genre = driver.findElement(By.xpath("//label[normalize-space()='Homme']"));
			genre.click();
		} else if (string.equals("Femme")) {
			WebElement genre;
			genre = driver.findElement(By.xpath("//label[normalize-space()='Femme']"));
			genre.click();
		} else {
			WebElement genre;
			genre = driver.findElement(By.xpath("//label[normalize-space()='Personnalisé']"));
			genre.click();
		}

	}

	@When("cliquer sur le bouton inscrire")
	public void cliquer_sur_le_bouton_inscrire() {
		WebElement bouton;
		bouton = driver.findElement(By.xpath("//button[@name='websubmit']"));
		bouton.click();

	}

	@Then("écrire le message que le compte a été créer avec succès")
	public void écrire_le_message_que_le_compte_a_été_créer_avec_succès() {
		System.out.println("le compte a été créer avec succès");

	}

}
