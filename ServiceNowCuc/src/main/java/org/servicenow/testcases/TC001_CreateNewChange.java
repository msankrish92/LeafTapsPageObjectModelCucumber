package org.servicenow.testcases;

import org.servicenow.api.ServiceNowProjectSpecificMethods;
import org.servicenow.pages.ServiceNowLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_CreateNewChange extends ServiceNowProjectSpecificMethods {
	
	@BeforeClass
	public void setExcelName() {
		excelPath="TC001_CreateNewChange";
	}
	
	
	
	@Test(dataProvider = "getCellValue")
	public void createNewChange(String shortDescription) throws InterruptedException {
		new ServiceNowLoginPage()
		.enterUserName()
		.enterPassword()
		.clickLoginButton()
		.enterChangeInFilterNavigator()
		.clickCreateNew()
		.clickNewNormalChange()
		.addShortDescription(shortDescription)
		.getChangeTicketNumber()
		.clickSubmitButton().findChangeRequest().validateChangeCreated();
	}
	
	
}
