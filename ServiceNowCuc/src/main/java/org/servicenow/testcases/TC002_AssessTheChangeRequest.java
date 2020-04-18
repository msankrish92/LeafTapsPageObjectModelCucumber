package org.servicenow.testcases;

import org.servicenow.api.ServiceNowProjectSpecificMethods;
import org.servicenow.pages.ServiceNowLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_AssessTheChangeRequest extends ServiceNowProjectSpecificMethods {
	@BeforeClass
	public void setExcelName() {
		excelPath="TC002_AssessTheChangeRequest";
	}
	
	
	@Test(dataProvider = "getCellValue")
	public void assessTheChangeRequest(String changeTicket) throws InterruptedException {
		new ServiceNowLoginPage()
		.enterUserName()
		.enterPassword()
		.clickLoginButton();
//		.searchChangeRequest(changeTicket)
////		.updateStateToAssess()
//		.assignmentGroupSearchIcon()
//		.changeRequestedByToITILUser()
//		.clickUpdateButton().enterChangeInFilterNavigator().changeOptionAll().findChangeRequestByHardCodedValue(changeTicket).getStateValue();
	}

}
