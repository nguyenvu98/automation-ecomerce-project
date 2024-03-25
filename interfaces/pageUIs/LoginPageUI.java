package pageUIs;

public class LoginPageUI {
	public static final String LOGIN_BUTTON = "//button[contains(@class,'login-button')]";
	public static final String EMAIL_INPUT = "//input[@id='Email']"; 
	public static final String PASSWORD_INPUT = "//input[@id='Password']";
	public static final String EMAIL_ERROR_MESSAGE = "//div[@class='inputs']//span[@id='Email-error']";
	public static final String EMAIL_UNREGISTERED_ERROR_MESSAGE = "//div[contains(@class,'message-error')]//li";
}
