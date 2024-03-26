package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_INPUT);
		sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_INPUT);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_INPUT, password);		
	}

	public String getErrorUnsuccessfull() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}


}
