@sampletag
Feature: community search sample

  @sampletag
  Scenario: enter quick links post in community
    Given I open browser to webpage "https://community.perfectomobile.com/"
    And I wait for "5" seconds
    Then I must see text "Perfecto Quick Links"
    When I click on "button.search"
    And I enter "Sellenium" to "community.search"
    And I wait for "5" seconds
    Then I must see text "Popular"

  @sampletag
  Scenario: search community
    Given I open browser to webpage "https://community.perfectomobile.com/"
    And I wait for "5" seconds
    When I click on "button.search"
    And I enter "appium" to "community.search"
    And I wait for "5" seconds
    Then I must see text "Popular"

