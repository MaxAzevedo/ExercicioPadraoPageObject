package br.com.unipe.exercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class PaginaLogin extends PaginaBase {
	public PaginaLogin(WebDriver driver) {
		super(driver);
	}
	public PaginaInicial logar(String userName, String userPassword) {
		realizaLogin(userName, userPassword);
		return new PaginaInicial(getDriver());
	}
	private void realizaLogin(String userName, String userPassword) {
		WebElement email = getDriver().findElement(By.xpath("//input[@name='email']"));
		email.clear();
		email.sendKeys(userName);
		
		WebElement password = getDriver().findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys(userPassword);
		
		getDriver().findElement(By.xpath("//button[@class='button btn btn-success btn-large']")).click();
	}
}