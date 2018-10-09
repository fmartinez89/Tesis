package tesis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;

public class ShoppingPage extends PageObject{

	public ShoppingPage(WebDriver driver) {
		super(driver);
	}
	private By productDetailsButton = By.xpath("//*[@id=\"main\"]/ul/li[1]/a[1]/img");
	private By viewCartLocatorButton= By.xpath("//ul[@class='products columns-3']//a[@title='View cart']");
	

	public ProductDetailsPage goToProductDetailsPage() {
		find(productDetailsButton).click();
		ProductDetailsPage productPage = this.switchToPage(ProductDetailsPage.class);
		return productPage;
		
	}
}
