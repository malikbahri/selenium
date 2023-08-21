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

public class Authentificationn {
	
	WebDriver driver;
	
	@Given("ouvrir Navigateur")
	public void ouvrir_navigateur() {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	}

	@Given("ouvrir URL")
	public void ouvrir_url() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   
	}

	@When("saisir username")
	public void saisir_username() {
		WebElement user;
		user=driver.findElement(By.name("username"));
		user.sendKeys("Admin");
	    
	}

	@When("saisir mdp")
	public void saisir_mdp() {
		WebElement mdp;
		mdp = driver.findElement(By.name("password"));
	    mdp.sendKeys("admin123");
	}

	@When("cliquer sur le bouton login")
	public void cliquer_sur_le_bouton_login() {
		WebElement bouton;
		bouton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		bouton.click();
	    
	}

	@Then("verifier le nom du profil")
	public void verifier_le_nom_du_profil() {
		WebElement profil;
		profil = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));

		String nom;
		nom = profil.getText();

		Assert.assertEquals("Paul Collings", nom);
	   
	}

}
