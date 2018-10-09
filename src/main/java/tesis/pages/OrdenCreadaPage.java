package tesis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;

public class OrdenCreadaPage extends PageObject{

	
	public OrdenCreadaPage(WebDriver driver) {
		super(driver);
	}
	private By tablaInfoLocator= By.xpath("//div[@class='woocommerce-order']//ul//li"); 
	

	@WhenPageOpens
    public boolean validarInformacion() {
		find(tablaInfoLocator).waitUntilVisible();
		return find(tablaInfoLocator).isVisible();
		
    }
}
