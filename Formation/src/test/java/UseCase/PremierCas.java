package UseCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PremierCas {

	public static void main(String[] args) {
		//chemin chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		//ouvrture de chrome
		WebDriver driver= new ChromeDriver();
		//maximiser la fenetre
		driver.manage().window().maximize();
		//acceder URL
		driver.get("https://www.google.com/");

	}

}
