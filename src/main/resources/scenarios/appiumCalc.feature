@appium
Feature: Appium Example Feature
  #Sample Test Scenario Description

#  @appium
#  Scenario: Appium Example
#    Given I start application by name "Calculator"
#    And I am using an AppiumDriver
#    When clear Calculator
#    And add "3" to "5"
#    Then result should be "8"
#
#  @appium
#  Scenario: Appium Example 2
#    Given I start application by name "Calculator"
#    And I am using an AppiumDriver
#    When clear Calculator
#    And add "6" to "7"
#    Then result should be "13"

 @expenseTracker
Scenario: Verify Expense tracker Login
	Given I start application by id "io.perfecto.expense.tracker"
	Then I should see expense tracker Native login screen
	When I enter "test@perfecto.com" and "test123" in native login screen
	Then I should see expense tracker home screen
	When I enter expense details and save
	Then I should see error popup
	