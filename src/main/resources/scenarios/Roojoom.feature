@roojoom
Feature: Switch Frame Test
  @roojoom
  Scenario: Switch Frame Test
    Given I open browser to webpage "http://nunzioweb.com/iframes-example.htm"
    Then "iframe1" should exist
    Then I switch to "iframe1" frame by element
    Then I click on "iframe1.play"
    Then I ask it to say hi