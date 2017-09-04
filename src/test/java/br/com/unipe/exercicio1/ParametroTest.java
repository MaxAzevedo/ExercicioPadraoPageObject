package br.com.unipe.exercicio1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class ParametroTest extends TestCase {
	protected PaginaBase paginaBase = new PaginaBase();;
	protected PaginaLogin paginaLogin;
	protected PaginaInicial paginaInicial;
	protected PaginaParametros paginaParametros;

	public void testExercicioSucesso() throws Exception {
		acessandoPaginaLogin();
		logar();
		acessarMenuDeshbard();
		acessarMenuReports();
		fechaNavegador();
	}

	public void testExercicioNegacao() throws Exception {
		acessandoPaginaLogin();
		logarEmailInvalido();
		logarSenhaInvalida();
		fechaNavegador();
	}

	public void testExercicioUsabilidade() {
		acessandoPaginaLogin();
		logar();	
	}

	private void acessandoPaginaLogin() {
		this.paginaBase.navegateTo("http://amasik.com/demo/angularjs/angular-app/#/login");
		WebDriverWait wait = new WebDriverWait(this.paginaBase.getDriver(), 10);//segundos 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		Assert.assertNotNull(this.paginaBase);
	}
	private void logar() {
		this.paginaLogin = new PaginaLogin(this.paginaBase.getDriver());
		this.paginaInicial = paginaLogin.logar("teste@gmail.com","12345");
		Assert.assertNotNull(this.paginaInicial);
	}

	private void logarEmailInvalido() {
		this.paginaLogin = new PaginaLogin(this.paginaBase.getDriver());
		this.paginaInicial = paginaLogin.logar("teste","12345");
		Assert.assertNotNull(this.paginaInicial.obterValorParametroPorXPath("//span/p[@class='validation-invalid']"));
	}

	private void logarSenhaInvalida() {
		this.paginaLogin = new PaginaLogin(this.paginaBase.getDriver());
		this.paginaInicial = paginaLogin.logar("teste@gmail.com","");
		Assert.assertNotNull(this.paginaInicial.obterValorParametroPorXPath("//span/p[@class='validation-invalid']"));
	}

	private void acessarMenuDeshbard() {
		WebDriverWait wait = new WebDriverWait(this.paginaBase.getDriver(), 10);//segundos 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
		PaginaDeshboard paginaDeshboard = paginaInicial.acessarPaginaDeshboard();
		Assert.assertNotNull(paginaDeshboard);
	}
	private void acessarMenuReports() {
		WebDriverWait wait = new WebDriverWait(this.paginaBase.getDriver(), 10);//segundos 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Reports")));
		PaginaReports paginaReports = paginaInicial.acessarReports();
		Assert.assertNotNull(paginaReports);
	}
	private void fechaNavegador() {
		this.paginaBase.quitNavegator();
	}
}