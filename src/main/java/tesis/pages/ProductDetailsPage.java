package tesis.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import tesis.environment.Variables;
import tesis.model.Product;



@NamedUrls(value = { @NamedUrl(name="productDetails", url= Variables.baseURL+"/{productID}")})
public class ProductDetailsPage extends PageObject{
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);	
	}
	
	private By addToCartButton =By.name("add-to-cart"); 
	private By quantityTextBox = By.xpath("//*[@id=\"quantity_5b7c42ade3cec\"]");
	private By viewCartLink =By.linkText("View cart");
	private By productName =By.className("product_title entry-title");
	Product producto;
	
	/*agrego un producto al carro*/
	public void addProduct () {
		find(addToCartButton).click();
	}
	
	public String getProductTextName () {
		return find(productName).getText();
	}
	public CartPage goToCartPage() {
		find(viewCartLink).click();
		CartPage cartPage = this.switchToPage(CartPage.class);
		return cartPage;
	}
	public void changeProductQuantity(String quantity) {
		find(quantityTextBox).sendKeys(quantity);
	}
	
 
	}


