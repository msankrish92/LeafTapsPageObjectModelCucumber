Feature: Change Management

@TC001
Scenario Outline: [TC001] - Create new change

And User enters a username
And User enters a password
And User Clicks Login Button
And User enters change in Filter navigator
And User click on create new
And User clicks on new normal change
And User enters <shortDescription> in short description field
And User gets Change Ticket Number
When User clicks submit Button
Then User validates by finding the created Change request
And User Validates the Change created

Examples:
|shortDescription	|
|Job change			|

@TC002
Scenario Outline: [TC002] - Assess the Change Request

And User enters a username
And User enters a password
And User Clicks Login Button
And User enters change in Filter navigator
And User clicks on All
And User searches for exististing <changeTicketNumber> and click it
And User updates the state as Assess
And User updates the Assignment group
And User updates the Assigned to ITIL user
When User clicks the Update Button
Then User validates the Assess and Asssign to

Examples:
|changeTicketNumber	|
|CHG0030020	|

@TC003
Scenario Outline: [TC003] - Update schedule for the existing Change

And User enters a username
And User enters a password
And User Clicks Login Button
And User enters change in Filter navigator
And User clicks on All
And User searches for exististing <changeTicketNumber> and click it
And User clicks on schedule tab
And User Clicks on Calendar Icon
And User Selects planned start date
And User Selects planned End date
And User Clicks on Cab required
And User clicks on CAB date icon
When User Clicks on CAB date as current Date and click update Button
When User clicks the Update Button
Then user validates for start date and end data updation

Examples:
|changeTicketNumber	|
|CHG0030039		|

@TC004
Scenario Outline: Delete Change Request

And User enters a username
And User enters a password
And User Clicks Login Button
And User enters change in Filter navigator
And User clicks on All
And User search for change tickets with State new
And User searches for exististing (.*) and click it
And User gets Change Ticket Number
When User clicks on Delete Button
And User clicks on Confirmation button
Then User Validates the deleted change ticket by searching for it



Examples:
|changeTicketNumber	|
|		|





