package pageUIs;

public class RegisterPageUI {
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='LastName']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='LastName']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='LastName']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";

	public static final String FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	public static final String EMAIL_EXISTING_ERROR_MESSAGE = "//div[contains(@class,'message-error')]//li";

	public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
	public static final String CONTINUE_BUTTON = "//a[@class='button-1 register-continue-button']";
	
}
