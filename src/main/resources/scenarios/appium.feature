@appium
Feature: Appium Example Feature
  #Sample Test Scenario Description

 @expenseTracker
Scenario: Verify Expense tracker Login
	Given I start application by id "io.perfecto.expense.tracker"
	Then I should see expense tracker Native login screen
	When I enter "test@perfecto.com" and "test123" in native login screen
	Then I should see expense tracker home screen
	When I enter expense details and save
	Then I should see error popup
	