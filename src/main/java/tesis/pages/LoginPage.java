package tesis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import tesis.environment.Messages;
import tesis.model.User;

import org.openqa.selenium.WebDriver;


// This is a web where the browse will be launched, don't call open method. 
@DefaultUrl("http://172.17.228.33:5000/login/")
public class LoginPage extends PageObject{
	
	// with the findBy function we can use string with the xpath or css selector.
	private String username = "//input[@id='email']";
	private String password = "#password";
	
	// Also, the function find uses a By from selenium implementation 
	private By button =By.id("btn-submit"); 
	
	// Finally, just use the annotation in this case the element should be present at DOM when the page is loaded
	@FindBy(id="btn-cancel")
	private WebElement cancelButton;

	private By rememberMeCheckLocator = By.id("remember_me");
	private By logInButtonLocator = By.id("btn-submit");
	private By invalidLoginMessageLocator = By.xpath("//span[contains(text(), '" + Messages.INVALID_LOGIN_MESSAGE + "')]");
	private By emailRequiredLocator = By.xpath("//input[@id='email']//following-sibling::span[text()='" + Messages.EMPTY_EMAIL_LOGIN_MESSAGE + "']");
	private By passwordRequiredLocator = By.xpath("//input[@id='password']//following-sibling::span[text()='" + Messages.EMPTY_PASSWORD_LOGIN_MESSAGE + "']");

	private WebElement emailInput;
	private WebElement passInput;
	private WebElement rememberMeCheck;
	private WebElement logInButton;
	private WebElement invalidLoginMessageSpan;
	private WebElement emailRequiredMessage;
	private WebElement passwordRequiredMessage;
	
	
	@WhenPageOpens
    public void waitUntilTitleAppears() {
        element(cancelButton).waitUntilVisible();
    }
	
	public LoginPage(WebDriver driver) {
		super(driver);
		rememberMeCheck = find(rememberMeCheckLocator);
		logInButton = find(logInButtonLocator);
		invalidLoginMessageSpan = find(invalidLoginMessageLocator);
		emailRequiredMessage = find(emailRequiredLocator);
		passwordRequiredMessage = find(passwordRequiredLocator);
	}
	
	public HomePage login(User user) {
		findBy(username).sendKeys(user.getUserName());
		findBy(password).sendKeys(user.getPassword());
		find(button).click();
		HomePage hp = this.switchToPage(HomePage.class);
		return hp;
	}
	
	public LoginPage attemptsFailedLogin(User user) {
		findBy(username).sendKeys(user.getUserName());
		findBy(password).sendKeys(user.getPassword());
		find(button).click();
		return this;
	}
	
	public boolean isLoginInvalid() {
		invalidLoginMessageSpan = find(invalidLoginMessageLocator);
		return invalidLoginMessageSpan.isDisplayed();
	}
	
	public boolean isEmailEmpty() {
		emailRequiredMessage = find(emailRequiredLocator);
		return emailRequiredMessage.isDisplayed();
	}
	
	public boolean isPasswordEmpty() {
		passwordRequiredMessage = find(passwordRequiredLocator);
		return passwordRequiredMessage.isDisplayed();
	}
}
