
@Web
Feature: Google Search

  @Desktop
  Scenario:  Desktop and Mobile
    Given I am on Google Search Page
    When I search for "quantum perfecto"
    Then it should have "Introducing Quantum Framework" in search results
    Then I am on Google Search Page