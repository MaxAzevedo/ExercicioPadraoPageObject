package br.com.unipe.exercicio1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteTest {

public static void main(String...args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\max_p\\Downloads\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.navigate().to("http://google.com");
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: "+appTitle);
		driver.quit();
	}
}
