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

public class User_01_Register_Login extends BasePage {

	WebDriver driver;
	
	Random random = new Random();
	int rand = random.nextInt(9999);
	String emailAddress = "vune" + rand + "@yahoo.com";

//	BasePage basePage;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");

//		basePage = getBasePage();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Register_Emty_Data() {
		
		waitForElementClickable(driver,"//a[@class='ico-register']");
		clickToElement(driver,"//a[@class='ico-register']");
		
		waitForElementClickable(driver,"//button[@id='register-button']");
		clickToElement(driver,"//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
		
		waitForElementClickable(driver,"//a[@class='ico-register']");
		clickToElement(driver,"//a[@class='ico-register']");
		
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
		sendkeyToElement(driver, "//input[@id='Email']", "Vu dep trai");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver,"//button[@id='register-button']");
		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_Success() {

		waitForElementClickable(driver,"//a[@class='ico-register']");
		clickToElement(driver,"//a[@class='ico-register']");
		
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver,"//button[@id='register-button']");
		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		
		waitForElementClickable(driver, "//a[@class='button-1 register-continue-button']");
		clickToElement(driver, "//a[@class='button-1 register-continue-button']");
	}
	
	@Test
	public void TC_04_Register_Existing_Email() {
		waitForElementClickable(driver,"//a[@class='ico-register']");
		clickToElement(driver,"//a[@class='ico-register']");
		
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		
		waitForElementClickable(driver,"//button[@id='register-button']");
		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6Chars() {
		waitForElementClickable(driver,"//a[@class='ico-register']");
		clickToElement(driver,"//a[@class='ico-register']");
		
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "12345");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
		
		waitForElementClickable(driver,"//button[@id='register-button']");
		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		waitForElementClickable(driver,"//a[@class='ico-register']");
		clickToElement(driver,"//a[@class='ico-register']");
		
		sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyenvu98");
		sendkeyToElement(driver, "//input[@id='LastName']", "pro");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
		
		waitForElementClickable(driver,"//button[@id='register-button']");
		clickToElement(driver,"//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");	
	}
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
