@mock
Feature: mock test for cucumber
  #DATAFILE=src/test/resources/data/testData.json

  @mock
  Scenario: open community mock scenario
    Given I mock open browser to webpage "https://community.perfectomobile.com/"
    When I go to menu page
