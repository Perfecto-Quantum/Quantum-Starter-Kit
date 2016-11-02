@tagdd
Feature: community login data driven
  DATAFILE=src/test/resources/data/testData.csv
  #or
  #DATAFILE=src/test/resources/data/testData.xls

  @tagdd
  Scenario: login to community data drive
    Given I open browser to webpage "https://community.perfectomobile.com/"
    When I go to menu page
    And I go to login page
    Then "login.user" must exist
    When I fill user "<username>" and password "<password>"
    And I click on "checkbox.login"
    And I click on "button.submit"
    Then I wait for "5" seconds
    And I click on "button.menu"
    And I take a screenshot
    When I click on "spinner.options"
    Then I click on "button.logout"
    And I take a screenshot
