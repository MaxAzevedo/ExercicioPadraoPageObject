package br.com.unipe.exercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PaginaParametros extends PaginaBase {
	public PaginaParametros(WebDriver driver) {
		super(driver);
	}
	public String obterValorParametroPorId(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	public String obterValorParametroPorNome(String name) {
		return getDriver().findElement(By.name(name)).getAttribute("value");
	}
	public void confirmarParametros() {
		getDriver().findElement(By.id("btnConfirm")).click();
	}
}
