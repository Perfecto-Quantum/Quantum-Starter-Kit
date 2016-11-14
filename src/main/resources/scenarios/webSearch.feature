@Web
Feature: Google Search

  @WebSearch
  Scenario: Search QMetry
    Given I am on Google Search Page
    When I search for "git qmetry"
    Then it should have "QMetry Automation Framework" in search results

  @WebResultsList
  Scenario: Search QMetry with results
    Given I am on Google Search Page
    When I search for "QAFTestStep"
    Then it should have following search results:
      | QMetry Automation Framework |
      | QAFTestStep                 |

  @WebDD
  Scenario Outline: Search Keyword
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    Examples:
      | recId         | searchKey         | searchResult                          |
      | StackOverflow | QAF StackOverflow | using QAF                             |
      | ISFW          | Selenium ISFW     | InfoStretch Test Automation Framework |