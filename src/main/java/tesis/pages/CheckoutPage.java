package tesis.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import tesis.model.Customer;
import tesis.model.Address;

public class CheckoutPage extends PageObject{
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

private By nombreLocator = By.id("billing_first_name");
private By apellidoLocator = By.id("billing_last_name");
private By calleLocator = By.id("billing_address_1");
private By departamentoLocator = By.id("billing_address_2");
private By ciudadLocator = By.id("billing_city");
private By estadoLocator = By.id("billing_state");
private By telLocator = By.id("billing_phone");
private By emailLocator = By.id("billing_email");
private By placeOrderButton = By.xpath("//div[@class='form-row place-order']//button[@class='button alt']");
private By codigoPostalLocator = By.id("billing_postcode");
private By paisLocator=By.xpath("//div[@class='woocommerce-billing-fields']//span//select[@name='billing_country']");
private By errorMsgLocator= By.xpath("//ul[@class='woocommerce-error']");
private By blockOverlayLocator = By.xpath("[contains(@class, \"blockUI\")]')");
public void completarFormularioCompra(Customer cliente) {
	find(nombreLocator).sendKeys(cliente.getNombre());
	find(apellidoLocator).sendKeys(cliente.getApellido());
	find(telLocator).sendKeys(cliente.getTelefono());
	find(emailLocator).sendKeys(cliente.getEmail());
	find(placeOrderButton).waitUntilClickable();
	}
public void completarDatosDireccion(Address direccion) {
	find(paisLocator).waitUntilVisible();
	Select paisDropdown = new Select(find(paisLocator));
	paisDropdown.selectByValue(direccion.getPais());	
	Select estadoDropdown = new Select(getDriver().findElement(By.xpath("//div[@class='woocommerce-billing-fields']//span//select[@name='billing_state']")));
	estadoDropdown.selectByValue(direccion.getEstado());
	find(ciudadLocator).sendKeys(direccion.getCiudad());
	find(calleLocator).sendKeys(direccion.getCalle());
	find(codigoPostalLocator).sendKeys(direccion.getCodigoPostal());
	}

public OrdenCreadaPage goToOrdenCreadaPage() {
	find(placeOrderButton).waitUntilClickable();
	find(placeOrderButton).click();
	OrdenCreadaPage ordenCreada = this.switchToPage(OrdenCreadaPage.class);
	return ordenCreada;
}
public boolean validarMensajesError() throws InterruptedException {
	
	Thread.sleep(2000);
	//getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	find(placeOrderButton).waitUntilClickable();
	find(placeOrderButton).click();
	find(errorMsgLocator).waitUntilVisible();
	getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	return find(errorMsgLocator).isVisible();
	}

}


