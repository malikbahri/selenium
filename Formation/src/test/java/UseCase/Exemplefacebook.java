package UseCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Exemplefacebook {

	public static void main(String[] args) {
		// chemin chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouverture chromedriver

		WebDriver driver = new ChromeDriver();

		// maximise window
		driver.manage().window().maximize();

		// implicity wait

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// ouvrir URL

		driver.get("https://www.facebook.com/");

		// declaration des elements
		WebElement créationnvcompte;
		créationnvcompte = driver.findElement(By.xpath("//a[normalize-space()='Créer nouveau compte']"));

		// action
		créationnvcompte.click();

		// declaration des elements

		WebElement prenom;
		WebElement nom;
		WebElement mail;
		WebElement confirmationmail;
		WebElement mdp;
		WebElement journaiss;
		WebElement moisnaiss;
		WebElement annenaiss;
		WebElement genre;
		WebElement inscription;

		// action
		prenom = driver.findElement(By.xpath("//input[@name='firstname']"));
		prenom.sendKeys("malek");

		nom = driver.findElement(By.xpath("//input[@name='lastname']"));
		nom.sendKeys("mohamed");

		mail = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		mail.sendKeys("malekmohamed@gmail.com");

		confirmationmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		Actions action = new Actions(driver);

		action.keyDown(mail, Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		action.keyDown(confirmationmail, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		mdp = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		mdp.sendKeys("malekmohamed123456");

		journaiss = driver.findElement(By.xpath("//select[@title='Jour']"));
		Select selecte = new Select(journaiss);
		selecte.selectByValue("1");

		moisnaiss = driver.findElement(By.name("birthday_month"));
		Select selecte1 = new Select(moisnaiss);
		selecte1.selectByVisibleText("jan");

		annenaiss = driver.findElement(By.name("birthday_year"));
		Select selecte2 = new Select(annenaiss);
		selecte2.selectByValue("1986");

		genre = driver.findElement(By.xpath("//label[normalize-space()='Homme']"));
		genre.click();

		inscription = driver.findElement(By.xpath("//button[@name='websubmit']"));
		inscription.click();

		System.out.println("test ok");

	}

}
