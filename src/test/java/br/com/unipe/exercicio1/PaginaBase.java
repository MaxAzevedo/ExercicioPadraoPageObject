package br.com.unipe.exercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Responsavel pelas acoes referente ao objeto driver
 * @author Max Azevêdo
 *
 */
public class PaginaBase {
	WebDriver driver;
	public PaginaBase(WebDriver driver) {
		this.driver = driver;
	}
	public PaginaBase() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\max_p\\Downloads\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}
	public void navegateTo(String url) {
		driver.navigate().to(url);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void quitNavegator() {
		getDriver().quit();
	}
	public String obterValorParametroPorId(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	public String obterValorParametroPorNome(String name) {
		return getDriver().findElement(By.name(name)).getAttribute("value");
	}
	public WebElement obterValorParametroPorXPath(String xpath) {
		WebElement elemento = getDriver().findElement(By.xpath(xpath));
		return elemento;
	}
}
