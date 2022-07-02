package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(id = "email")WebElement email;
@FindBy(id = "password")WebElement pass;
@FindBy(xpath = "//button")WebElement button;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String uname, String passw) {
		email.sendKeys(uname);
		pass.sendKeys(passw);
		button.click();
	}

}
