package com.ecomerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		homePage= new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
		firstName = "vu98";
		lastName = "vo";
		emailAddress ="vupro"+ randomNumber() +"@yahoo.com";
		password = "123456";
	}

	@Test
	public void TC_01_Register_Emty_Data() {
		homePage.clickToRegisterLink();
		
//		waitForElementClickable(driver,"//a[@class='ico-register']");
//		clickToElement(driver,"//a[@class='ico-register']");
		
		registerPage.clickToRegisterButton();
//		waitForElementClickable(driver,"//button[@id='register-button']");
//		clickToElement(driver,"//button[@id='register-button']");

		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");

//		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
		homePage.clickToRegisterLink();
		
//		waitForElementClickable(driver,"//a[@class='ico-register']");
//		clickToElement(driver,"//a[@class='ico-register']");
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("Vu dep trai");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
//		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
//		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
//		sendkeyToElement(driver, "//input[@id='Email']", "Vu dep trai");
//		sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		registerPage.clickToRegisterButton();
//		waitForElementClickable(driver,"//button[@id='register-button']");
//		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
//		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_Success() {
		homePage.clickToRegisterLink();

//		waitForElementClickable(driver,"//a[@class='ico-register']");
//		clickToElement(driver,"//a[@class='ico-register']");
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
//		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
//		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
//		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		registerPage.clickToRegisterButton();
//		waitForElementClickable(driver,"//button[@id='register-button']");
//		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
//		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		
		registerPage.clickToContinueButton();
//		waitForElementClickable(driver, "//a[@class='button-1 register-continue-button']");
//		clickToElement(driver, "//a[@class='button-1 register-continue-button']");
	}
	
	@Test
	public void TC_04_Register_Existing_Email() {
		homePage.clickToRegisterLink();
//		waitForElementClickable(driver,"//a[@class='ico-register']");
//		clickToElement(driver,"//a[@class='ico-register']");
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
//		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
//		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
//		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		
		registerPage.clickToRegisterButton();
//		waitForElementClickable(driver,"//button[@id='register-button']");
//		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
//		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6Chars() {
		homePage.clickToRegisterLink();
//		waitForElementClickable(driver,"//a[@class='ico-register']");
//		clickToElement(driver,"//a[@class='ico-register']");
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
//		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
//		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
//		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		sendkeyToElement(driver, "//input[@id='Password']", "12345");
//		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
		
		registerPage.clickToRegisterButton();
//		waitForElementClickable(driver,"//button[@id='register-button']");
//		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\\nmust have at least 6 characters");
//		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
//				"Password must meet the following rules:\nmust have at least 6 characters");
	}
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		homePage.clickToRegisterLink();
//		waitForElementClickable(driver,"//a[@class='ico-register']");
//		clickToElement(driver,"//a[@class='ico-register']");
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("1234567");
//		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
//		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
//		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
		
		registerPage.clickToRegisterButton();
//		waitForElementClickable(driver,"//button[@id='register-button']");
//		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");
//		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
//				"The password and confirmation password do not match.");	
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
