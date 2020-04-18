package org.servicenow.pages;

import org.servicenow.api.ServiceNowProjectSpecificMethods;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;

public class ServiceNowLoginPage extends ServiceNowProjectSpecificMethods {
	
	@Given("User enters a username")
	public ServiceNowLoginPage enterUserName() {
		driver.switchTo().frame(0);
		driver.findElementById(prop.getProperty("login.username.id")).sendKeys("admin");
		return this;
	}
	
	@Given("User enters a password")
	public ServiceNowLoginPage enterPassword() {
		driver.findElementById(prop.getProperty("login.password.id")).sendKeys("Feb@1234");
		return this;
	}
	
	@Given("User Clicks Login Button")
	public SystemAdministrationPage clickLoginButton() {
		driver.findElementById(prop.getProperty("login.loginButton.id")).click();
		return new SystemAdministrationPage();
	}
	
}
