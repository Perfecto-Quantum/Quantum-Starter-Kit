@appium
Feature: Appium Example Feature
  #Sample Test Scenario Description

  @appium
  Scenario: Appium Example Scenario
    Given I start application by name "Calculator"
    And I am using an AppiumDriver
    When add "3" to "5"
    Then result should be "8"

