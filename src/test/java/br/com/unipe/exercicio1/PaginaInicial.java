package br.com.unipe.exercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PaginaInicial extends PaginaBase {
	public PaginaInicial(WebDriver driver) {
		super(driver);
	}
	public PaginaParametros acessaPaginaDeParametros() {
		getDriver().findElement(By.id("btnParametros")).click();
		return new PaginaParametros(getDriver());
	}
	public PaginaDeshboard acessarPaginaDeshboard() {
		getDriver().findElement(By.linkText("Dashboard")).click();
		return new PaginaDeshboard(getDriver());
	}
	
	public PaginaReports acessarReports() {
		getDriver().findElement(By.linkText("Reports")).click();
		return new PaginaReports(getDriver());
	}
}
