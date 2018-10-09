package tesis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import tesis.environment.Variables;


@DefaultUrl(Variables.baseURL)
public class HomePage extends PageObject{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By shoppButton = By.xpath("//div[@class='menu']//ul//li//a[text()='Shop']");

	public ShopPage shop() {	
		find(shoppButton).click();
		ShopPage shopPage = this.switchToPage(ShopPage.class);
		return shopPage;
	}
	
}
