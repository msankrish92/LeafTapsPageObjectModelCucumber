package org.servicenow.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.servicenow.api.ServiceNowProjectSpecificMethods;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChangeRequestpage extends ServiceNowProjectSpecificMethods {

	// click new normal Change
	@Given("User clicks on new normal change")
	public CreateChangeRequestPage clickNewNormalChange() {
		driver.switchTo().frame(0);
		driver.findElementByXPath(prop.getProperty("changeRequestPage.newNormal.xpath")).click();
		return new CreateChangeRequestPage();
	}

	// find a change request
	@Given("User searches for exististing (.*) and click it")
	public ChangeRequestpage findChangeRequest(String changeTicketNumber) throws InterruptedException {
		Thread.sleep(5000);
		try {
			driver.switchTo().frame(0);
			driver.findElementById(prop.getProperty("changeRequestPage.searchChangeTicketBar.id"))
					.sendKeys(changeTicketNumber, Keys.ENTER);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.findElementByXPath(prop.getProperty("changeRequestPage.getchangeTicket.xpath")).click();
		return this;
	}

	// validate the found change
	@Then("User Validates the Change created")
	public void validateChangeCreated() throws InterruptedException {
		Thread.sleep(3000);
		String CNo = driver.findElementByXPath(prop.getProperty("changeRequestPage.getchangeTicket.xpath")).getText();
		System.out.println(CNo);
		System.out.println(CreateChangeRequestPage.changeTicketNumber);
//		if (CNo.equals(CreateChangeRequestPage.changeTicketNumber)) {
//			System.out.println("Change request created successfully");
//		}

		
			Assert.assertEquals(CreateChangeRequestPage.changeTicketNumber, CNo);
		
	}

	@Given("User updates the state as Assess")
	public ChangeRequestpage updateStateToAssess() {
//		driver.switchTo().frame(0);
		WebElement stateElement = driver.findElementById(prop.getProperty("changeRequestPage.updateState.id"));
		Select state = new Select(stateElement);
		state.selectByVisibleText("Assess");
		return this;
	}

	@Given("User updates the Assigned to ITIL user")
	public ChangeRequestpage changeRequestedByToITILUser() throws InterruptedException {
//		driver.findElementById("sys_display.change_request.assigned_to").clear();
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElementById(prop.getProperty("changeRequestPage.changeRequestedByToSearchIcon.id")).click();
		Thread.sleep(3000);
		Set<String> windowsSet = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowsSet);
		driver.switchTo().window(windowList.get(1));
		driver.findElementByXPath(prop.getProperty("changeRequestPage.changeRequestedByToWindowSearchBar.xpath"))
				.sendKeys("ITIL User", Keys.ENTER);
		driver.findElementByLinkText(prop.getProperty("changeRequestPage.changeRequestedByToWindow.linkedText"))
				.click();
		Thread.sleep(3000);
		driver.switchTo().window(windowList.get(0));
		return this;
	}

	@Given("User updates the Assignment group")
	public ChangeRequestpage assignmentGroupSearchIcon() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementByXPath(prop.getProperty("changeRequestPage.assignmentGroupSearchIcon.xpath")).click();
		Thread.sleep(5000);
		Set<String> windowsSet = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowsSet);
		driver.switchTo().window(windowList.get(1));
		driver.findElementByLinkText(prop.getProperty("changeRequestPage.assignmentGroupwindow.linkedText")).click();
		Thread.sleep(5000);
		driver.switchTo().window(windowList.get(0));
		return this;
	}

	@When("User clicks the Update Button")
	public SystemAdministrationPage clickUpdateButton() throws InterruptedException {
		Thread.sleep(5000);
		try {
			driver.switchTo().frame(0);
		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.sleep(5000);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form_action_button_container']/button")));
		driver.findElementById(prop.getProperty("changeRequestPage.UpdateButton.id")).click();
		try {
			driver.switchTo().frame(1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new SystemAdministrationPage();

	}

	public ChangeRequestpage findChangeRequestByHardCodedValue(String changeTicket) throws InterruptedException {
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElementById("change_request_table_header_search_control").clear();
		driver.findElementById("change_request_table_header_search_control").sendKeys(changeTicket, Keys.ENTER);
		return this;
	}

	@Then("User validates the Assess and Asssign to")
	public ChangeRequestpage getStateValue() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement tbody = driver.findElementByXPath(prop.getProperty("changeRequestPage.searchListedTable.xpath"));
		List<WebElement> tableRow = tbody
				.findElements(By.tagName(prop.getProperty("changeRequestPage.tableRow.tagName")));
		List<WebElement> tableData = tableRow.get(0)
				.findElements(By.tagName(prop.getProperty("changeRequestPage.tableDate.tagName")));

		String stateValue = tableData.get(5).getText();
		String assignedToValue = tableData.get(9).getText();
		System.out.println(stateValue);
		System.out.println(assignedToValue);
		Assert.assertEquals(stateValue, "Assess");
		Assert.assertEquals(assignedToValue, "ITIL User");
//			if(stateValue.equals("Assess")&&assignedToValue.equals("ITIL User")) {
//				System.out.println("Assess validated");
//			}
		return this;

	}

	@Given("User clicks on schedule tab")
	public ChangeRequestpage clickScheduleTab() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementByXPath(prop.getProperty("changeRequestPage.scheduleTab.xpath")).click();
		return this;
	}

	@Given("User Clicks on Calendar Icon")
	public ChangeRequestpage clickCalenderButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementByXPath("//span[@class='icon-calendar icon']").click();
		return this;
	}

	@Given("User Selects planned start date")
	public ChangeRequestpage selectplannedStartDate() {

		driver.findElementByXPath("//td[@class='calText calCurrentDate']/a").click();
		driver.findElementById("GwtDateTimePicker_ok").click();
		return this;
	}

	@Given("User Selects planned End date")
	public ChangeRequestpage userSelectsPlannedEndDate() {

		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("dd");
		String todayDate = sdf.format(date);
		int intTodayDate = Integer.parseInt(todayDate) + 5;
//		System.out.println(intTodayDate + 5);
		driver.findElementByXPath("(//span[@class='icon-calendar icon'])[2]").click();
		driver.findElementByXPath("//a[contains(text(),'" + intTodayDate + "')]").click();
		driver.findElementById("GwtDateTimePicker_ok").click();
		return this;
	}

	@Given("User Clicks on Cab required")
	public ChangeRequestpage clicksCabRequired() {
		driver.findElementById("label.ni.change_request.cab_required").click();
		return this;
	}

	@Given("User clicks on CAB date icon")
	public ChangeRequestpage clickCabDateIcon() {
		driver.findElementByXPath("(//span[@class='icon icon-calendar'])[4]").click();
		return this;
	}

	@Given("User Clicks on CAB date as current Date and click update Button")
	public ChangeRequestpage clickCabDateToCurrentDate() {
		driver.findElementByXPath("//td[@class='calText calCurrentDate']/a").click();
//		driver.findElementById("change_request.cab_date").sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB,Keys.ENTER);
		return this;
	}

	@Then("user validates for start date and end data updation")
	public void validateStartAndEndDate() {
		String startDate = driver.findElementByXPath("(//div[@class='datex date-calendar'])[1]").getText();
		String endDate = driver.findElementByXPath("(//div[@class='datex date-calendar'])[2]").getText();

		Assert.assertNotEquals(startDate, "(empty)");
		Assert.assertNotEquals(endDate, "(empty)");
		System.out.println("Start date and end Date validated successfully");
	}

	@Given("User search for change tickets with State new")
	public ChangeRequestpage enterNewinStateSearch() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElementByXPath("(//div[@class='list_header_search']//input)[4]").sendKeys("new", Keys.ENTER);
		return this;
	}

	@When("User clicks on Delete Button")
	public ChangeRequestpage userClicksDelete() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementById("sysverb_delete").click();
		return this;
	}

	@When("User clicks on Confirmation button")
	public ChangeRequestpage userClicksconfirmationButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementById("ok_button").click();
		return this;
	}
	
	@Then("User Validates the deleted change ticket by searching for it")
	public ChangeRequestpage validateDeletedChangeTicket() throws InterruptedException {
		driver.findElementById("change_request_table_header_search_control").sendKeys(CreateChangeRequestPage.changeTicketNumber,Keys.ENTER);
		Thread.sleep(5000);
		String text = driver.findElementByXPath("//tr[@class='list2_no_records']/td").getText();
		
		Assert.assertEquals(text, "No records to display");
		return this;
		
	}

}
