package org.servicenow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.servicenow.api.ServiceNowProjectSpecificMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SystemAdministrationPage extends ServiceNowProjectSpecificMethods{
	
	//Enter Change in filter navigator
	@Given("User enters change in Filter navigator")
	public SystemAdministrationPage enterChangeInFilterNavigator() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElementById(prop.getProperty("systemAdminstratorPage.searchFilter.id")).sendKeys("change");
		return this;
	}
	
	
	//create new normal Change , press enter
	@Given("User click on create new")
	public ChangeRequestpage clickCreateNew() throws InterruptedException {
		Thread.sleep(5000);
		
		driver.findElementByXPath(prop.getProperty("systemAdminstratorPage.changeCreateNew.xpath")).click();
		return new ChangeRequestpage();
	}
	
	@Then("User validates by finding the created Change request")
	public ChangeRequestpage searchChangeRequest() throws InterruptedException {
		Thread.sleep(5000);
//		driver.findElementById("sysparm_search").clear();
		driver.findElementById(prop.getProperty("systemAdminstratorPage.changeIDSearchBar.id")).sendKeys(CreateChangeRequestPage.changeTicketNumber,Keys.ENTER);
		return new ChangeRequestpage();
	}
	
	@Given("User clicks on All")
	public ChangeRequestpage changeOptionAll() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementByXPath(prop.getProperty("systemAdminstratorPage.changeOptionAll.xpath")).click();
		return new ChangeRequestpage();
	}
	
	
	
	
}
