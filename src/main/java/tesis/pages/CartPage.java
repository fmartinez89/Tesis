package tesis.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject{
	
private By productNameLocator = By.xpath("//td[@class='product-name']//a");
private By checkoutButtonLocator= By.xpath("//div[@class='wc-proceed-to-checkout']//a");


	public String getProductName () {
	System.out.println(find(productNameLocator).getTextValue());
	return find(productNameLocator).getTextValue();
	}
	
	public CheckoutPage goToCheckoutPage() {
		find(checkoutButtonLocator).click();
		CheckoutPage ckpage=this.switchToPage(CheckoutPage.class);
		return ckpage;
	}
}

