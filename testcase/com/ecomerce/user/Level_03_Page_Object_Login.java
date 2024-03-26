package com.ecomerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class Level_03_Page_Object_Login {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, validEmail, invalidEmail, notFoundEmail, password;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		
		firstName = "vu98";
		lastName = "vo";
		invalidEmail = "abc";
		notFoundEmail = "abc@abc.com";
		validEmail ="vupro"+ randomNumber() +"@yahoo.com";
		password = "123456";
//				
//		System.out.println("Precondition - Step 01: Click to Register Link");
//		homePage.clickToRegisterLink();
//		
//		registerPage = new RegisterPageObject(driver);
//		
//		System.out.println("Precondition - Step 02: Input to required fields");		
//		registerPage.inputToFirstNameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox(emailAddress);
//		registerPage.inputToPasswordTextbox(password);
//		registerPage.inputToConfirmPasswordTextbox(password);
//		
//		System.out.println("Precondition - Step 03: Click to Register Button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Precondition - Step 04: Verify success message displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
//		
//		System.out.println("Precondition - Step 05: Click to Continue Button");
//		registerPage.clickToContinueButton();
//		
//		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01 - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		System.out.println("Login_01 - Step 02: Click to Login Button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");

	}
	
	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_01 - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		System.out.println("Login_02 - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(invalidEmail);
		
		System.out.println("Login_02 - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_02 - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		System.out.println("Login_03 - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		System.out.println("Login_03 - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(notFoundEmail);
		
		System.out.println("Login_03 - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_03 - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.println("Login_04 - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		System.out.println("Login_04 - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox("");
		
		System.out.println("Login_04 - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_04 - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}
	
	@Test
	public void Login_05_Existing_Email_Wrong_Password() {
		System.out.println("Login_05 - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		System.out.println("Login_05 - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox("654321");
		
		System.out.println("Login_05 - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_05 - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_06_Existing_Email_Right_Password() {
		System.out.println("Login_06 - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		System.out.println("Login_06 - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("Login_06 - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		
		System.out.println("Login_06 - Step 03: Verify error message displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		homePage.clickMyAccountLink();
	}
	
	
	private int randomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
