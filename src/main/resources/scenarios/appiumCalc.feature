@appium
Feature: Appium Example Feature
  #Sample Test Scenario Description

  @appium
  Scenario: Appium Example Scenario
    Given I start application by name "Calculator"
    When add "3" to "5"
    Then result should be "8"

