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
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_Login {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress, password;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		
//		firstName = "vu98";
//		lastName = "vo";
//		emailAddress ="vupro"+ randomNumber() +"@yahoo.com";
//		password = "123456";
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
		
		System.out.println("Register_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");

	}
	
	@Test
	public void Login_02_Invalid_Email() {
		
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
	
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
	
	}
	
	@Test
	public void Login_05_Existing_Email_Wrong_Password() {
	
	}
	
	@Test
	public void Login_06_Existing_Email_Right_Password() {
	
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
