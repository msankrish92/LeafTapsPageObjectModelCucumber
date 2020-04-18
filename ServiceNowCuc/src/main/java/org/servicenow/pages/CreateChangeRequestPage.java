package org.servicenow.pages;

import org.servicenow.api.ServiceNowProjectSpecificMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CreateChangeRequestPage extends ServiceNowProjectSpecificMethods {
	
	public static String changeTicketNumber;
	
	//add short description
	@Given("User enters (.*) in short description field")
	public CreateChangeRequestPage addShortDescription(String shordDescription) {
		driver.findElementById(prop.getProperty("createChangeRequestPage.shortDescription.id")).sendKeys(shordDescription);
		return this;
	}
	
	@Given("User gets Change Ticket Number")
	public CreateChangeRequestPage getChangeTicketNumber() {
		changeTicketNumber = driver.findElementById(prop.getProperty("createChangeRequestPage.changeTicketNumber.id")).getAttribute("value");
		return this;
		
	}
	
	//submit
	@When("User clicks submit Button")
	public ChangeRequestpage clickSubmitButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementByXPath(prop.getProperty("createChangeRequestPage.submitButton.id")).click();
		return new ChangeRequestpage();
		
	}

}
