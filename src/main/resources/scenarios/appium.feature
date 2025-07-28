@appium
Feature: Appium Example Feature
  #Sample Test Scenario Description

 @expenseTracker
  Scenario: Verify Expense tracker Login
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen
    #When I enter "test@perfecto.com" and "test123" in native login screen
    #Then I should see expense tracker home screen
    #When I enter expense details and save
    #Then I should see error popup

 @expenseTracker
  Scenario: Verify Expense tracker Login - 1
    Given I start application by id "io.perfecto.expense.tracker"
    Then I should see expense tracker Native login screen	
    
@SC-Demo
   Scenario: Perform Accessibility Checks on SC Play store App
   	 Given I start application by id "com.sbg.mobile.phone"
   	 Then I run the accessibility audit on "Welcome Screen"
   	 When I accept all the notification pop up
   	 Then I run the accessibility audit on "Getting Started Screen"
   	 Then I skip the Getting Started flow
   	 Then I run the accessibility audit on "Manage Location Service Screen"
   	 Then I accepted the manage location service
   	 Then I run the accessibility audit on "Location Screen"